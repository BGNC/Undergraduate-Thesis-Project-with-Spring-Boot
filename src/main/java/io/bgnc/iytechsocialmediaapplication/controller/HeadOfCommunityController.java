package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import io.bgnc.iytechsocialmediaapplication.service.HeadOfCommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/headofcommunity")
@Slf4j
public class HeadOfCommunityController{


    private final HeadOfCommunityService headOfCommunityService;

    public HeadOfCommunityController(HeadOfCommunityService headOfCommunityService) {
        this.headOfCommunityService = headOfCommunityService;
    }



    @GetMapping("/getAllHeadOfCommunity")
    public List<HeadOfCommunity> getAllHeadOfCommunity(){
        return headOfCommunityService.getAllHeadOfCommunity();

    }
    @DeleteMapping("deleteHeadOfCommunity/{id}")
    public void deleteHeadOfCommunityById(@PathVariable Long id){

        headOfCommunityService.deleteHeadOfCommunityById(id);
    }
    @PostMapping
    public HeadOfCommunity saveHeadOfCommunity(@RequestBody HeadOfCommunity headOfCommunity) throws Exception {
        return headOfCommunityService.saveHeadOfCommunity(headOfCommunity);
    }

    @GetMapping("/{community_id}")
    public HeadOfCommunity getHeadOfCommunityByCommunityId(@PathVariable Long community_id){
        return headOfCommunityService.getHeadOfCommunityByCommunityId(community_id);
    }
    @PutMapping("/updateHeadOfCommunity/{headName}&{id}")
    public HeadOfCommunity updateHeadOfCommunity(@PathVariable String headName, @PathVariable(name = "id") Long id){
        return headOfCommunityService.updateHeadOfCommunity(headName,id);
    }




}
