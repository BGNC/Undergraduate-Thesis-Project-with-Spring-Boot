package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @GetMapping("/getDepartmentByName")
    public Departments getDepartmentsByName(@RequestBody String dept_name){

        return departmentService.getDepartmentsByName(dept_name);
    }

    @PostMapping("/saveDepartment")
    public Departments saveDepartment(@RequestBody Departments departments){
        return departmentService.saveDepartment(departments);
    }

    @GetMapping("/faculty/{facultyId}")
    public Departments getDepartmentsByFaculty(@PathVariable Long facultyId){

        return departmentService.getDepartmentsByFaculty(facultyId);

    }
    @DeleteMapping("/deleteDepartment/{dept_id}")
    public void deleteDepartment(@PathVariable Long dept_id){
        departmentService.deleteDepartment(dept_id);
    }

    @GetMapping("")
    public List<Departments> getAllDepartments(){

        return departmentService.getAllDepartments();
    }



}
