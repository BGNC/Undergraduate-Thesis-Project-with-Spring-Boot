package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.exception.UserExistAlreadyException;
import io.bgnc.iytechsocialmediaapplication.model.User;
import io.bgnc.iytechsocialmediaapplication.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User userParam) throws UserExistAlreadyException {

        String username = userParam.getUsername();

        if(userRepository.existsById(userParam.getUser_id()) || username.equals(userParam.getUsername())){
            throw new UserExistAlreadyException("The username is already taken");
        }
        return userRepository.save(userParam);
    }


    public User updateUserById(Long id, String username, String phone, String password) {
        User user = userRepository.findById(id).get();
        List<User> userList = userRepository.findAll();
        if(userList.contains(user)){
            if(!(username.isEmpty()) && !(user.getUsername().equals(username)))
            {
                if(!(phone.isEmpty() && !(user.getPhone().equals(phone)))){
                    if(!(password.isEmpty()))
                    {
                        user.setUsername(username);
                        user.setPhone(phone);
                        user.setPassword(password);


                    }
                }
            }
        }

        return userRepository.save(user);
    }









    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
