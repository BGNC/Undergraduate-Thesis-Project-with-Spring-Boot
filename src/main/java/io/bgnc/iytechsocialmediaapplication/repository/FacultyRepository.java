package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    Faculty findByName(String faculty_name);
}
