package cde.mc.outageanalytics1.service;


import cde.mc.outageanalytics1.repository.UpdateIncidentRepository;
import cde.mc.outageanalytics1.entity.IncidentTicket;
import cde.mc.outageanalytics1.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateIncidentService {

    @Autowired
    private UpdateIncidentRepository updateIncidentRepository;

    //Save Incident
    public IncidentTicket save(IncidentTicket incidentTicket)
    {
        return updateIncidentRepository.save(incidentTicket);
    }

    //Find Incident by Id
    public Optional<IncidentTicket> findById(Integer ticketId) throws TicketNotFoundException {
        Optional<IncidentTicket> ticket=updateIncidentRepository.findById(ticketId);
        if(!ticket.isPresent()){
            throw new TicketNotFoundException("id : " +ticketId);
        }
        else {
            return ticket;
        }
    }

    //Update Incident status to In Progress
    public IncidentTicket updateStatusInProgress(Integer ticketId) throws TicketNotFoundException {
        IncidentTicket incidentTicket=updateIncidentRepository.findByTicketId(ticketId);
        if(incidentTicket==null){
            throw new TicketNotFoundException("id : " +ticketId);
        }
        else {
            incidentTicket.setStatus("In Progress");
            IncidentTicket updateIncidentTicket = updateIncidentRepository.save(incidentTicket);
            return updateIncidentTicket;
        }
    }

    //Update Incident Status to Closed
    public IncidentTicket updateStatusClosed(Integer ticketId) throws TicketNotFoundException {
        IncidentTicket incidentTicket=updateIncidentRepository.findByTicketId(ticketId);
        if(incidentTicket==null){
            throw new TicketNotFoundException("id : " +ticketId);
        }
        else {
            incidentTicket.setStatus("Closed");
            IncidentTicket updateIncidentTicket = updateIncidentRepository.save(incidentTicket);
            return updateIncidentTicket;

        }
    }


}
