package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.domain.model.Car;
import me.dio.java_spring_boot_railway.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO findById(Long id);
    CarDTO create(CarDTO carDTO);
    List<CarDTO> findAll();
    void delete(Long id);
}
