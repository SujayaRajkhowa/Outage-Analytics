package cde.mc.outageanalytics1.service;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.repository.IncidentRepository;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository incidentRepository;

    //Find ticket by ID
    public Optional<IncidentTicket> findById(Integer ticketId) throws TicketNotFoundException {
        Optional<IncidentTicket> ticket=incidentRepository.findById(ticketId);
        if(!ticket.isPresent())
        {
            throw new TicketNotFoundException("id - "+ticketId);
        }
        return ticket;
    }

    //Create Ticket
    public IncidentTicket addTicket(IncidentTicket incindentTicket)
    {
        return incidentRepository.save(incindentTicket);
    }

    //Fetch All Tickets
    public List<IncidentTicket> fetchIncidentList() {
        List<IncidentTicket> incidents = incidentRepository.findAll();
        return incidents.stream().collect(Collectors.toList());

    }
}

