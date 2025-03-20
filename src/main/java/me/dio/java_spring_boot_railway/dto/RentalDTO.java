package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentalDTO {

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal totalValue;
    private String status;
    private Long userId;
    private Long carId;
    private Long pickUpStoreId;
    private Long dropOffStoreId;

    public RentalDTO() {}

    public RentalDTO(Long id, LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalValue, String status,
                     Long userId, Long carId, Long pickUpStoreId, Long dropOffStoreId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalValue = totalValue;
        this.status = status;
        this.userId = userId;
        this.carId = carId;
        this.pickUpStoreId = pickUpStoreId;
        this.dropOffStoreId = dropOffStoreId;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getPickUpStoreId() {
        return pickUpStoreId;
    }

    public void setPickUpStoreId(Long pickUpStoreId) {
        this.pickUpStoreId = pickUpStoreId;
    }

    public Long getDropOffStoreId() {
        return dropOffStoreId;
    }

    public void setDropOffStoreId(Long dropOffStoreId) {
        this.dropOffStoreId = dropOffStoreId;
    }
}
