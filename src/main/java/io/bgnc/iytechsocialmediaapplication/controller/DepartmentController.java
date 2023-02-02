package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

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

    @PutMapping("/updateDepartment/{dept_id}")
    public Departments updateDepartment(@PathVariable Long dept_id,@RequestBody Departments departments) throws Exception {
        return departmentService.updateDepartment(dept_id,departments);

    }

    @GetMapping("")
    public List<Departments> getAllDepartments(){

        return departmentService.getAllDepartments();
    }



}
