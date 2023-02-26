package io.bgnc.iytechsocialmediaapplication.repository.abstracts;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment  getCommentByUser_id(Long userId);




}
