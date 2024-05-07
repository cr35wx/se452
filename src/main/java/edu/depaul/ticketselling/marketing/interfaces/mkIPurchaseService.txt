package edu.depaul.ticketselling.marketing.interfaces;

import edu.depaul.ticketselling.marketing.model.mkPurchase;

import java.util.List;

public interface mkIPurchaseService {
    mkPurchase save(mkPurchase purchase);

    List<mkPurchase> findAll();

    mkPurchase findById(Long id);

    void deleteById(Long id);
}
