package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    AccountDTO findById(Long id);
    AccountDTO create(AccountDTO accountDTO);
    List<AccountDTO> findAll();
    void delete(Long id);
}
