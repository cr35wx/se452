package edu.depaul.ticketselling.marketing.service;

import edu.depaul.ticketselling.marketing.interfaces.mkIPurchaseService;
import edu.depaul.ticketselling.marketing.model.mkPurchase;
import edu.depaul.ticketselling.marketing.repository.mkPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mkPurchaseService implements mkIPurchaseService {

    private final mkPurchaseRepository purchaseRepository;

    @Autowired
    public mkPurchaseService(mkPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public mkPurchase save(mkPurchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<mkPurchase> findAll() {
        return purchaseRepository.findAll();
    }

    public mkPurchase findById(Long id) {
        Optional<mkPurchase> purchase = purchaseRepository.findById(id);
        return purchase.orElse(null);
    }

    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }
}
