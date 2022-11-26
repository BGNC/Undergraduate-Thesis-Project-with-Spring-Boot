package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.User;
import io.bgnc.iytechsocialmediaapplication.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }



    public void addToDetailsUser(Long user_id) {

    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }









}
