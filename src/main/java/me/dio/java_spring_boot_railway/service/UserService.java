package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    UserDTO create(UserDTO userDTO);
    List<UserDTO> findAll();
    void delete(Long id);
}
