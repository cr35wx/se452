package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.backend.Purchase;
import edu.depaul.ticketselling.management.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import edu.depaul.ticketselling.marketing.controller.OrderConfirmationController;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final OrderConfirmationController orderConfirmation; // Added

    @Autowired
    public PurchaseController(PurchaseService purchaseService, 
                            OrderConfirmationController orderConfirmation) {
        this.purchaseService = purchaseService;
        this.orderConfirmation = orderConfirmation; // Added
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        List<Purchase> purchases = purchaseService.findAll();
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        Purchase purchase = purchaseService.findById(id);
        if (purchase != null) {
            return ResponseEntity.ok(purchase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Additional functionality for the Order Confirmation Mail Send function.
     * 
     * @param orderConfirmation Order Confirmation Mail Send function. 
     * Added this feature to createPurchase, please check it.
     * 
     * @author Suhwan Kim
     */
    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase newPurchase = purchaseService.save(purchase);
        orderConfirmation.confirmOrder(newPurchase);// Added
        return ResponseEntity.ok(newPurchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
