package cde.mc.outageanalytics1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name= "Role")
public class Role {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String role;
}