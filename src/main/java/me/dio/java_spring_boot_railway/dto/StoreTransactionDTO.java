package me.dio.java_spring_boot_railway.dto;

import me.dio.java_spring_boot_railway.domain.model.enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StoreTransactionDTO {
    private Long id;
    private OperationType operationType;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private Long storeAccountId;

    public StoreTransactionDTO() {}

    public StoreTransactionDTO(Long id, OperationType operationType, BigDecimal amount, LocalDateTime createdAt, Long storeAccountId) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.createdAt = createdAt;
        this.storeAccountId = storeAccountId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getOperationType() {
        return operationType;
    }
    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStoreAccountId() {
        return storeAccountId;
    }
    public void setStoreAccountId(Long storeAccountId) {
        this.storeAccountId = storeAccountId;
    }
}
