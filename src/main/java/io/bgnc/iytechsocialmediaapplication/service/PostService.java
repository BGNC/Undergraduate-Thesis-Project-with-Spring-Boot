package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.repository.PostRepository;
import io.bgnc.iytechsocialmediaapplication.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {


    private PostRepository postRepository;

    public List<PostResponse> getAllPost(Optional<Long> userId) {
        return null;

    }
}
