package cde.mc.outageanalytics1.controller;

import cde.mc.outageanalytics1.service.UpdateIncidentService;
import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UpdateIncidentController {

    @Autowired
    UpdateIncidentService updateIncidentService;

    //Update Ticket Status to In Progress
    @PutMapping("/tickets/{ticketId}/InProgress")
    public IncidentTicket updateStatusInProgress(@Valid @PathVariable("ticketId") Integer ticketId) throws TicketNotFoundException {
        Optional<IncidentTicket> ticket=updateIncidentService.findById(ticketId);
        IncidentTicket incidentTicket=new IncidentTicket();
        incidentTicket=ticket.get();
        return updateIncidentService.updateStatusInProgress(ticketId);
    }
    //Update ticket status to Closed
    @PutMapping("/tickets/{ticketId}/Closed")
    public IncidentTicket updateStatusClosed(@Valid @PathVariable("ticketId") Integer ticketId) throws TicketNotFoundException {
        Optional<IncidentTicket> ticket=updateIncidentService.findById(ticketId);
        IncidentTicket incidentTicket=new IncidentTicket();
        incidentTicket=ticket.get();
        return updateIncidentService.updateStatusClosed(ticketId);
    }

    //Find Ticket by Id
    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<Optional<IncidentTicket>> getById(@PathVariable(value="ticketId") Integer ticketId) throws TicketNotFoundException {

        Optional<IncidentTicket> ticket=updateIncidentService.findById(ticketId);
        return ResponseEntity.ok().body(ticket);

    }

    //Save Tickets
    @PostMapping("/tickets")
    public ResponseEntity<IncidentTicket> addTicket( @RequestBody IncidentTicket incindentTicket)
    {
        return new ResponseEntity<>(updateIncidentService.save(incindentTicket), HttpStatus.OK);
    }


}
