package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SemesterRepository extends JpaRepository<Semester,Long> {

    Semester findBySemesterName(String semester_name);

}
