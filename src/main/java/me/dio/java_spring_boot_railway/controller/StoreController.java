package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.StoreDTO;
import me.dio.java_spring_boot_railway.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/stores")
public class StoreController {
    private final Logger logger = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> findById(@PathVariable Long id) {
        logger.info("Fetching store with id {}", id);
        StoreDTO storeDTO = storeService.findById(id);
        return ResponseEntity.ok(storeDTO);
    }

    @PostMapping
    public ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO) {
        logger.info("Creating store {}", storeDTO.getName());
        StoreDTO createdStore = storeService.create(storeDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdStore.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdStore);
    }

    @GetMapping
    public ResponseEntity<List<StoreDTO>> findAll() {
        logger.info("Fetching all stores");
        return ResponseEntity.ok(storeService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting store with id {}", id);
        storeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
