package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa uma locação (rent) de carro.
 */
@Entity
@Table(name = "tb_rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Column(precision = 13, scale = 2)
    private BigDecimal totalValue;

    private String status; // Ex.: "ABERTA", "FINALIZADA"

    // N:1 → User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // N:1 → Car
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    // N:1 → Store (retirada)
    @ManyToOne
    @JoinColumn(name = "pick_up_store_id")
    private Store pickUpStore;

    // N:1 → Store (devolução)
    @ManyToOne
    @JoinColumn(name = "drop_off_store_id")
    private Store dropOffStore;

    // Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Store getPickUpStore() {
        return pickUpStore;
    }

    public void setPickUpStore(Store pickUpStore) {
        this.pickUpStore = pickUpStore;
    }

    public Store getDropOffStore() {
        return dropOffStore;
    }

    public void setDropOffStore(Store dropOffStore) {
        this.dropOffStore = dropOffStore;
    }
}
