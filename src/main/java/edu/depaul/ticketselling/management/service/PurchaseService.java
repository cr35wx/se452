package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.backend.IPurchaseRepository;
import edu.depaul.ticketselling.backend.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PurchaseService {
//public class PurchaseService implements IPurchaseService
    private final IPurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> findAll() {
        return StreamSupport.stream(purchaseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Purchase findById(Long id) {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        return purchase.orElse(null);
    }

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }
}
