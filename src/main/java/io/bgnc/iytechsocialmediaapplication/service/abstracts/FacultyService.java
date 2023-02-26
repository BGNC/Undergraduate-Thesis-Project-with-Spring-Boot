package io.bgnc.iytechsocialmediaapplication.service.abstracts;

import io.bgnc.iytechsocialmediaapplication.exception.FacultyNotFoundException;
import io.bgnc.iytechsocialmediaapplication.service.requests.CreateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.requests.GetByFacultyIdResponse;
import io.bgnc.iytechsocialmediaapplication.service.requests.UpdateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.responses.GetAllFacultyResponse;

import java.util.List;

public interface FacultyService {

    List<GetAllFacultyResponse> getAllFaculties();
    void add(CreateFacultyRequest createFacultyRequest);
    void delete(Long id);
    GetByFacultyIdResponse getById(Long id) throws FacultyNotFoundException;
    void update(UpdateFacultyRequest updateFacultyRequest);

}
