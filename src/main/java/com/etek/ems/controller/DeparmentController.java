package com.etek.ems.controller;

import java.util.List;

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

import com.etek.ems.entity.Department;
import com.etek.ems.exception.RecordNotFoundException;
import com.etek.ems.service.DepartmentService;


@RestController
@RequestMapping("/deparments")
public class DeparmentController
{
    @Autowired
    DepartmentService service;
 
    @GetMapping
    public ResponseEntity<List<Department>> getAllEmployees() {
        List<Department> list = service.getAllDepartments();
 
        return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getEmployeeById(@PathVariable("departmentId") Long id)
                                                    throws RecordNotFoundException {
        Department entity = service.getDepartmentById(id);
 
        return new ResponseEntity<Department>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Department> createOrUpdateEmployee(@RequestBody Department department)
                                                    throws RecordNotFoundException {
        Department updated = service.createOrUpdateDepartment(department);
        return new ResponseEntity<Department>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("departmentId") Long departmentId)
                                                    throws RecordNotFoundException {
        service.deleteDepartmentById(departmentId);
        return HttpStatus.ACCEPTED;
    }
 
}