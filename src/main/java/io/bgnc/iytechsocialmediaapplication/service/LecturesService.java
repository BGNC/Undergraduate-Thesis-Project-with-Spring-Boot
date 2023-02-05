package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Lectures;
import io.bgnc.iytechsocialmediaapplication.repository.DepartmentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.LecturesRepository;
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
    public Lectures saveLecture(Lectures lectures) throws IllegalAccessException {


        List<Lectures> allLectures = getAllLectures();

        for (int i = 0 ; i < allLectures.size();i++){
            if(
                    allLectures.get(i).getDepartments_id().
                            equals(departmentRepository.findById(lectures.getDepartments_id().get(i).getDept_id()))
                    && !(lecturesRepository.existsById(lectures.getLectures_id()))
                    && allLectures.get(i).getLecture_code().equals(lectures.getLecture_code()))
            {


                throw new IllegalAccessException();
            }


        }

        return lecturesRepository.save(lectures);


    }



}
