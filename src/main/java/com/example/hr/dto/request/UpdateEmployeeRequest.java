package com.example.hr.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.hr.document.Department;
import com.example.validation.Iban;

public class UpdateEmployeeRequest {
	@NotBlank
	private String fullname;	
	private double salary;
	@Iban
	private String iban;
	private Boolean fulltime;
	private String photo;
	@NotNull
	private Department department;
	public UpdateEmployeeRequest() {
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Boolean getFulltime() {
		return fulltime;
	}
	public void setFulltime(Boolean fulltime) {
		this.fulltime = fulltime;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
