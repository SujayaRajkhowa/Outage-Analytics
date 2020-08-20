package cde.mc.outageanalytics1.controller;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import cde.mc.outageanalytics1.service.SearchIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SearchIncidentController {

    @Autowired
    private SearchIncidentService searchIncidentService;


    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<IncidentTicket>getTicketById(@Valid @PathVariable(value="ticketId") Integer ticketId)throws TicketNotFoundException{

        Optional<IncidentTicket> ticket=searchIncidentService.findById(ticketId);
        IncidentTicket incidentTicket = new IncidentTicket();
        incidentTicket =ticket.get();

        return ResponseEntity.ok().body(incidentTicket);

    }

    @GetMapping("/tickets")
    public List<IncidentTicket> findAllTickets() throws TicketNotFoundException
    {
        List<IncidentTicket> tickets=searchIncidentService.getAllTickets();
        return tickets;
    }



}
