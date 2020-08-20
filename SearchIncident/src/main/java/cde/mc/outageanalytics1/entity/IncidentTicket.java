package cde.mc.outageanalytics1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "IncidentTicket")
public class IncidentTicket {

    @Id
    @GeneratedValue
    @NotNull
    private Integer ticketId;
    @NotBlank
    private String userName;
    @NotNull
    private String contactNo;
    @NotNull
    private Integer zipCode;
    @NotBlank
    private String issue;
    @NotBlank
    private String date;
    @NotBlank
    private String status="New";


}