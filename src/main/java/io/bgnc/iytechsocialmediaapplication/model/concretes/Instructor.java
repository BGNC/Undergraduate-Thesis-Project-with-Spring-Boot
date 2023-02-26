package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "instructor_id")
    private Long instructor_id;

    @Column(name="instructor_title")
    private String instructor_title;

    @Column(name="instructor_name")
    private String instructor_name;


    @Column(name="instructor_photo")
    private String instructor_photo;
    @Lob
    @Column(name="instructor_address")
    private String instructor_address;

    @Column(name="instructor_mail")
    private String instructor_mail;
    @Column(name="instructur_phone")
    private String instructor_phone;
    @Column(name="instructor_website")
    private String instructor_website;
    @Column(name="instructor_scopus")
    private String instructor_scopus;
    @Column(name="instructor_scholar_google")
    private String instructor_scholar_google;
    @Column(name="instructor_research_gate")
    private String instructor_research_gate;
    @Column(name="instructor_linkedin")
    private String instructor_linkedin;


    /**
     * SOME INSTRUCTOR PART-TIME OR PHD STUDENT OR MSC STUDENT
     * */
    @Column(name="instructor_is_student")
    private String instructor_is_student;




}
