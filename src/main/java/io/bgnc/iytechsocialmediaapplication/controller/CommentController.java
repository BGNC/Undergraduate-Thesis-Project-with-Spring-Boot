package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Comment;
import io.bgnc.iytechsocialmediaapplication.model.User;
import io.bgnc.iytechsocialmediaapplication.service.CommentService;
import io.bgnc.iytechsocialmediaapplication.service.PostService;
import io.bgnc.iytechsocialmediaapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;

    }


    @GetMapping("/")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
    @PostMapping("/saveComment")
    public Comment saveComment(@RequestBody Comment comment) throws Exception {
        return commentService.saveComment(comment);

    }

    @GetMapping("/{userId}")
    public HashMap<User, Comment> getAllCommentsByUserId(Long userId){
        return commentService.getAllCommentsByUserId(userId);
    }


    @PutMapping("/updateComment/{comment_id}")
    public Comment updateComment(@PathVariable Long comment_id,@RequestBody Comment comment){
        return commentService.updateComment(comment_id,comment);
    }


    @DeleteMapping("/deleteComment/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id){
        commentService.deleteComment(comment_id);
    }



}
