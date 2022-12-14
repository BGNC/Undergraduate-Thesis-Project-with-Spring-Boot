package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
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

    public Departments saveDepartment(Departments departments) {
        Faculty faculty = departments.getFaculties_id();

        List<Departments> getAllDept = getAllDepartments();
        if(facultyRepository.existsById(faculty.getFaculties_id())){
            if(!(departmentRepository.existsById(departments.getDept_id()))){
                if(!(getAllDept.contains(departments))){

                    return departmentRepository.save(departments);
                }

            }
            else{
                log.warn("Department is already added");
                throw new IllegalStateException();
            }

        }
        else{
            log.warn("Faculty does not find");
            throw new IllegalStateException();
        }

        return departmentRepository.save(departments);

    }







    public void deleteDepartment(Long dept_id){

        if(departmentRepository.existsById(dept_id))
            departmentRepository.deleteById(dept_id);

    }

    public List<Departments> getAllDepartments(){
        return departmentRepository.findAll();
    }



}
