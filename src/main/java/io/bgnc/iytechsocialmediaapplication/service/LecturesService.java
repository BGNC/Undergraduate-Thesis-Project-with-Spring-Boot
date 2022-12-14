package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Lectures;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.LecturesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class LecturesService {

    @Autowired
    private LecturesRepository lecturesRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Lectures> getAllLectures(){
        return lecturesRepository.findAll();
    }

    public Lectures findByLectureCode(String code){

        return lecturesRepository.findByLectureCode(code);
    }

    public void deleteLect(Long lectures_id){
        if(lecturesRepository.existsById(lectures_id)){
            log.info("Lesson {} # is deleted",lectures_id);
            lecturesRepository.deleteById(lectures_id);
        }

    }

    public Lectures saveLectures(Lectures lectures){



    }



}
