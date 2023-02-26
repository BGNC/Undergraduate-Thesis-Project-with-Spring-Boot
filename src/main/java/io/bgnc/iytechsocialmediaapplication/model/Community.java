package io.bgnc.iytechsocialmediaapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="community")
public class Community {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="community_id")
    private Long community_id;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name="headOfCommunity_id")
    private List<HeadOfCommunity> headOfCommunity_id;

    @Column(name="community_name")
    private String community_name;
    @Column(name="community_photo")
    private String community_photo;
    @Column(name="community_description")
    private String community_description;

}
