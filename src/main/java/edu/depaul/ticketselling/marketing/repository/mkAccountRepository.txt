package edu.depaul.ticketselling.marketing.repository;

import edu.depaul.ticketselling.marketing.model.mkAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mkAccountRepository extends JpaRepository<mkAccount, Long> {
    mkAccount findByEmailAndPassword(String email, String password);
}
