package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    TransactionDTO findById(Long id);
    TransactionDTO create(TransactionDTO transactionDTO);
    List<TransactionDTO> findAll();
    void delete(Long id);
}
