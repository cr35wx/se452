package edu.depaul.ticketselling.band;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
    Band findByBandName(String name);
}