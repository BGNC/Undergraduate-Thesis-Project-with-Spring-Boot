package io.bgnc.iytechsocialmediaapplication.service.concretes;

import io.bgnc.iytechsocialmediaapplication.core.mappers.abstracts.ModelMapperService;
import io.bgnc.iytechsocialmediaapplication.exception.FacultyNotFoundException;
import io.bgnc.iytechsocialmediaapplication.model.concretes.Faculty;
import io.bgnc.iytechsocialmediaapplication.repository.abstracts.FacultyRepository;

import io.bgnc.iytechsocialmediaapplication.service.abstracts.FacultyService;
import io.bgnc.iytechsocialmediaapplication.service.requests.CreateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.requests.GetByFacultyIdResponse;
import io.bgnc.iytechsocialmediaapplication.service.requests.UpdateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.responses.GetAllFacultyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllFacultyResponse> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();

        return faculties.
                stream()
                .map(faculty ->
                        this.modelMapperService.
                                forResponse().
                                map(faculty,GetAllFacultyResponse.class)).toList();
    }

    @Override
    public void add(CreateFacultyRequest createFacultyRequest) {

        Faculty faculty = this.modelMapperService.forRequest().map(createFacultyRequest,Faculty.class);

        facultyRepository.save(faculty);


    }

    @Override
    public void delete(Long id) {
        this.facultyRepository.deleteById(id);
    }

    @Override
    public GetByFacultyIdResponse getById(Long id) throws FacultyNotFoundException {
        Faculty faculty = this.facultyRepository.findById(id).orElseThrow(()->  new FacultyNotFoundException("The faculty is not found . "));
        return this.modelMapperService.forResponse().map(faculty,GetByFacultyIdResponse.class);
    }


    @Override
    public void update(UpdateFacultyRequest updateFacultyRequest) {

        Faculty faculty = this.modelMapperService.forRequest().map(updateFacultyRequest,Faculty.class);
        this.facultyRepository.save(faculty);




    }
}
