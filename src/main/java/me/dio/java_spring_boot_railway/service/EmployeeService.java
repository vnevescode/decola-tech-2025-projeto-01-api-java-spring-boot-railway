package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO findById(Long id);
    EmployeeDTO create(EmployeeDTO dto);
    List<EmployeeDTO> findAll();
    void delete(Long id);
}
