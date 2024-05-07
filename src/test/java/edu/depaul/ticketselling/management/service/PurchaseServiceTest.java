package edu.depaul.ticketselling.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.depaul.ticketselling.backend.IPurchaseRepository;
import edu.depaul.ticketselling.backend.Purchase;

public class PurchaseServiceTest {

    @Mock
    private IPurchaseRepository purchaseRepository;

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
