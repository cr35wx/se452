package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.interfaces.IAccountService;
import edu.depaul.ticketselling.management.model.Account;
import edu.depaul.ticketselling.management.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByEmailAndPassword(String email, String password) {
        return accountRepository.findByEmailAndPassword(email, password);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> saveAll(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

        public Account updateAccount(Long id, Account updatedAccount) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + id));

        if (updatedAccount.getEmail() != null) {
            existingAccount.setEmail(updatedAccount.getEmail());
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
