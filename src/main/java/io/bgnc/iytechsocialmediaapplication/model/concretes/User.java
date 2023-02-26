package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Table(name="users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="user_id")
    private Long user_id;

    @Column(name="student_no")
    private String student_no;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;
    @Column(name="mail")
    private String mail;
    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;
    @Column(name="is_activate")
    private int is_activate;


}
