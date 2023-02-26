package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Lectures;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.LecturesRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class LecturesService {


    private final LecturesRepository lecturesRepository;

    private final DepartmentRepository departmentRepository;

    public LecturesService(LecturesRepository lecturesRepository, DepartmentRepository departmentRepository) {
        this.lecturesRepository = lecturesRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Lectures> getAllLectures(){
        return lecturesRepository.findAll();
    }


    public Lectures findByDepartmentId(Long department_id){
        return lecturesRepository.findById(departmentRepository.findById(department_id).get().getDept_id()).get();

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

    public Lectures updateLecture(Lectures lectures,Long lecture_id){

        Lectures oldLecture = lecturesRepository.findById(lecture_id).get();

        if(lecturesRepository.existsById(oldLecture.getLectures_id())){

            for (int i = 0 ; i < getAllLectures().size();i++){
                if(departmentRepository.existsById(lectures.getDepartments_id().get(i).getDept_id())){
                    oldLecture.setLecture_name(lectures.getLecture_name());
                    oldLecture.setDepartments_id(lectures.getDepartments_id());
                    oldLecture.setLecture_code(lectures.getLecture_code());
                }

            }
        }

        return lecturesRepository.save(oldLecture);




    }
    public Lectures saveLecture(Lectures lectures) {


        List<Lectures> allLectures = getAllLectures();

        if((allLectures.contains(lectures))){
            log.warn("The lecture is contained {}"+lectures.getLecture_name());
        }


        return lecturesRepository.save(lectures);


    }



}
