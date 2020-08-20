package cde.mc.outageanalytics1.entity;

import lombok.Data;

import javax.persistence.*;
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
    @NotBlank
    private String contactNo;
    @NotNull(message = "Field missing")
    private Integer zipCode;
    @NotBlank
    private String issue;
    @NotBlank
    private String date;
    @NotBlank
    private String status="New";


    }
