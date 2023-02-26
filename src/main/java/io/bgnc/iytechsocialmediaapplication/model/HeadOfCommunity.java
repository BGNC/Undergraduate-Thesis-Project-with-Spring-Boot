package io.bgnc.iytechsocialmediaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name="HeadOfCommunity")
@NoArgsConstructor
@AllArgsConstructor
public class HeadOfCommunity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="head_of_community_id")
    private Long head_of_community_id;
    @Column(name="head_name")
    private String head_name;


}
