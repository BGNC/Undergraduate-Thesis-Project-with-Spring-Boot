package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private Long comment_id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> user_id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Post> post_id;


    private String comment_description;




}
