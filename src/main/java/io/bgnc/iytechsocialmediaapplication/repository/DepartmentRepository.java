package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments,Long> {

    Departments findByName(String dept_name);
}
