package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;

public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String plate;
    private BigDecimal dailyRate;
    private Integer manufacturingYear;
    private Long storeId; // Apenas ID da Store para evitar sobrecarregar o DTO

    // Construtor padrão
    public CarDTO() {
    }

    // Construtor personalizado para conversão
    public CarDTO(Long id, String brand, String model, String plate, BigDecimal dailyRate,
                  Integer manufacturingYear, Long storeId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.dailyRate = dailyRate;
        this.manufacturingYear = manufacturingYear;
        this.storeId = storeId;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
