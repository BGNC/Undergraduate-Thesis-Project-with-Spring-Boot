package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departments {

    @Id
    private Long dept_id;
    @OneToOne(fetch = FetchType.EAGER)
    private Faculty faculties_id;
    private String dept_name;
    private String dept_shortname;



}
