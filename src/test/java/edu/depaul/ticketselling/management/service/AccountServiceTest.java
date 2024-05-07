package edu.depaul.ticketselling.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.depaul.ticketselling.backend.Customer;
import edu.depaul.ticketselling.backend.IUserRepository;
import edu.depaul.ticketselling.backend.User;

public class AccountServiceTest {

    @Mock
    private IUserRepository<User> accountRepository;

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
        List<User> accounts = Arrays.asList(new Customer(), new Customer());
        when(accountRepository.findAll()).thenReturn(accounts);

        // When
        List<User> result = new ArrayList<>();
        Iterable<User> temp = accountService.findAll();
        temp.forEach(result::add);

        // Then
        assertEquals(accounts.size(), result.size());
        verify(accountRepository, times(1)).findAll();
    }

    // Add more tests for other methods as needed
}
