package edu.depaul.ticketselling.backend;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByEventName(String eventName);
    List<Ticket> findByVenue(String venueName);
    Ticket findBySeatNumber(int seatNumber);
    List<Ticket> findByDate(LocalDate date);
}
