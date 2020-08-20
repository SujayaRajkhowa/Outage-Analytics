package cde.mc.outageanalytics1;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.repository.IncidentRepository;
import cde.mc.outageanalytics1.service.IncidentService;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@SpringBootTest
class IncidentCreationApplicationTests {

    @Autowired
    IncidentService incidentService;

    @MockBean
    private IncidentRepository incidentRepository;

    private IncidentTicket mockincidentTicket(){
        IncidentTicket incidentTicket=new IncidentTicket();
        incidentTicket.setTicketId(1);
        incidentTicket.setUserName("sujaya");
        incidentTicket.setContactNo("8433612770");
        incidentTicket.setZipCode(781028);
        incidentTicket.setIssue("No power");
        incidentTicket.setDate("2020-08-16");
        incidentTicket.setStatus("New");
        return incidentTicket;

    }

    @Test
    public void addTicketTest()
    {
        when(incidentRepository.save(mockincidentTicket())).thenReturn(mockincidentTicket());
        assertEquals(mockincidentTicket(),incidentService.addTicket(mockincidentTicket()));
    }

    @Test
    public void findByIdTest() throws TicketNotFoundException
    {
        when(incidentRepository.findById(1)).thenReturn(Optional.ofNullable(mockincidentTicket()));
        assertEquals(Optional.of(mockincidentTicket()),incidentService.findById(1));
    }


}
