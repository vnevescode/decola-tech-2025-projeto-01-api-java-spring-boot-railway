package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.StoreAccountDTO;
import me.dio.java_spring_boot_railway.service.StoreAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/store-accounts")
public class StoreAccountController {
    private final Logger logger = LoggerFactory.getLogger(StoreAccountController.class);
    private final StoreAccountService storeAccountService;

    public StoreAccountController(StoreAccountService storeAccountService) {
        this.storeAccountService = storeAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreAccountDTO> findById(@PathVariable Long id) {
        logger.info("Fetching store account with id {}", id);
        return ResponseEntity.ok(storeAccountService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StoreAccountDTO> create(@RequestBody StoreAccountDTO storeAccountDTO) {
        logger.info("Creating store account with account number {}", storeAccountDTO.getAccountNumber());
        StoreAccountDTO createdAccount = storeAccountService.create(storeAccountDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAccount.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAccount);
    }

    @GetMapping
    public ResponseEntity<List<StoreAccountDTO>> findAll() {
        logger.info("Fetching all store accounts");
        return ResponseEntity.ok(storeAccountService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting store account with id {}", id);
        storeAccountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
