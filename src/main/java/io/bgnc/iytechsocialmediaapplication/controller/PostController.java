package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.service.PostService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@Slf4j
@NoArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;


   @GetMapping
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId){

        return postService.getAllPost(userId);
    }

}
