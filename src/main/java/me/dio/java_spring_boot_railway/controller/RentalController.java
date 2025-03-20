package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.RentalDTO;
import me.dio.java_spring_boot_railway.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final Logger logger = LoggerFactory.getLogger(RentalController.class);
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> findById(@PathVariable Long id) {
        logger.info("Fetching rental with id {}", id);
        return ResponseEntity.ok(rentalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RentalDTO> create(@RequestBody RentalDTO rentalDTO) {
        logger.info("Creating rental for user id {}", rentalDTO.getUserId());
        RentalDTO created = rentalService.create(rentalDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> findAll() {
        logger.info("Fetching all rentals");
        return ResponseEntity.ok(rentalService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting rental with id {}", id);
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
