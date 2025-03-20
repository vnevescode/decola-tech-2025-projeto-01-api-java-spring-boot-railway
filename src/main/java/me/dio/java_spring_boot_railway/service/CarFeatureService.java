package me.dio.java_spring_boot_railway.service;

import me.dio.java_spring_boot_railway.dto.CarFeatureDTO;

public interface CarFeatureService {
    void addFeatureToCar(CarFeatureDTO carFeatureDTO);
    void removeFeatureFromCar(CarFeatureDTO carFeatureDTO);
}
