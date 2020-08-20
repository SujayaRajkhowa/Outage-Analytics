package cde.mc.outageanalytics1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @NotNull
    private String date;
    @NotBlank
    private String status="New";




}

