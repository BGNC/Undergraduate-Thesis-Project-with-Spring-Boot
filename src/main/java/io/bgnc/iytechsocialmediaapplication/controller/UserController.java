package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.exception.UserExistAlreadyException;
import io.bgnc.iytechsocialmediaapplication.model.User;
import io.bgnc.iytechsocialmediaapplication.service.UserService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestParam User userParam) throws UserExistAlreadyException {

       User user = userService.getUser(userParam.getUsername());
       List<User> userList = userService.getAllUser();

       if(userList.contains(user)){
           throw new UserExistAlreadyException("User is already in the system");
       }
       else{
            return userService.saveUser(userParam);
       }
    }







}
