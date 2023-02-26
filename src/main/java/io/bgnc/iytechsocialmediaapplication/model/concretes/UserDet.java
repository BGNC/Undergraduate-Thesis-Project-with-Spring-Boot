package io.bgnc.iytechsocialmediaapplication.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDet  extends User{


    private String user_photo;
    private String user_bio;
    private String gender;
    private String address;
    private String website;


}
