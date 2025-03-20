package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.TransactionDTO;
import me.dio.java_spring_boot_railway.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
        logger.info("Fetching transaction with id {}", id);
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO dto) {
        logger.info("Creating transaction: amount={}, operation={}", dto.getAmount(), dto.getOperationType());
        TransactionDTO created = transactionService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        logger.info("Fetching all transactions");
        return ResponseEntity.ok(transactionService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting transaction with id {}", id);
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
