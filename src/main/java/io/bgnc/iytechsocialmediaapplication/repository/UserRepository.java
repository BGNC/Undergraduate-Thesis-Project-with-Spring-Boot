package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{


    User findByUserId(Long id);
    User findByUsername(String username);
    User findByStudent_no(String student_no);





}
