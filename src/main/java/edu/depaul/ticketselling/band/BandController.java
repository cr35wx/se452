package edu.depaul.ticketselling.band;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/bands")
public class BandController {
    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping
    public ResponseEntity<List<Band>> getAllBands() {
        List<Band> bands = bandService.findAll();
        return ResponseEntity.ok(bands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Band> getBandById(@PathVariable Long id) {
        return bandService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Band> getBandByName(@PathVariable String name) {
        Band band = bandService.findByName(name);
        if (band != null) {
            return ResponseEntity.ok(band);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/all")
    public ResponseEntity<List<Band>> createAllBands(@RequestBody List<Band> bands) {
        List<Band> createdBands = new ArrayList<>(bandService.saveAll(bands));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBands);
    }

    @PostMapping
    public ResponseEntity<Band> createBand(@RequestBody Band band) {
        Band createdBand = bandService.save(band);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBand);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBand(@PathVariable Long id) {
        bandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}