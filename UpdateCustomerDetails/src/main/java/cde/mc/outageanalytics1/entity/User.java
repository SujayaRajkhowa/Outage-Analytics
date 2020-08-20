package cde.mc.outageanalytics1.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name= "User")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    @NotNull(message = "Name Field Required")
    private String name;
    @NotNull(message = "User Name Field Required")
    @Column(unique = true)
    private String userName;
    @NotNull(message = "Password Field Required")
    private String password;
    @NotNull(message = "Address Field Required")
    private String address;
    @NotNull(message = "State Field Required")
    private String state;
    @NotNull(message = "Country Field Required")
    private String country;
    @NotNull(message = "Zip Code Field Required")
    private Integer zipCode;
    @NotNull(message = "Email Field Required")
    @Column(unique = true)
    private String emailId;
    @NotNull(message = "PAN Field Required")
    private String pan;
    @NotNull(message = "Contact Number Field Required")
    @Column(unique = true)
    private String contactNo;
    @NotNull(message = "DOB Field Required")
    private String dob;
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="userId"),inverseJoinColumns =@JoinColumn(name="roleId"))
    private Set<Role> roles;

}

