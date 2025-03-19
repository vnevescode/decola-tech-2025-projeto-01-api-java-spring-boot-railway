package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;

/**
 * Tabela de junção N:N entre Car e Feature.
 */
@Entity
@Table(name = "tb_car_features")
public class CarFeature {

    @EmbeddedId
    private CarFeatureId id = new CarFeatureId();

    // N:1 → Car
    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    private Car car;

    // N:1 → Feature
    @ManyToOne
    @MapsId("featureId")
    @JoinColumn(name = "feature_id")
    private Feature feature;

    // (Opcional) dados extras, ex.: addedAt, notes, etc.

    public CarFeature() {
    }

    public CarFeature(Car car, Feature feature) {
        this.car = car;
        this.feature = feature;
        this.id.setCarId(car.getId());
        this.id.setFeatureId(feature.getId());
    }

    public CarFeatureId getId() {
        return id;
    }
    public void setId(CarFeatureId id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public Feature getFeature() {
        return feature;
    }
    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
