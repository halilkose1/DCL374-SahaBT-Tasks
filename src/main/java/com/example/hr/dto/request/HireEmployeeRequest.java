package com.example.hr.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.hr.document.Department;
import com.example.validation.Iban;
import com.example.validation.TcKimlikNo;

public class HireEmployeeRequest {
	@TcKimlikNo
	private String identity;
	@Size(min=5)
	private String fullname;	
	@Min(4_250)
	private double salary;
	@Iban
	private String iban;
	private Boolean fulltime;
	@Max(2002)
	private int birthYear;
	private String photo;
	@NotNull
	private Department department;
	
	public HireEmployeeRequest() {
	}
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
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
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
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
