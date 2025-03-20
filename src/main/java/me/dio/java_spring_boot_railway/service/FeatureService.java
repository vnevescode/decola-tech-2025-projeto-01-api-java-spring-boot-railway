package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.FeatureDTO;

import java.util.List;

public interface FeatureService {
    FeatureDTO findById(Long id);
    FeatureDTO create(FeatureDTO featureDTO);
    List<FeatureDTO> findAll();
    void delete(Long id);
}
