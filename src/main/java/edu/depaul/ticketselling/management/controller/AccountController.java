package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.management.model.Account;
import edu.depaul.ticketselling.management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Account> getAccountByEmail(@PathVariable String email, @PathVariable String password) {
        Account account = accountService.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.save(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Account>> createAccounts(@RequestBody List<Account> accounts) {
        List<Account> newAccounts = accountService.saveAll(accounts);
        return new ResponseEntity<>(newAccounts, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        Account updated = accountService.updateAccount(id, updatedAccount);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}