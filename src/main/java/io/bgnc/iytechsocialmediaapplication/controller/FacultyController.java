package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    public List<Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();

    }
    public Faculty getFaculty(String faculty_name){
        return facultyService.getFaculty(faculty_name);

    }

    public Faculty addFaculty(Faculty faculty){

        List<Faculty> facultyList = getAllFaculties();

        if(facultyList.contains(faculty)){
            throw new RuntimeException("Faculty is already");
        }
        else
        {
            return facultyService.addFaculty(faculty);
        }

    }


}
