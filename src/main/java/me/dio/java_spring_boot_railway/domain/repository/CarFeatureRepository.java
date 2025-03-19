package me.dio.java_spring_boot_railway.domain.repository;

import me.dio.java_spring_boot_railway.domain.model.CarFeature;
import me.dio.java_spring_boot_railway.domain.model.CarFeatureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFeatureRepository extends JpaRepository<CarFeature, CarFeatureId> {
}