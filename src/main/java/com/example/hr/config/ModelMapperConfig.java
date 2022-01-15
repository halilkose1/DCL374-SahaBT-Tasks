package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.dto.request.UpdateEmployeeRequest;

@Configuration
public class ModelMapperConfig {
	private static final Converter<UpdateEmployeeRequest,EmployeeDocument>
	   UPDATE_EMPLOYEE_REQUEST_TO_EMPLOYEE_DOCUMENT_CONVERTER =
	   (context) -> {
		  var source = context.getSource();
		  var destination = context.getDestination();
		  destination.setFullname(source.getFullname().toLowerCase());
		  destination.setSalary(source.getSalary());
		  destination.setIban(source.getIban());	
		  destination.setFulltime(source.getFulltime());
		  destination.setPhoto(source.getPhoto());
		  destination.setDepartment(source.getDepartment());
		  return destination;
	   };
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(
				UPDATE_EMPLOYEE_REQUEST_TO_EMPLOYEE_DOCUMENT_CONVERTER, 
				UpdateEmployeeRequest.class, EmployeeDocument.class);
		return modelMapper;
	}
}
