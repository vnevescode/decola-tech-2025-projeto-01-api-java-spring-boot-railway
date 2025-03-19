package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Carro da frota, podendo ficar em uma Store.
 */
@Entity
@Table(name = "tb_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;

    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;

    private String plate; // se quiser unique = true

    private BigDecimal dailyRate;

    // N:1 → Store
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // 1:N → Rental (um carro pode ter várias locações ao longo do tempo)
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Rental> rentals;

    // Getters & Setters


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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
}
