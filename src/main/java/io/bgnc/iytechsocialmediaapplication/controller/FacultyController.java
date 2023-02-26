package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("")
    public List<Faculty> getAllFaculties(){

        return facultyService.getAllFaculties();

    }

    @PutMapping("/updateFaculty/{faculty_id}")
    public Faculty updateFaculty( @PathVariable Long faculty_id,@RequestBody Faculty faculty) throws IllegalAccessException {
        return facultyService.updateFaculty(faculty_id,faculty);
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
