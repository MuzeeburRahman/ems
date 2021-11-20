package com.etek.ems.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etek.ems.entity.Department;
import com.etek.ems.exception.RecordNotFoundException;
import com.etek.ems.repository.DepartmentRepository;
 
@Service
public class DepartmentService implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
    DepartmentRepository repository;
     
    public List<Department> getAllDepartments()
    {
    
        List<Department> DepartmentList = repository.findAll();
         
        if(DepartmentList.size() > 0) {
            return DepartmentList;
        } else {
            return new ArrayList<Department>();
        }
    }
     
    public Department getDepartmentById(Long id) throws RecordNotFoundException
    {
        Optional<Department> department = repository.findById(id);
         
        if(department.isPresent()) {
            return department.get();
        } else {
            throw new RecordNotFoundException("No Department record exist for given id");
        }
    }
     
    public Department createOrUpdateDepartment(Department entity) throws RecordNotFoundException
    {
        	
    	Optional<Department> department = repository.findById( entity.getDepartmentId());
        
         
        if(department.isPresent())
        {
            Department newEntity = department.get();
            
            BeanUtils.copyProperties(entity, newEntity);
            
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
        	
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteDepartmentById(Long id) throws RecordNotFoundException
    {
        Optional<Department> Department = repository.findById(id);
         
        if(Department.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Department record exist for given id");
        }
    }
}