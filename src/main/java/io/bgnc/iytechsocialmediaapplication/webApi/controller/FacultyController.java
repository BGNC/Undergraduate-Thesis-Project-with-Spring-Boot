package io.bgnc.iytechsocialmediaapplication.webApi.controller;

import io.bgnc.iytechsocialmediaapplication.exception.FacultyNotFoundException;
import io.bgnc.iytechsocialmediaapplication.model.concretes.Faculty;
import io.bgnc.iytechsocialmediaapplication.service.abstracts.FacultyService;
import io.bgnc.iytechsocialmediaapplication.service.concretes.FacultyServiceImpl;
import io.bgnc.iytechsocialmediaapplication.service.requests.CreateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.requests.GetByFacultyIdResponse;
import io.bgnc.iytechsocialmediaapplication.service.requests.UpdateFacultyRequest;
import io.bgnc.iytechsocialmediaapplication.service.responses.GetAllFacultyResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@AllArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;


    @GetMapping("{id}")
    public GetByFacultyIdResponse getById(@PathVariable Long id) throws FacultyNotFoundException {
        return facultyService.getById(id);

    }

    @GetMapping("")
    public List<GetAllFacultyResponse> getAllFaculties(){

        return facultyService.getAllFaculties();

    }

    @PutMapping("")
    public void update(@RequestBody UpdateFacultyRequest updateFacultyRequest) {
         facultyService.update(updateFacultyRequest);
    }

    @PostMapping("")
    public void add(@RequestBody CreateFacultyRequest createFacultyRequest){

         facultyService.add(createFacultyRequest);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         facultyService.delete(id);
    }


}
