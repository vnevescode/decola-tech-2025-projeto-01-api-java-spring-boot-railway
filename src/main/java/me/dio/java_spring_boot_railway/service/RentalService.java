package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.RentalDTO;

import java.util.List;

public interface RentalService {
    RentalDTO findById(Long id);
    RentalDTO create(RentalDTO rentalDTO);
    List<RentalDTO> findAll();
    void delete(Long id);
}
