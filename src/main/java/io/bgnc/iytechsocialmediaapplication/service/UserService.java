package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.exception.UserExistAlreadyException;
import io.bgnc.iytechsocialmediaapplication.model.concretes.User;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
@Transactional
public class UserService{

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User userParam) throws UserExistAlreadyException {

        String username = userParam.getUsername();

        if(userRepository.existsById(userParam.getUser_id()) || username.equals(userParam.getUsername())){
            throw new UserExistAlreadyException("The username is already taken");
        }
        return userRepository.save(userParam);
    }


    public User updateUserById(Long id, String username, String phone, String password,int isActivated) {






        User user = userRepository.findById(id).get();
        List<User> userList = userRepository.findAll();
        if(userList.contains(user)){

            if(!(username.isEmpty()) && !(user.getUsername().equals(username)))
            {
                if(!(phone.isEmpty() && !(user.getPhone().equals(phone)))){
                    if(!(password.isEmpty()))
                    {
                        user.setIs_activate(isActivated);
                        user.setUsername(username);
                        user.setPhone(phone);
                        user.setPassword(password);

                    }
                    else
                    {
                        log.info("Password is null");
                    }
                }
                else{
                    log.info("Please enter, phone");
                }
            }
            else
            {
                log.info("The username is already taken");
            }
        }

        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        // when the user is deleted the post of user will be at the same time .
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);

        }
        else{
            throw new IllegalStateException();
        }

    }



}
