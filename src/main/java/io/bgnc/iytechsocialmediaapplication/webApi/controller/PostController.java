package io.bgnc.iytechsocialmediaapplication.webApi.controller;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Post;
import io.bgnc.iytechsocialmediaapplication.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j
@Transactional
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/savePost")
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @DeleteMapping("deletePost/{id}")
    public void deletePostById(@PathVariable Long postId){
        postService.deletePost(postId);
    }

    @PutMapping("/updatePost/{id}")
    public Post updatePost(@PathVariable Long postId,@RequestBody Post post){
        return postService.updatePost(postId,post);
    }

    @GetMapping("/")
    public List<Post> getAllPost(){
       return  postService.getAllPost();
    }

    @GetMapping("/getPostByUserId/{userId}")
    public List<Post> getPostByUserId(@PathVariable Long userId){
        return postService.getPostByUserId(userId);
    }


}
