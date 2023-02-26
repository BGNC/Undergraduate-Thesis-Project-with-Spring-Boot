package io.bgnc.iytechsocialmediaapplication.repository.abstracts;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Lectures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturesRepository extends JpaRepository<Lectures,Long> {

    Lectures findByLectureCode(String code);


}
