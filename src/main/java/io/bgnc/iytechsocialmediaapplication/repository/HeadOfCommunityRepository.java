package io.bgnc.iytechsocialmediaapplication.repository;

import io.bgnc.iytechsocialmediaapplication.model.HeadOfCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeadOfCommunityRepository extends JpaRepository<HeadOfCommunity,Long> {


    Long findByHeadOfCommunityId(String headOfCommunityName);

    List<HeadOfCommunity> findByHocId(Long id);



}
