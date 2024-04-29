package edu.depaul.ticketselling.management.interfaces;


import edu.depaul.ticketselling.management.model.Purchase;

import java.util.List;

public interface IPurchaseService {

    Purchase save(Purchase purchase);

    List<Purchase> findAll();

    Purchase findById(Long id);

    void deleteById(Long id);
    
}
