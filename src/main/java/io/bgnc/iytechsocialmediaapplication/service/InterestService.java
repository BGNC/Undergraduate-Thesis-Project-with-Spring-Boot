package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Interest;
import io.bgnc.iytechsocialmediaapplication.model.concretes.User;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.InterestRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j

public class InterestService {


    private final InterestRepository interestRepository;
    private final UserRepository userRepository;


    public InterestService(InterestRepository interestRepository, UserRepository userRepository) {

        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
    }


    public List<Interest> getAllInterest() {
        return interestRepository.findAll();
    }



    public void deleteInterest(Long user_id){

        User user =  userRepository.findById(user_id).get();

        if(getAllInterest().contains(user)){
            for (int i = 0 ; i < getAllInterest().size();i++){
                if(interestRepository.findByUserId(user_id)){
                    interestRepository.deleteById(user_id);
                }
            }
        }


    }

    public Interest saveInterest(Interest interest) throws Exception {


        if(!(userRepository.existsById(interest.getUser().getUser_id()))){
            throw new Exception();
        }

        return interestRepository.save(interest);
    }


    public Interest updateInterest(Long interest_id,Interest interest) {

        Interest oldInterst = interestRepository.findById(interest_id).get();

        if(interestRepository.existsById(oldInterst.getInterest_id())){

            if(userRepository.existsById(interest.getUser().getUser_id())){

                oldInterst.setInterestedField(interest.getInterestedField());


            }

        }
        return interestRepository.save(oldInterst);
    }
}
