package me.dio.java_spring_boot_railway.domain.model;
import me.dio.java_spring_boot_railway.domain.model.enums.OperationType;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Transação de crédito/débito na conta da loja.
 */
@Entity
@Table(name = "tb_store_transactions")
public class StoreTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usando enum e salvando como texto
    @Enumerated(EnumType.STRING)
    private OperationType operationType; // CREDIT ou DEBIT

    private BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();

    // N:1 → StoreAccount
    @ManyToOne
    @JoinColumn(name = "store_account_id")
    private StoreAccount storeAccount;

    // Getters & Setters

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

    public StoreAccount getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(StoreAccount storeAccount) {
        this.storeAccount = storeAccount;
    }
}
