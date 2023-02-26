package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecIns {

    @Id
    private Long lecins_id;


}
