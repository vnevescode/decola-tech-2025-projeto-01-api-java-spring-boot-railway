package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.StoreTransactionDTO;
import me.dio.java_spring_boot_railway.service.StoreTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/store-transactions")
public class StoreTransactionController {
    private final Logger logger = LoggerFactory.getLogger(StoreTransactionController.class);
    private final StoreTransactionService storeTransactionService;

    public StoreTransactionController(StoreTransactionService storeTransactionService) {
        this.storeTransactionService = storeTransactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreTransactionDTO> findById(@PathVariable Long id) {
        logger.info("Fetching store transaction with id {}", id);
        return ResponseEntity.ok(storeTransactionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StoreTransactionDTO> create(@RequestBody StoreTransactionDTO dto) {
        logger.info("Creating store transaction: amount={}, operation={}", dto.getAmount(), dto.getOperationType());
        StoreTransactionDTO created = storeTransactionService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public ResponseEntity<List<StoreTransactionDTO>> findAll() {
        logger.info("Fetching all store transactions");
        return ResponseEntity.ok(storeTransactionService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting store transaction with id {}", id);
        storeTransactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
