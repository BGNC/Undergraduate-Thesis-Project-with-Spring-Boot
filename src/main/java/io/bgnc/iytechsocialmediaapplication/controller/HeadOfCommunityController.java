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

    @Autowired
    private  HeadOfCommunityService headOfCommunityService;

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
    @PutMapping("/updateHeadOfCommunity/{headName}&{id}")
    public HeadOfCommunity updateHeadOfCommunity(@PathVariable String headName, @PathVariable(name = "id") Long id){
        return headOfCommunityService.updateHeadOfCommunity(headName,id);
    }




}
