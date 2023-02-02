package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.FacultyRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    private DepartmentRepository departmentRepository;

    public FacultyService(FacultyRepository facultyRepository, DepartmentRepository departmentRepository) {
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }


    public Faculty saveFaculty(Faculty faculty){
        List<Faculty> facultyList = getAllFaculties();

        if(facultyList.contains(faculty)){
            throw new ArrayStoreException();
        }
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id){

        if(facultyRepository.existsById(id)) {

            facultyRepository.deleteById(id);
            for(int i = 0 ; i < departmentRepository.findAll().size();i++){
                if(departmentRepository.existsById(id)){
                    departmentRepository.deleteById(id);
                }
            }
        }

    }
    public Faculty updateFaculty(String faculty_name) throws IllegalAccessException {
        Faculty faculty = facultyRepository.findByName(faculty_name);

        List<Faculty> facultyList = getAllFaculties();


        if(facultyList.contains(faculty)){
            throw new IllegalAccessException();
        }else{
            for (int i = 0 ; i < facultyList.size();i++){
                if(facultyList.get(i).getFaculty_name().equals(faculty_name)){
                    throw new IllegalAccessException();
                }
                else{
                    faculty.setFaculty_name(faculty_name);
                }
            }
        }
        return facultyRepository.save(faculty);
    }



}
