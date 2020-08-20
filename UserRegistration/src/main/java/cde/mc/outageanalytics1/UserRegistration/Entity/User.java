package cde.mc.outageanalytics1.UserRegistration.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name= "User")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String address;
    @NotNull
    private String state;
    @NotNull
    private String country;
    @NotNull
    private Integer zipCode;
    @NotNull
    private String emailId;
    @NotNull
    private String pan;
    @NotNull
    @Column(unique = true)
    private Long contactNo;
    @NotNull
    private Date dob;
    @NotNull
    @ManyToMany(mappedBy = "user")
    private Set<AccType> accType;


}
