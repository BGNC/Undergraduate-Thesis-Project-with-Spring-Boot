package io.bgnc.iytechsocialmediaapplication.core.mappers.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();



}
