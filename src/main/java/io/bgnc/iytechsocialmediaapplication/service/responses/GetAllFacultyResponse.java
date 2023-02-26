package io.bgnc.iytechsocialmediaapplication.service.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFacultyResponse {
    private Long faculties_id;
    private String faculty_name;
}
