package io.bgnc.iytechsocialmediaapplication.repository.abstracts;

import io.bgnc.iytechsocialmediaapplication.model.concretes.HeadOfCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeadOfCommunityRepository extends JpaRepository<HeadOfCommunity,Long> {


    Long findByHeadOfCommunityId(String headOfCommunityName);

    List<HeadOfCommunity> findByHocId(Long id);



}
