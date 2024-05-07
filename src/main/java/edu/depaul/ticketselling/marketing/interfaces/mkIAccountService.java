package edu.depaul.ticketselling.marketing.interfaces;

import edu.depaul.ticketselling.marketing.model.mkAccount;

import java.util.List;

public interface mkIAccountService {
    mkAccount findByEmailAndPassword(String email, String password);

    // List<mkAccount> findUsersByEvent(mkEvent event);

    List<mkAccount> findAll();

    mkAccount save(mkAccount account);

    List<mkAccount> saveAll(List<mkAccount> accounts);

    void deleteAccount(Long id);

    mkAccount updateAccount(Long id, mkAccount updatedAccount);
}