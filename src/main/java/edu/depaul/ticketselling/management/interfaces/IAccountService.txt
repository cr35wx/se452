package edu.depaul.ticketselling.management.interfaces;

import edu.depaul.ticketselling.management.model.Account;

import java.util.List;

public interface IAccountService {

    Account findByEmailAndPassword(String email, String password);

    List<Account> findAll();

    Account save(Account account);

    List<Account> saveAll(List<Account> accounts);

    void deleteAccount(Long id);

    Account updateAccount(Long id, Account updatedAccount);
}