package me.dio.java_spring_boot_railway.dto;

public class CarFeatureDTO {

    private Long carId;
    private Long featureId;

    public CarFeatureDTO() {}

    public CarFeatureDTO(Long carId, Long featureId) {
        this.carId = carId;
        this.featureId = featureId;
    }

    public Long getCarId() { return carId; }
    public void setCarId(Long carId) { this.carId = carId; }

    public Long getFeatureId() { return featureId; }
    public void setFeatureId(Long featureId) { this.featureId = featureId; }
}
