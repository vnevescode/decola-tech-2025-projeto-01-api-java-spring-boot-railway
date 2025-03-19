package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Registro de transações de crédito/débito de um cliente,
 * associadas à Account.
 */

@Entity
@Table(name = "tb_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "CREDIT" ou "DEBIT"
    private String operationType;

    private BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();

    // N:1 → Account
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
