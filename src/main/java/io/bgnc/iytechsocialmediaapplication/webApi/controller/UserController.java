package io.bgnc.iytechsocialmediaapplication.webApi.controller;

import io.bgnc.iytechsocialmediaapplication.exception.UserExistAlreadyException;
import io.bgnc.iytechsocialmediaapplication.model.concretes.User;
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

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public User saveUser(@RequestParam User userParam) throws UserExistAlreadyException {
        return userService.saveUser(userParam);
    }

    @PutMapping("updateUser/{id}")
    public User updateUserById(@PathVariable Long id, @RequestParam String username,@RequestParam String phone,@RequestParam String password,@RequestParam int isActivated){
        return userService.updateUserById(id,username,phone,password,isActivated);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);

    }







}
