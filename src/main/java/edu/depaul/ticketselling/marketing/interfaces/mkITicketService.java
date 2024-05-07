package edu.depaul.ticketselling.marketing.interfaces;

import edu.depaul.ticketselling.marketing.model.mkTicket;

import java.util.List;

public interface mkITicketService {
    List<mkTicket> findAll();

    mkTicket findTicketsByEventId(Long eventId);

    mkTicket save(mkTicket ticket);

    List<mkTicket> saveAll(List<mkTicket> tickets);

    mkTicket findById(Long id);

    void deleteTicket(Long id);
}
