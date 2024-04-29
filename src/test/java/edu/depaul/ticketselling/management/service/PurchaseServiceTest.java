package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Purchase;
import edu.depaul.ticketselling.management.repository.PurchaseRepository;
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

public class PurchaseServiceTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PurchaseService purchaseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPurchases() {
        // Given
        List<Purchase> purchases = Arrays.asList(new Purchase(), new Purchase());
        when(purchaseRepository.findAll()).thenReturn(purchases);

        // When
        List<Purchase> result = purchaseService.findAll();

        // Then
        assertEquals(purchases.size(), result.size());
        verify(purchaseRepository, times(1)).findAll();
    }

    // Add more test cases as needed for other methods in PurchaseService
}
