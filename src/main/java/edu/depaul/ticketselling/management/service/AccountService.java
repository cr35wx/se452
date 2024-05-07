package edu.depaul.ticketselling.management.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.ticketselling.backend.IUserRepository;
import edu.depaul.ticketselling.backend.User;

@Service
public class AccountService {
//public class AccountService implements IAccountService {
    private final IUserRepository<User> accountRepository;

    @Autowired
    public AccountService(IUserRepository<User> accountRepository) {
        this.accountRepository = accountRepository;
    }

    public User findByEmailAndPassword(String email, String password) {
        return accountRepository.findByEmailAddressAndPassword(email, password);
    }

    public List<User> findAll() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User save(User account) {
        return accountRepository.save(account);
    }

    public List<User> saveAll(List<User> accounts) {
        accountRepository.saveAll(accounts);
        return accounts;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public User updateAccount(Long id, User updatedAccount) {
        User existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + id));

        if (updatedAccount.getEmailAddress() != null) {
            existingAccount.setEmailAddress(updatedAccount.getEmailAddress());
        }
        if (updatedAccount.getPassword() != null) {
            existingAccount.setPassword(updatedAccount.getPassword());
        }
        if (updatedAccount.getPhoneNumber() != null) {
            existingAccount.setPhoneNumber(updatedAccount.getPhoneNumber());
        }

        return accountRepository.save(existingAccount);
    }
}
