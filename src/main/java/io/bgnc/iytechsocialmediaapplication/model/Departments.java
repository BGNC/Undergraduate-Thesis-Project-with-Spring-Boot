package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departments {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="dept_id")
    private Long dept_id;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name="faculties_id")
    private Faculty faculties_id;
    @Column(name="dept_name")
    private String dept_name;
    @Column(name="dept_shortname")
    private String dept_shortname;



}
