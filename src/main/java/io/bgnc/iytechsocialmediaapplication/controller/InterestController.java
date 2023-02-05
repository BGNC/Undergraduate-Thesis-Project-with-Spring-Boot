package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Interest;
import io.bgnc.iytechsocialmediaapplication.service.InterestService;
import io.bgnc.iytechsocialmediaapplication.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interest")
public class InterestController {

    private final InterestService interestService;


    public InterestController(InterestService interestService) {
        this.interestService = interestService;

    }


    @PutMapping("/updateInterest/{interest_id}")
    public Interest updateInterest(@PathVariable Long interest_id,@RequestBody Interest interest){
        return interestService.updateInterest(interest_id,interest);
    }

    @GetMapping("/")
    public List<Interest> getAllInterest(){

        return interestService.getAllInterest();
    }

    @DeleteMapping("/deleteInterest/{user_id}")
    public void deleteInterest(@PathVariable Long user_id){
        interestService.deleteInterest(user_id);
    }



    @PostMapping("/saveInterest")
    public Interest saveInterest(@RequestBody Interest interest) throws Exception {
        return interestService.saveInterest(interest);

    }
}
