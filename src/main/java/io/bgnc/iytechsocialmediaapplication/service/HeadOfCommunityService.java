package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import io.bgnc.iytechsocialmediaapplication.repository.CommunityRepository;
import io.bgnc.iytechsocialmediaapplication.repository.HeadOfCommunityRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class HeadOfCommunityService {

    private final HeadOfCommunityRepository headOfCommunityRepository;
    private final  CommunityRepository communityRepository;



    public HeadOfCommunityService(HeadOfCommunityRepository headOfCommunityRepository, CommunityRepository communityRepository) {
        this.headOfCommunityRepository = headOfCommunityRepository;
        this.communityRepository = communityRepository;
    }



    public HeadOfCommunity getHeadOfCommunityByCommunityId(Long community_id){

        return headOfCommunityRepository.findById()


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

        HeadOfCommunity oldHoc = headOfCommunityRepository.findById(id).get();

        if(headOfCommunityRepository.existsById(oldHoc.getHead_of_community_id())){
            if(!(oldHoc.getHead_name()).equals(headName)){

                oldHoc.setHead_name(headName);
            }

        }
        return headOfCommunityRepository.save(oldHoc);


    }
}
