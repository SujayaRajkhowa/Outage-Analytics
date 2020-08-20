package cde.mc.outageanalytics1.UserRegistrationService.Entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name= "User")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    private Integer userId;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String state;
    @NotBlank(message = "Country field required")
    private String country;
    @NotNull
    private Integer zipCode;
    @NotBlank
    @Column(unique = true)
    private String emailId;
    @NotBlank
    private String pan;
    @NotBlank
    @Column(unique = true)
    private String contactNo;
    @NotNull
    private String dob;
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="userId"),inverseJoinColumns =@JoinColumn(name="roleId"))
    private Set<Role> roles;



}
