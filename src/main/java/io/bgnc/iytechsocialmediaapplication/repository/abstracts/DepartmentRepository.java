package io.bgnc.iytechsocialmediaapplication.repository.abstracts;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Departments;
import io.bgnc.iytechsocialmediaapplication.model.concretes.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Departments,Long> {

    Departments findByName(String dept_name);

    Departments findByFacultyId(Optional<Faculty> byId);


}
