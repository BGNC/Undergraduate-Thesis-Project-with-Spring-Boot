package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Instructor;
import io.bgnc.iytechsocialmediaapplication.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@Slf4j
public class InstructorController {

    @Autowired
    private  InstructorService instructorService;


    @GetMapping("/findByMail/{instructorMail}")
    public Instructor searchInstructorByMail(@PathVariable String instructorMail){
        return instructorService.findByMail(instructorMail);

    }
    @GetMapping("")
    public List<Instructor> getAllInstructor(){
        return instructorService.getAllInstructor();

    }
    @PutMapping("/updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.updateInstructor(instructor);

    }
    @PostMapping(value = "/addInstructor",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Instructor addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }
    @DeleteMapping("deleteInstructor/{id}")
    public void deleteInstructorById(@PathVariable Long id){
        instructorService.deleteInstructorById(id);
    }



}
