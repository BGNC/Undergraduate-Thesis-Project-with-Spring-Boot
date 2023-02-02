package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.repository.CommentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.PostRepository;
import io.bgnc.iytechsocialmediaapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentService(UserRepository userRepository,
                          PostRepository postRepository,
                          CommentRepository commentRepository)
    {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }






    public void deleteComment(Long comment_id){
        if(commentRepository.existsById(comment_id))
            commentRepository.deleteById(comment_id);

    }

}
