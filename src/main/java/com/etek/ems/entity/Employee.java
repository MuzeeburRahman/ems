package com.etek.ems.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "EMPLOYEE")
@Validated
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "first_name")
	@NotNull
	@Length(min=3, max=25, message = "first_name should be  more than 2 Char")
	private String firstname;

	@NotNull
	@Length(min=3, max=25, message = "last_name should be  more than 2 Char")
	@Column(name = "last_name")
	private String lastname;

	@Column(name = "hire_date")
	private Date hireDate;

	@Pattern(regexp = "^[\\d -]+$", message = "phone_number contain only digits and dashs")
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull(message = "salary may not be empty")
	@Min(value = 1, message = "salary must be greater than 0")
	@Column(name = "salary")
	private Double salary;

	@Column(name = "manager_id")
	private Long managerId;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "department_id", insertable = false, updatable = false)
	private Department department;

	public Employee() {
		super();

	}

	public Employee(Long employeeId, String firstname, String lastname, Date hireDate, String phoneNumber,
			Double salary, Long managerId, String email) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.hireDate = hireDate;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.managerId = managerId;
		this.email = email;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
