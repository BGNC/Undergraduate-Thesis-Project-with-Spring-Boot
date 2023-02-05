package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Lectures;
import io.bgnc.iytechsocialmediaapplication.repository.LecturesRepository;
import io.bgnc.iytechsocialmediaapplication.service.LecturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LecturesController {


    private final LecturesService lecturesService;

    public LecturesController(LecturesService lecturesService) {
        this.lecturesService = lecturesService;
    }


    @GetMapping("/")
    public List<Lectures> getAllLectures(){
        return lecturesService.getAllLectures();
    }
    @GetMapping("/{lecture_code}")
    public Lectures findByLectureCode(@PathVariable String lecture_code){
        return lecturesService.findByLectureCode(lecture_code);
    }
    @DeleteMapping("/deleteLectures/{lectures_id}")
    public void deleteLectures(@PathVariable Long lectures_id){

        lecturesService.deleteLect(lectures_id);
    }

    @PostMapping("/saveLectures")
    public Lectures saveLecture(@RequestBody Lectures lectures)  {
        return lecturesService.saveLecture(lectures);
    }

    @PutMapping("/updateLectures/{lecture_id}")
    public Lectures updateLecture(@RequestBody Lectures lectures,@PathVariable Long lecture_id){
        return lecturesService.updateLecture(lectures,lecture_id);

    }
}
