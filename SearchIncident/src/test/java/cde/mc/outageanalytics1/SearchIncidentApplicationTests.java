package cde.mc.outageanalytics1;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import cde.mc.outageanalytics1.repository.SearchIncidentRepository;
import cde.mc.outageanalytics1.service.SearchIncidentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SearchIncidentApplicationTests {

	@Autowired
	SearchIncidentService searchIncidentService;

	@MockBean
	private SearchIncidentRepository searchIncidentRepository;

	private IncidentTicket mockincidentTicket(){
		IncidentTicket incidentTicket=new IncidentTicket();
		incidentTicket.setTicketId(1);
		incidentTicket.setUserName("sujaya");
		incidentTicket.setContactNo("7466154990");
		incidentTicket.setZipCode(781028);
		incidentTicket.setIssue("No power");
		incidentTicket.setDate("2020-08-16");
		incidentTicket.setStatus("New");
		return incidentTicket;

	}
	@Test
	public void findByIdTest() throws TicketNotFoundException
	{
		when(searchIncidentRepository.findById(1)).thenReturn(Optional.ofNullable(mockincidentTicket()));
		assertEquals(Optional.of(mockincidentTicket()),searchIncidentService.findById(1));
	}

	@Test
	public void findAllTickets()  throws TicketNotFoundException
	{
		when(searchIncidentRepository.findAll()).thenReturn(Collections.singletonList(mockincidentTicket()));
		assertEquals(Collections.singletonList(mockincidentTicket()),searchIncidentService.getAllTickets());
	}

}
