package com.example.spring.boot.OutageAnalytics_UserRegistration.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "AccType")
public class AccType {

    @Id
    @GeneratedValue
    private Long roleId;

    @NotNull
    private String roleName;

    @ManyToMany(mappedBy = "AccType")
    private Set<User> user;

}
