package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.Lectures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturesRepository extends JpaRepository<Lectures,Long> {

    Lectures findByLectureCode(String code);

    Lectures findByDepartmentId(Long department_id);
}
