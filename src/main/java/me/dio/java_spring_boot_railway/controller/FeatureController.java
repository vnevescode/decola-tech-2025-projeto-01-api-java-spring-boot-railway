package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.FeatureDTO;
import me.dio.java_spring_boot_railway.service.FeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/features")
public class FeatureController {

    private final Logger logger = LoggerFactory.getLogger(FeatureController.class);
    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDTO> findById(@PathVariable Long id) {
        logger.info("Fetching feature with id {}", id);
        FeatureDTO featureDTO = featureService.findById(id);
        return ResponseEntity.ok(featureDTO);
    }

    @PostMapping
    public ResponseEntity<FeatureDTO> create(@RequestBody FeatureDTO featureDTO) {
        logger.info("Creating new feature with name '{}'", featureDTO.getName());
        FeatureDTO createdFeature = featureService.create(featureDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFeature.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdFeature);
    }

    @GetMapping
    public ResponseEntity<List<FeatureDTO>> findAll() {
        logger.info("Fetching all features");
        List<FeatureDTO> features = featureService.findAll();
        return ResponseEntity.ok(features);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting feature with id {}", id);
        featureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
