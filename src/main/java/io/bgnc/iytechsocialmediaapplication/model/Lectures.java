package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lectures {

    @Id
    private Long lectures_id;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Departments> departments_id;
    private String lecture_code;
    private String lecture_name;


}
