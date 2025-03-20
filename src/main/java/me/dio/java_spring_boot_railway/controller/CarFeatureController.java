package me.dio.java_spring_boot_railway.controller;

import me.dio.java_spring_boot_railway.dto.CarFeatureDTO;
import me.dio.java_spring_boot_railway.service.CarFeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car-features")
public class CarFeatureController {
    private final CarFeatureService service;

    public CarFeatureController(CarFeatureService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> addFeature(@RequestBody CarFeatureDTO dto) {
        service.addFeatureToCar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFeature(@RequestBody CarFeatureDTO dto) {
        service.removeFeatureFromCar(dto);
        return ResponseEntity.noContent().build();
    }
}
