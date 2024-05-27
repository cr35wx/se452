package edu.depaul.ticketselling.band;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandService {
    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public List<Band> saveAll(List<Band> bands) {
        return bandRepository.saveAll(bands);
    }

    public Band save(Band band) {
        return bandRepository.save(band);
    }

    public List<Band> findAll() {
        return bandRepository.findAll();
    }

    public Optional<Band> findById(Long id) {
        return bandRepository.findById(id);
    }

    public Band findByName(String name) {
        return bandRepository.findByBandName(name);
    }

    public void deleteById(Long id) {
        bandRepository.deleteById(id);
    }
}
