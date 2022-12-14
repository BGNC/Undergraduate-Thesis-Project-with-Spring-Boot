package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.repository.CommentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.PostRepository;
import io.bgnc.iytechsocialmediaapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;



    public void deleteComment(Long comment_id){
        if(commentRepository.existsById(comment_id))
            commentRepository.deleteById(comment_id);

    }

}
