package edu.depaul.ticketselling.marketing.repository;

import edu.depaul.ticketselling.marketing.model.mkTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mkTicketRepository extends JpaRepository<mkTicket, Long> {

}
