package com.example.spring.boot.OutageAnalytics_UserRegistration.Entity;




import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="User")
public class User {

    @Id
    @GeneratedValue
    private Long userId;
   // @NotNull
    private String name;
    //@NotNull
    private String username;
    //@NotNull
    private String password;
    //@NotNull
    private String address;
    //@NotNull
    private String state;
    //@NotNull
    private String country;
    //@NotNull
    private String zipCode;
    //@NotNull
    private String email;
    //@NotNull
    private String pan;
    //@NotNull
    //@Size(min = 10, max = 10)
    private String contactNo;
    private String dob;

    //@ManyToMany(mappedBy = "User")
    //private Set<AccType> accType;



}
