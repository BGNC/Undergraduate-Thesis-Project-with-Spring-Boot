package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.User;



public interface UserService {

    User getUser(String username);


    User saveUser(User user);

    void addToDetailsUser(Long user_id);









}
