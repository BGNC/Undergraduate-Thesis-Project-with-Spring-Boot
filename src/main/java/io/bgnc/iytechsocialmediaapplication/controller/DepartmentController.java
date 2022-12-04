package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    public Departments getDepartmentsByName(@RequestBody String dept_name){

        return departmentService.getDepartmentsByName(dept_name);
    }

    @GetMapping("/faculty")
    public Departments getDepartmentsByFaculty(@RequestBody Faculty faculty){

        return departmentService.getDepartmentsByFaculty(faculty);

    }

    @GetMapping("")
    public List<Departments> getAllDepartments(){

        return departmentService.getAllDepartments();
    }



}
