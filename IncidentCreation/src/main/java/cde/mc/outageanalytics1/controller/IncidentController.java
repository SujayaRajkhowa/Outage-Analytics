package cde.mc.outageanalytics1.controller;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.service.IncidentService;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping("/tickets")
    public ResponseEntity<IncidentTicket> addTicket( @RequestBody IncidentTicket incindentTicket)
    {
        return new ResponseEntity<>(incidentService.addTicket(incindentTicket),HttpStatus.CREATED);
    }

    @GetMapping("/tickets/{ticketId}")
    public ResponseEntity<Optional<IncidentTicket>> getById(@PathVariable(value="ticketId") Integer ticketId) throws TicketNotFoundException {

        Optional<IncidentTicket> ticket=incidentService.findById(ticketId);
        IncidentTicket incidentTicket=new IncidentTicket();
        incidentTicket=ticket.get();
        return ResponseEntity.ok().body(ticket);

    }

    @GetMapping("/tickets")
    public ResponseEntity<List<IncidentTicket>> getAll() {

        List<IncidentTicket> incidents = incidentService.fetchIncidentList();
        return !CollectionUtils.isEmpty(incidents) ? new ResponseEntity(incidents, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
