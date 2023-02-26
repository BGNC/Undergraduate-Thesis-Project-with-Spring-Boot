package io.bgnc.iytechsocialmediaapplication.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByFacultyIdResponse
{
    private Long faculty_id;
    private String faculty_name;

}
