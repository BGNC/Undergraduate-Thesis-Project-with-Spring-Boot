package io.bgnc.iytechsocialmediaapplication.webApi.controller;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Activities;
import io.bgnc.iytechsocialmediaapplication.service.ActivitiesService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    private final ActivitiesService activitiesService;

    public ActivitiesController(ActivitiesService activitiesService) {
        this.activitiesService = activitiesService;
    }

    @GetMapping()
    public List<Activities> getAllActivity(){
        return activitiesService.getAllActivities();
    }

    @GetMapping("{communityId}")
    public Activities getActivityByCommunityId(@PathVariable Long communityId) throws Exception {
        return activitiesService.getActivityCommunityId(communityId).get();
    }

    @PostMapping("/saveActivity")
    public Activities saveActivity(@RequestBody Activities activities){
        return activitiesService.saveActivity(activities);

    }

    @DeleteMapping("/deleteActivity/{activity_id}")
    public void deleteActivity(@PathVariable Long activity_id){
        activitiesService.deleteById(activity_id);
    }

    @PutMapping("/updateActivity/{activity_id}")
    public Activities updateActivity(@RequestBody Activities activities,@PathVariable(name = "activity_id") Long activity_id){

        return activitiesService.updateActivity(activities,activity_id);
    }

}
