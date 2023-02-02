package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Post;
import io.bgnc.iytechsocialmediaapplication.model.User;
import io.bgnc.iytechsocialmediaapplication.repository.PostRepository;
import io.bgnc.iytechsocialmediaapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;



    public List<Post> getPostByUserId(Long userId){
        User user = userRepository.findByUserId(userId);
        List<Post> getAllPost = getAllPost();
        List<Post> listPost = new ArrayList<>();
        for (int i = 0 ; i < getAllPost.size();i++){
            if(user.getUser_id().equals(getAllPost.get(i).getUser_id().get(i))){
                listPost.add(postRepository.findByUserId(userId).get(i));
            }
        }
        return listPost;


    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post savePost(Post post){

        List<Post> listOfPost = getAllPost();

        int i = 0 ;
        while (i < listOfPost.size()) {
            User user = userRepository.findByUserId(post.getUser_id().get(i).getUser_id());
            if(!(post.getUser_id().get(i).getUser_id().equals(user.getUser_id()))){
                return postRepository.save(post);
            }
            else{
                throw new RuntimeException();

            }

        }
        return postRepository.save(post);



    }

    public void deletePost(Long postId)
    {

        if(postRepository.existsById(postId)){
            postRepository.deleteById(postId);
        }

    }

    public Post updatePost(Long postId,Post post) {

        Post foundPost = postRepository.findById(postId).get();

        List<Post> allPosts = getAllPost();
        if(allPosts.contains(foundPost)){

            foundPost.setPost_description(post.getPost_description());
            foundPost.setPost_photo(post.getPost_photo());
            foundPost.setIs_anonymous(post.getIs_anonymous());

        }
        else{
            throw new IllegalStateException();
        }
        return postRepository.save(foundPost);
    }
}
