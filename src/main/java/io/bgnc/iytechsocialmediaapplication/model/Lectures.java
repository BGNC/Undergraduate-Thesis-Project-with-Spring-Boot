package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@Table(name="lectures")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lectures {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="lectures_id")
    private Long lectures_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name="departments_id")
    private List<Departments> departments_id;
    @Column(name="lecture_code")
    private String lecture_code;
    @Column(name="lecture_name")
    private String lecture_name;


}
