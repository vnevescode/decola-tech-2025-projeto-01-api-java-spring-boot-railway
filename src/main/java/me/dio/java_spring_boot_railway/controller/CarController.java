package me.dio.java_spring_boot_railway.controller;
import me.dio.java_spring_boot_railway.domain.model.Car;
import me.dio.java_spring_boot_railway.dto.CarDTO;
import me.dio.java_spring_boot_railway.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    private final CarService carService;
    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long id) {
        logger.info("Fetching car with id {}", id);
        CarDTO carDTO = carService.findById(id);
        return ResponseEntity.ok(carDTO);
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO) {
        logger.info("Creating a new car: {}", carDTO.getPlate());
        CarDTO createdCar = carService.create(carDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCar.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCar);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> findAll() {
        logger.info("Fetching all cars");
        return ResponseEntity.ok(carService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting car with id {}", id);
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
