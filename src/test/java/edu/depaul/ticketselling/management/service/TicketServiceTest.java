package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.backend.Populate;
import edu.depaul.ticketselling.backend.Ticket;
import edu.depaul.ticketselling.backend.ITicketRepository;
import edu.depaul.ticketselling.management.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    @Mock
    private ITicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Ticket> tickets = Populate.Tickets();
        when(ticketRepository.findAll()).thenReturn(tickets);

        // When
        List<Ticket> result = ticketService.findAll();

        // Then
        assertEquals(tickets.size(), result.size());
        verify(ticketRepository, times(1)).findAll();
    }

    // Add more tests for other methods as needed
}
