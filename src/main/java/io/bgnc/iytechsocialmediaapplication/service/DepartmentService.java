package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private FacultyRepository facultyRepository;


    public Departments getDepartmentsByName(String dept_name){

        return departmentRepository.findByName(dept_name);
    }

    public Departments getDepartmentsByFaculty(Faculty faculty){
        return departmentRepository.findByFacultyId(facultyRepository.findById(faculty.getFaculties_id()));
    }

    public void deleteDepartment(Long dept_id){
        if(departmentRepository.existsById(dept_id))
            departmentRepository.deleteById(dept_id);

    }

    public List<Departments> getAllDepartments(){
        return departmentRepository.findAll();
    }


}
