package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="comment_id")
    private Long comment_id;


    @ManyToMany(fetch = EAGER)
    @Column(name="user_id")
    private List<User> user_id;

    @ManyToMany(fetch = EAGER)
    @Column(name="post_id")
    private List<Post> post_id;


    @Column(name="comment_description")
    private String comment_description;




}
