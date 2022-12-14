package io.bgnc.iytechsocialmediaapplication.service;

import io.bgnc.iytechsocialmediaapplication.repository.CommunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;
}
