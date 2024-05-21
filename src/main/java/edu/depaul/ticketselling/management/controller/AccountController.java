package edu.depaul.ticketselling.management.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.management.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getAccountByEmail(@PathVariable String email, @PathVariable String password) {
        User account = accountService.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllAccounts() {
        List<User> accounts = StreamSupport.stream(accountService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<User> createAccount(@RequestBody User account) {
        User newAccount = accountService.save(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<User>> createAccounts(@RequestBody List<User> accounts) {
        List<User> newAccounts = StreamSupport.stream(accountService.saveAll(accounts).spliterator(), false)
                .collect(Collectors.toList());
        return new ResponseEntity<>(newAccounts, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateAccount(@PathVariable Long id, @RequestBody User updatedAccount) {
        User updated = accountService.updateAccount(id, updatedAccount);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
