package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private Long comment_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<User> user_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    private List<Post> post_id;


    private String comment_description;




}
