package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Semester;
import io.bgnc.iytechsocialmediaapplication.repository.SemesterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }


    public List<Semester> getAllSemesters() {

        return semesterRepository.findAll();
    }

    public Semester saveSemester(Semester semester){

        List<Semester> semesters = getAllSemesters();

        if(semesters.contains(semester)){
            throw new ArrayIndexOutOfBoundsException("The semester is already in database so we cannot put ");
        }
        return semesterRepository.save(semester);
    }



    public void deleteSemesterById(Long id) {
        semesterRepository.deleteById(id);
    }
}
