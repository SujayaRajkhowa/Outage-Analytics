package cde.mc.outageanalytics1.UserRegistration.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.security.PrivateKey;
import java.util.Date;

@Entity
@Data
@Table(name="Incident")
public class IncindentTicket {

    @Id
    @GeneratedValue
    private Integer incidentId;
    @NotNull
    private Long contactNo;
    @NotNull
    private Integer zipCode;
    @NotNull
    private String issue;
    @NotNull
    private Date date;
    @NotNull

    private String status="New";


}
