package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Instructor;
import io.bgnc.iytechsocialmediaapplication.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@Slf4j
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/findByMail/{instructorMail}")
    public Instructor searchInstructorByMail(@PathVariable String instructorMail){
        return instructorService.findByMail(instructorMail);

    }
    @GetMapping("")
    public List<Instructor> getAllInstructor(){
        return instructorService.getAllInstructor();

    }
    @PutMapping("/updateInstructor/{instructor_id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor,@PathVariable Long instructor_id){
        return instructorService.updateInstructor(instructor,instructor_id);

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
