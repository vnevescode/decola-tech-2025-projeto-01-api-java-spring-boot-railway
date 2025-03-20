package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.CreditCardDTO;

import java.util.List;

public interface CreditCardService {
    CreditCardDTO findById(Long id);
    CreditCardDTO create(CreditCardDTO dto);
    List<CreditCardDTO> findAll();
    void delete(Long id);
}
