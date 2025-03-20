package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.StoreAccountDTO;

import java.util.List;

public interface StoreAccountService {
    StoreAccountDTO findById(Long id);
    StoreAccountDTO create(StoreAccountDTO storeAccountDTO);
    List<StoreAccountDTO> findAll();
    void delete(Long id);
}
