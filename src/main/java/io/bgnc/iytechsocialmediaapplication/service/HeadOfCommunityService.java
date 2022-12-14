package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import io.bgnc.iytechsocialmediaapplication.repository.CommunityRepository;
import io.bgnc.iytechsocialmediaapplication.repository.HeadOfCommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HeadOfCommunityService {

    private final HeadOfCommunityRepository headOfCommunityRepository;

    @Autowired
    private CommunityRepository communityRepository;

    public HeadOfCommunityService(HeadOfCommunityRepository headOfCommunityRepository) {
        this.headOfCommunityRepository = headOfCommunityRepository;
    }

    public List<HeadOfCommunity> getAllHeadOfCommunity()
    {
       return headOfCommunityRepository.findAll();
    }

    public void deleteHeadOfCommunityById(Long id){

        if(headOfCommunityRepository.existsById(id)) {

            headOfCommunityRepository.deleteById(id);
            for(int i = 0 ; i < communityRepository.findAll().size();i++){
                if(communityRepository.existsById(id)){
                    communityRepository.deleteById(id);
                }
            }
        }
    }
    public HeadOfCommunity saveHeadOfCommunity(HeadOfCommunity headOfCommunity) throws Exception {

        HeadOfCommunity hoc = headOfCommunityRepository.findById(headOfCommunity.getHead_of_community_id()).get();
        List<HeadOfCommunity> headOfCommunityList = getAllHeadOfCommunity();
        if(headOfCommunityList.contains(hoc)){
            throw new RuntimeException("Hoc is already taken");
        }
        else{
            if(hoc.getHead_name().equals(headOfCommunity.getHead_name())){
                log.warn("Head name is the same so we cannot save ");
            }
        }
        return headOfCommunityRepository.save(headOfCommunity);
    }


    public HeadOfCommunity updateHeadOfCommunity(String headName, Long id) {


        return null;
    }
}
