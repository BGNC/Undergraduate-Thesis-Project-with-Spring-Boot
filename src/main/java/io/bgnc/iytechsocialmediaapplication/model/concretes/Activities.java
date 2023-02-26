package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="activities")
public class Activities {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="activities_id")
    private Long activities_id;

    @ManyToOne(fetch = EAGER)
    @Column(name="community_id")
    private Community community_id;

    @Lob
    @Column(name="activities_title")
    private String activities_title;
    @Lob
    @Column(name="activities_description")
    private String activities_description;
    @Lob
    @Column(name="activities_location")
    private String activites_location;

    @Column(name="activities_photo")
    private String activities_photo;


}
