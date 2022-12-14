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

    public Lectures updateLecture(Lectures lectures){
        Lectures temp = lecturesRepository.findById(lectures.getLectures_id()).get();
        if(lecturesRepository.existsById(lectures.getLectures_id())){
            /*
            * update operation will be doing
            *  */
            temp.setLecture_code(lectures.getLecture_code());
            temp.setLecture_name(lectures.getLecture_name());
            temp.setDepartments_id(lectures.getDepartments_id());

        }
        return lecturesRepository.save(temp);



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
