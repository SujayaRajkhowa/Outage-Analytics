package cde.mc.outageanalytics1.repository;

import cde.mc.outageanalytics1.entity.IncidentTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentTicket, Integer> {
}
