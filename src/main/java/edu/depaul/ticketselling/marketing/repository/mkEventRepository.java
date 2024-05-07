package edu.depaul.ticketselling.marketing.repository;

import edu.depaul.ticketselling.marketing.model.mkEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mkEventRepository extends JpaRepository<mkEvent, Long> {
    mkEvent findByName(String name);
}