package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long activities_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "community_id")
    private Community community_id;

    @Lob
    private String activities_title;
    @Lob
    private String activities_description;
    @Lob
    private String activites_location;

    private String activities_photo;


}
