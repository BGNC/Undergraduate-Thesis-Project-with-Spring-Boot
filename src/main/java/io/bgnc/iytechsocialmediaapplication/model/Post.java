package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.*;


@Table(name="post")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="post_id")
    private  Long post_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name="user_id")
    private List<User> user_id;
    @Column(name="post_description")
    private String post_description;
    @Column(name="post_photo")
    private String post_photo;
    @Column(name="is_anonymous")
    private String is_anonymous;


}
