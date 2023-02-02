package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Lob;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Instructor {
    @Id
    private Long instructor_id;

    private String instructor_title;

    private String instructor_name;
    @Lob
    private String instructor_photo;
    private String instructor_address;
    private String instructor_mail;
    private String instructor_phone;
    private String instructor_website;
    private String instructor_scopus;
    private String instructor_scholar_google;
    private String instructor_research_gate;
    private String instructor_linkedin;
    private String instructor_is_student;




}
