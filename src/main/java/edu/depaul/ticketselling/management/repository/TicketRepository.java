package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Custom queries if needed
    List<Ticket> findTicketsByEventId(Long eventId);
}

