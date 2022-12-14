package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Community;
import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import io.bgnc.iytechsocialmediaapplication.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;


    @PostMapping("/saveCommunity")
    public Community saveCommunity(@RequestBody Community community) throws IllegalAccessException {
        return communityService.saveCommunity(community);
    }

    @GetMapping("")
    public List<Community> getAllCommunities(){
        return communityService.getAllCommunities();
    }
    @DeleteMapping("/deleteCommunity/{id}")
    public void deleteCommunity(@PathVariable Long community_id){
        communityService.deleteCommunity(community_id);
    }

    @PutMapping("/updateCommunity/{id}")
    public Community updateCommunity(@PathVariable Long community_id,
                                     @RequestBody String headOfCommunityName,
                                     @RequestBody String community_name,
                                     @RequestBody String community_photo,
                                     @RequestBody String community_description){

        return communityService.
                updateCommunity(community_id,
                        headOfCommunityName,
                        community_name,
                        community_photo,
                        community_description);


    }




}
