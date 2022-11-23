package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;


    public Departments getDepartments(String dept_name){

        return departmentRepository.findByName(dept_name);
    }
}
