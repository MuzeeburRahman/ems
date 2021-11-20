package com.etek.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etek.ems.entity.Employee;
import com.etek.ems.exception.RecordNotFoundException;
import com.etek.ems.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController
{
	final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	 @Autowired
	    EmployeeService service;
	 
	    @GetMapping
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> list = service.getAllEmployees();
	 
	        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException
	                                                     {
	        Employee entity = service.getEmployeeById(id);
	 
	        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @PostMapping
	   // @ExceptionHandler(value = {Exception.class})
	    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody @Valid Employee employee)
	                                                    {
	        Employee updated = service.createOrUpdateEmployee(employee);
	        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.CREATED);
	        
	    }
	 
	    @DeleteMapping("/{id}")
	    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        service.deleteEmployeeById(id);
	        return HttpStatus.FORBIDDEN;
	    }
 
}