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
    public Faculty updateFaculty(Long faculty_id,Faculty faculty) {
        Faculty oldFaculty = facultyRepository.findById(faculty_id).get();

        if((facultyRepository.existsById(oldFaculty.getFaculties_id()))
                && !(facultyRepository.findByName(oldFaculty.getFaculty_name()).getFaculty_name().equals(faculty.getFaculty_name()))){

            oldFaculty.setFaculty_name(faculty.getFaculty_name());
        }

        return facultyRepository.save(faculty);
    }



}
