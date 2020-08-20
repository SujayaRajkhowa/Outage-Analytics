package cde.mc.outageanalytics1.service;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import cde.mc.outageanalytics1.repository.SearchIncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchIncidentService {

    @Autowired
    SearchIncidentRepository searchIncidentRepository;


    //Search Incident using ID
    public Optional<IncidentTicket> findById(Integer ticketId) throws TicketNotFoundException {
        Optional<IncidentTicket> ticket=searchIncidentRepository.findById(ticketId);
        if(!ticket.isPresent()) {
            throw new TicketNotFoundException("id : " + ticketId);
        }
        else {
            return ticket;
        }
    }
    //Get all Tickets
    public List<IncidentTicket> getAllTickets() throws TicketNotFoundException {
        List<IncidentTicket> getAllTickets=searchIncidentRepository.findAll();
        if(getAllTickets==null)
        {
            throw new TicketNotFoundException("No tickets exists");
        }
        return getAllTickets;
    }
}
