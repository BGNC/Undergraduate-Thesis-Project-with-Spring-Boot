package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.Comment;
import io.bgnc.iytechsocialmediaapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;


public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment  getCommentByUser_id(Long userId);




}
