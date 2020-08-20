package cde.mc.outageanalytics1;

import cde.mc.outageanalytics1.repository.UpdateIncidentRepository;
import cde.mc.outageanalytics1.service.UpdateIncidentService;
import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UpdateIncidentApplicationTests {

	@Autowired
	UpdateIncidentService updateIncidentService;
	@MockBean
	private UpdateIncidentRepository updateIncidentRepository;

	private IncidentTicket mockincidentTicket(){
		IncidentTicket incidentTicket=new IncidentTicket();
		incidentTicket.setTicketId(1);
		incidentTicket.setUserName("sujaya");
		incidentTicket.setContactNo("6744213990");
		incidentTicket.setZipCode(781028);
		incidentTicket.setIssue("No power");
		incidentTicket.setDate("2020-08-16");
		incidentTicket.setStatus("New");
		return incidentTicket;

	}

	@Test
	public void saveTicketTest()
	{
		when(updateIncidentRepository.save(mockincidentTicket())).thenReturn(mockincidentTicket());
		assertEquals(mockincidentTicket(),updateIncidentService.save(mockincidentTicket()));
	}

	@Test
	public void findByIdTest() throws TicketNotFoundException
	{
		when(updateIncidentRepository.findById(1)).thenReturn(Optional.ofNullable(mockincidentTicket()));
		assertEquals(Optional.of(mockincidentTicket()),updateIncidentService.findById(1));
	}

	/*@Test
	public void updateIncidentStatusTest() throws TicketNotFoundException {
			IncidentTicket incidentDetails = new IncidentTicket(1, "sujaya","8644278990",781081,"power fail","2020-08-16","New");
			when(updateIncidentRepository.findById(1)).thenReturn(Optional.of(incidentDetails));
			incidentDetails.setStatus("In Progress");
			when(updateIncidentRepository.save(incidentDetails)).thenReturn(incidentDetails);
			assertEquals(true,updateIncidentService.updateStatusInProgress(1).equals(incidentDetails));
		}*/


	}









