package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.Community;
import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import io.bgnc.iytechsocialmediaapplication.repository.CommunityRepository;
import io.bgnc.iytechsocialmediaapplication.repository.HeadOfCommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private HeadOfCommunityRepository headOfCommunityRepository;


    public Community saveCommunity(Community community) throws IllegalAccessException {

        List<Community> allCommunities= getAllCommunities();
        if(communityRepository.existsById(community.getCommunity_id())){
            throw new IllegalAccessException();
        }
        else{
            for(int i = 0;i<allCommunities.size();i++){
                if(headOfCommunityRepository.existsById(community.getHeadOfCommunity_id().get(i).getHead_of_community_id())){
                    if((allCommunities.contains(community))){
                        throw new IllegalAccessException();
                    }
                }
                else{
                    break;
                }

            }
        }

        return communityRepository.save(community);
    }


    public List<Community> getAllCommunities(){
        return communityRepository.findAll();
    }

    public void deleteCommunity(Long community_id) {

        communityRepository.deleteById(community_id);
    }

    public Community updateCommunity(Long community_id, String headOfCommunityName,String community_name,String community_photo,String community_description){
        Community temp = communityRepository.findById(community_id).get();

        if(communityRepository.existsById(temp.getCommunity_id())){
            Long headOfCommunity_id= headOfCommunityRepository.findByHeadOfCommunityId(headOfCommunityName);
            if(headOfCommunityRepository.existsById(headOfCommunity_id)){
                List<HeadOfCommunity> hoclist = headOfCommunityRepository.findByHocId(headOfCommunity_id);
                temp.setHeadOfCommunity_id(hoclist);
                temp.setCommunity_name(community_name);
                temp.setCommunity_photo(community_photo);
                temp.setCommunity_description(community_description);

            }


        }


        return communityRepository.save(temp);
    }
}
