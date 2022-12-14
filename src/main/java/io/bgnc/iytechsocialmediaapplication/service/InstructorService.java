package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Instructor;
import io.bgnc.iytechsocialmediaapplication.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;



    public List<Instructor> getAllInstructor(){
        return instructorRepository.findAll();
    }
    public Instructor addInstructor(Instructor instructor){
        String instructor_mail  =   instructor.getInstructor_mail();

        List<Instructor> instructorList = getAllInstructor();
        if(instructorList.contains(instructor)){
            throw new ArrayStoreException();
        }
        else{
            for(int i = 0 ; i < instructorList.size();i++){
                if(instructorList.get(i).getInstructor_mail().equals(instructor_mail)){
                    throw new ArrayStoreException();
                }
                else{

                    return instructorRepository.save(instructor);

                }
            }
        }

        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor){




        return null;

    }
    public void deleteInstructorById(Long id){

        instructorRepository.deleteById(id);
        log.info("The instructor who has {} is deleted",id);
    }

    public Instructor findByMail(String instructorMail) {
        return instructorRepository.findByMail(instructorMail);
    }
}
