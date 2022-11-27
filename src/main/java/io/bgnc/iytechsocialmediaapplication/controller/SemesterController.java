package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Semester;
import io.bgnc.iytechsocialmediaapplication.service.SemesterService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semester")

@Slf4j
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }


    @GetMapping("")
    public List<Semester> getAllSemesters(){
        return semesterService.getAllSemesters();
    }

    @DeleteMapping("{id}")
    public void deleteSemesterById(@PathVariable Long id){
        semesterService.deleteSemesterById(id);
    }
}
