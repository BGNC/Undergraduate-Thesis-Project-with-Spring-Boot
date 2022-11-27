package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long user_id;
    private String student_no;
    private String username;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private String phone;
    private int is_activate;


}
