package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

public class TicketServiceTest {
    
    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Mock the behavior of ticketRepository.findAll() to return a list of tickets
        List<Ticket> tickets = Arrays.asList(
                new Ticket(1L, 101L, new BigDecimal("50.00"), "A101"),
                new Ticket(2L, 102L, new BigDecimal("60.00"), "B101")
        );
        when(ticketRepository.findAll()).thenReturn(tickets);

        // Call the service method
        List<Ticket> result = ticketService.findAll();

        // Verify that the result matches the expected list of tickets
        assertIterableEquals(tickets, result);
    }

    // Add more test cases for other methods as needed
}
