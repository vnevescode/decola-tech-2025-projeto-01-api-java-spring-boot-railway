package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Car;
import me.dio.java_spring_boot_railway.domain.model.CarFeature;
import me.dio.java_spring_boot_railway.domain.model.CarFeatureId;
import me.dio.java_spring_boot_railway.domain.model.Feature;
import me.dio.java_spring_boot_railway.domain.repository.CarFeatureRepository;
import me.dio.java_spring_boot_railway.domain.repository.CarRepository;
import me.dio.java_spring_boot_railway.domain.repository.FeatureRepository;
import me.dio.java_spring_boot_railway.dto.CarFeatureDTO;
import me.dio.java_spring_boot_railway.service.CarFeatureService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CarFeatureServiceImpl implements CarFeatureService {

    private final CarFeatureRepository repository;
    private final CarRepository carRepository;
    private final FeatureRepository featureRepository;

    public CarFeatureServiceImpl(CarFeatureRepository repository,
                                 CarRepository carRepository,
                                 FeatureRepository featureRepository) {
        this.repository = repository;
        this.carRepository = carRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public void addFeatureToCar(CarFeatureDTO dto) {
        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new NoSuchElementException("Car ID not found."));
        Feature feature = featureRepository.findById(dto.getFeatureId())
                .orElseThrow(() -> new NoSuchElementException("Feature ID not found."));

        CarFeature cf = new CarFeature(car, feature);
        repository.save(cf);
    }

    @Override
    public void removeFeatureFromCar(CarFeatureDTO dto) {
        repository.deleteById(new CarFeatureId(dto.getCarId(), dto.getFeatureId()));
    }
}
