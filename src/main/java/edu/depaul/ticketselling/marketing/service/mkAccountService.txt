package edu.depaul.ticketselling.marketing.service;

import edu.depaul.ticketselling.marketing.interfaces.mkIAccountService;
import edu.depaul.ticketselling.marketing.model.mkAccount;
import edu.depaul.ticketselling.marketing.model.mkEvent;
import edu.depaul.ticketselling.marketing.repository.mkAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class mkAccountService implements mkIAccountService {
    private final mkAccountRepository accountRepository;

    @Autowired
    public mkAccountService(mkAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public mkAccount findByEmailAndPassword(String email, String password) {
        return accountRepository.findByEmailAndPassword(email, password);
    }

    // public List<mkAccount> findUsersByEvent(mkEvent event) {
    //     return accountRepository.findUsersByEvent(event);
    // }

    public List<mkAccount> findAll() {
        return accountRepository.findAll();
    }

    public mkAccount save(mkAccount account) {
        return accountRepository.save(account);
    }

    public List<mkAccount> saveAll(List<mkAccount> accounts) {
        return accountRepository.saveAll(accounts);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

        public mkAccount updateAccount(Long id, mkAccount updatedAccount) {
            mkAccount existingAccount = accountRepository.findById(id)
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
