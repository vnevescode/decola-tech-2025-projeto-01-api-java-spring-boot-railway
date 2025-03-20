package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.StoreTransactionDTO;

import java.util.List;

public interface StoreTransactionService {

    StoreTransactionDTO findById(Long id);
    StoreTransactionDTO create(StoreTransactionDTO storeTransactionDTO);
    List<StoreTransactionDTO> findAll();
    void delete(Long id);
}
