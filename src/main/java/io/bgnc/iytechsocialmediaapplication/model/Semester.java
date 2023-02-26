package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Table(name="semester")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="semester_id")
    private Long semester_id;
    @Column(name="semester_name")
    private String semester_name;

}
