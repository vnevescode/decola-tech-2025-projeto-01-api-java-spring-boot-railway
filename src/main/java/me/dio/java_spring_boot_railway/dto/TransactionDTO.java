package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;
    private String operationType; // "CREDIT" ou "DEBIT"
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private Long accountId;

    public TransactionDTO() {}

    public TransactionDTO(Long id, String operationType, BigDecimal amount, LocalDateTime createdAt, Long accountId) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.createdAt = createdAt;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
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

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
