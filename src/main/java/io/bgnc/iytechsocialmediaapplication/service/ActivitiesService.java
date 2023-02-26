package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.concretes.Activities;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.ActivitiesRepository;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.CommunityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivitiesService {


    private final ActivitiesRepository activitiesRepository;

    private final CommunityRepository communityRepository;

    public ActivitiesService(ActivitiesRepository activitiesRepository, CommunityRepository communityRepository) {
        this.activitiesRepository = activitiesRepository;
        this.communityRepository = communityRepository;
    }




    public List<Activities> getAllActivities(){
        return activitiesRepository.findAll();
    }

    public Optional<Activities> getActivityCommunityId(Long communityId) throws Exception {
        if((communityRepository.existsById(communityId))){
            throw new Exception();
        }
        return activitiesRepository.findById(communityRepository.findById(communityId).get().getCommunity_id());

    }

    public Activities saveActivity(Activities activities) {

        boolean existsCheckActivityId = activitiesRepository.existsById(activities.getActivities_id());
        boolean existCheckCommunityId = communityRepository.existsById(activities.getCommunity_id().getCommunity_id());

        if((existsCheckActivityId)){
            throw  new RuntimeException();
        }
        else{
            if(existCheckCommunityId){
                throw new RuntimeException();
            }
        }
        return activitiesRepository.save(activities);
    }


    public void deleteById(Long activity_id) {
        boolean checkExist = activitiesRepository.existsById(activity_id);
        if(checkExist){
            activitiesRepository.deleteById(activity_id);
        }
    }


    public Activities updateActivity(Activities activities, Long activity_id) {

        boolean checker = activitiesRepository.existsById(activity_id);
        Activities oldAct = activitiesRepository.findById(activity_id).get();
        if(!(checker)){
            throw new RuntimeException();
        }
        if(communityRepository.existsById(activities.getCommunity_id().getCommunity_id())){

            oldAct.setActivities_photo(activities.getActivities_photo());
            oldAct.setActivities_description(activities.getActivities_description());
            oldAct.setActivities_title(activities.getActivities_title());
            oldAct.setActivites_location(activities.getActivites_location());
            oldAct.setCommunity_id(activities.getCommunity_id());


        }

        return activitiesRepository.save(oldAct);

    }
}
