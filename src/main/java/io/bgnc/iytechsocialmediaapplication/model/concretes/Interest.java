package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="interest_id")
    private Long interest_id;

    @Column(name="user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user_id;

    @Column(name="interestedField")
    private String interestedField;

}
