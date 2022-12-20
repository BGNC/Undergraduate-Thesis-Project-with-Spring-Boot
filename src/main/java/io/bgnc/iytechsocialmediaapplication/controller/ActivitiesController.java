package io.bgnc.iytechsocialmediaapplication.controller;

import io.bgnc.iytechsocialmediaapplication.model.Activities;
import io.bgnc.iytechsocialmediaapplication.service.ActivitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    private ActivitiesService activitiesService;


    @GetMapping()
    public List<Activities> getAllActivity(){
        return activitiesService.getAll();
    }
    @GetMapping("{communityId}")
    public Optional<Activities> getActivityByCommunityId(@PathVariable Long communityId) throws Exception {
        return activitiesService.getActivityCommunityId(communityId);
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
