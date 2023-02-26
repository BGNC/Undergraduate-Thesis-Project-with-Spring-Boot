package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Departments;
import io.bgnc.iytechsocialmediaapplication.model.concretes.Faculty;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DepartmentService {


    private DepartmentRepository departmentRepository;
    private FacultyRepository facultyRepository;

    public DepartmentService(DepartmentRepository departmentRepository, FacultyRepository facultyRepository) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }


    public Departments getDepartmentsByName(String dept_name){

        return departmentRepository.findByName(dept_name);
    }

    public Departments getDepartmentsByFaculty(Long facultyId){
        return departmentRepository.findByFacultyId(facultyRepository.findById(facultyId));
    }

    public Departments saveDepartment(Departments departments) {
        Faculty faculty = departments.getFaculties_id();

        List<Departments> getAllDept = getAllDepartments();
        if(!(facultyRepository.existsById(faculty.getFaculties_id()))){
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
            if(facultyRepository.existsById(departmentRepository.findById(dept_id).get().getFaculties_id().getFaculties_id())){
                departmentRepository.deleteById(dept_id);
            }


    }


    public List<Departments> getAllDepartments(){

        return departmentRepository.findAll();
    }


    public Departments updateDepartment(Long dept_id,Departments departments) throws Exception {

        Departments oldDept = departmentRepository.findById(dept_id).get();

        if(departmentRepository.existsById(oldDept.getDept_id())
                &&
                facultyRepository.
                        existsById
                        (departmentRepository.
                                findById(dept_id)
                                .get()
                                .getFaculties_id()
                                .getFaculties_id())){



            if(facultyRepository.
                    existsById
                            (departmentRepository.
                                    findById
                                            (departments.getDept_id())
                                    .get().
                                    getFaculties_id().
                                    getFaculties_id())){



                oldDept.setFaculties_id(departments.getFaculties_id());
                oldDept.setDept_name(departments.getDept_name());
                oldDept.setDept_shortname(departments.getDept_shortname());


            }
            else
                throw new Exception("Faculty Id is error");



        }

        else
            throw new RuntimeException("Department is not found with Id : {}"+dept_id);

        return departmentRepository.save(oldDept);



    }
}
