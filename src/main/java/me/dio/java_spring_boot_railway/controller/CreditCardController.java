package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.CreditCardDTO;
import me.dio.java_spring_boot_railway.service.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/credit-cards")
public class CreditCardController {
    private final CreditCardService creditCardService;
    private final Logger logger = LoggerFactory.getLogger(CreditCardController.class);

    public CreditCardController(CreditCardService service) {
        this.creditCardService = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardDTO> findById(@PathVariable Long id) {
        logger.info("Fetching credit card id {}", id);
        return ResponseEntity.ok(creditCardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CreditCardDTO> create(@RequestBody CreditCardDTO dto) {
        logger.info("Creating credit card number {}", dto.getNumber());
        var created = creditCardService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CreditCardDTO>> findAll() {
        logger.info("Fetching all credit cards");
        return ResponseEntity.ok(creditCardService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting credit card id {}", id);
        creditCardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
