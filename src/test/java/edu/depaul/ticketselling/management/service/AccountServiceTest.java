package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Account;
import edu.depaul.ticketselling.management.repository.AccountRepository;
import edu.depaul.ticketselling.management.service.AccountService;
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

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Account> accounts = Arrays.asList(new Account(), new Account());
        when(accountRepository.findAll()).thenReturn(accounts);

        // When
        List<Account> result = accountService.findAll();

        // Then
        assertEquals(accounts.size(), result.size());
        verify(accountRepository, times(1)).findAll();
    }

    // Add more tests for other methods as needed
}
