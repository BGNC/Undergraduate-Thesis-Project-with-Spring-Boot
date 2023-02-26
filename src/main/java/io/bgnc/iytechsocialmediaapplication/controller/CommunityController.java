package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Community;
import io.bgnc.iytechsocialmediaapplication.service.CommunityService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/community")
@Slf4j

public class CommunityController {


    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }





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
