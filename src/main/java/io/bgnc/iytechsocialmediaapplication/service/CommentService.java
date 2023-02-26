package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Comment;
import io.bgnc.iytechsocialmediaapplication.model.concretes.User;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.CommentRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.PostRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.UserRepository;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentService(UserRepository userRepository,
                          PostRepository postRepository,
                          CommentRepository commentRepository)
    {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public HashMap<User,Comment> getAllCommentsByUserId(Long userId){

        HashMap<User,Comment> userComments = new HashMap<>();

        for (int i = 0 ; i < getAllComments().size();i++){
            userComments.put(userRepository.findByUserId(userId),commentRepository.getCommentByUser_id(userId));
        }
        return userComments;
    }

    public void deleteComment(Long comment_id){

        if(commentRepository.existsById(comment_id))
            commentRepository.deleteById(comment_id);

    }

    public Comment saveComment(Comment comment) throws Exception {
        List<Comment> allComments = getAllComments();
        for (int i = 0 ; i< allComments.size();i++){
            if(!(postRepository.existsById(commentRepository.findById(comment.getComment_id()).get().getPost_id().get(i).getPost_id()))){
                throw new Exception();
            }

        }
        return commentRepository.save(comment);

    }

    public Comment updateComment(Long comment_id, Comment comment) {
        Comment oldComment = commentRepository.findById(comment_id).get();
        for (int i = 0 ; i < getAllComments().size();i++){
            if(commentRepository.existsById(oldComment.getComment_id())
                    && userRepository.existsById(oldComment.getUser_id().get(i).getUser_id())
                    && postRepository.existsById(oldComment.getPost_id().get(i).getPost_id()))
            {
                oldComment.setComment_description(comment.getComment_description());

            }
        }
        return commentRepository.save(oldComment);
    }
}
