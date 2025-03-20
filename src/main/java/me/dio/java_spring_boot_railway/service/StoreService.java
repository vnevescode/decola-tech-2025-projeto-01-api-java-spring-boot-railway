package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO findById(Long id);
    StoreDTO create(StoreDTO storeDTO);
    List<StoreDTO> findAll();
    void delete(Long id);
}
