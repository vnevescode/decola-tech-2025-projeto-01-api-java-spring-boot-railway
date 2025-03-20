package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Car;
import me.dio.java_spring_boot_railway.domain.model.Store;
import me.dio.java_spring_boot_railway.domain.repository.CarRepository;
import me.dio.java_spring_boot_railway.domain.repository.StoreRepository;
import me.dio.java_spring_boot_railway.dto.CarDTO;
import me.dio.java_spring_boot_railway.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final StoreRepository storeRepository;

    public CarServiceImpl(CarRepository carRepository, StoreRepository storeRepository) {
        this.carRepository = carRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public CarDTO findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car ID " + id + " not found."));
        return convertToDTO(car);
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        if (carRepository.existsByPlate(carDTO.getPlate())) {
            throw new IllegalArgumentException("Car plate already exists.");
        }
        Car car = convertToEntity(carDTO);
        Car savedCar = carRepository.save(car);
        return convertToDTO(savedCar);
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new NoSuchElementException("Car ID " + id + " not found.");
        }
        carRepository.deleteById(id);
    }

    // Métodos auxiliares para conversão
    private CarDTO convertToDTO(Car car) {
        return new CarDTO(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getDailyRate(),
                car.getManufacturingYear(),
                car.getStore() != null ? car.getStore().getId() : null
        );
    }

    private Car convertToEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setPlate(carDTO.getPlate());
        car.setDailyRate(carDTO.getDailyRate());
        car.setManufacturingYear(carDTO.getManufacturingYear());

        if (carDTO.getStoreId() != null) {
            Store store = storeRepository.findById(carDTO.getStoreId())
                    .orElseThrow(() -> new NoSuchElementException("Store ID " + carDTO.getStoreId() + " not found."));
            car.setStore(store);
        } else {
            car.setStore(null);
        }

        return car;
    }
}
