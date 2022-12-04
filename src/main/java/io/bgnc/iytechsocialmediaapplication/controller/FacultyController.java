package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;


    @GetMapping("")
    public List<Faculty> getAllFaculties(){

        return facultyService.getAllFaculties();

    }

    @PutMapping("/updateFaculty")
    public Faculty updateFaculty( @RequestBody String faculty_name) throws IllegalAccessException {
        return facultyService.updateFaculty(faculty_name);
    }

    @PostMapping("/saveFaculty")
    public Faculty addFaculty(@RequestBody Faculty faculty){

        return facultyService.saveFaculty(faculty);

    }
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id){
         facultyService.deleteFaculty(id);
    }


}
