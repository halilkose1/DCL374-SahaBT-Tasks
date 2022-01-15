package com.example.hr.application.business;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.exception.EmployeeAlreadyExistException;
import com.example.hr.application.business.exception.EmployeeNotFoundException;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.UpdateEmployeeRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.FireEmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;
import com.example.hr.repository.EmployeeMongoRepository;

@Service
public class StandardHrApplication implements HrApplication {
	
	private EmployeeMongoRepository employeeMongoRepository;
	private ModelMapper modelMapper;
	
	public StandardHrApplication(EmployeeMongoRepository employeeMongoRepository,ModelMapper modelMapper) {
		this.employeeMongoRepository = employeeMongoRepository;
		this.modelMapper=modelMapper;
	}
	
	
	@Override
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		String identity = request.getIdentity();
		if (employeeMongoRepository.existsById(identity)) {
			throw new EmployeeAlreadyExistException();
		}		
		var employee = modelMapper.map(request, EmployeeDocument.class);
		employee = employeeMongoRepository.save(employee);	
		return modelMapper.map(employee, HireEmployeeResponse.class);
	}

	@Override
	public EmployeeResponse updateEmployee(String identity,UpdateEmployeeRequest request) {
		var employee = employeeMongoRepository.findById(identity).orElseThrow(() -> new EmployeeNotFoundException());
		modelMapper.map(request, employee);
		employee.setIdentity(identity);
		return modelMapper.map(employeeMongoRepository.save(employee), EmployeeResponse.class);
	}

	@Override
	public FireEmployeeResponse fireEmployee(String identity) {
		var employee = employeeMongoRepository.findById(identity).orElseThrow(() -> new EmployeeNotFoundException());
		employeeMongoRepository.delete(employee);
		return modelMapper.map(employee, FireEmployeeResponse.class);
	}

	@Override
	public List<EmployeeResponse> findEmployees(@Min(0) int page, @Max(25) int size) {
		var pg = PageRequest.of(page, size);
		return employeeMongoRepository.findAll(pg).stream().map(emp -> modelMapper.map(emp, EmployeeResponse.class))
				.toList();
	}

	@Override
	public EmployeeResponse findEmployeeByIdentity(String identity) {
		var employee = employeeMongoRepository.findById(identity).orElseThrow(() -> new EmployeeNotFoundException());
		return modelMapper.map(employee, EmployeeResponse.class);
	}

}
