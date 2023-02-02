package io.bgnc.iytechsocialmediaapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode
public class Community {

    @Id
    private Long community_id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<HeadOfCommunity> headOfCommunity_id;

    private String community_name;
    private String community_photo;
    private String community_description;

}
