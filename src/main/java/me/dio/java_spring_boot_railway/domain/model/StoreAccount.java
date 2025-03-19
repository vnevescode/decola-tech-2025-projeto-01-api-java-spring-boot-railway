package me.dio.java_spring_boot_railway.domain.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Conta da loja, para registrar saldo de faturamento.
 */
@Entity
@Table(name = "tb_store_accounts")
public class StoreAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;
    private String accountNumber; // ex.: "LOJA-123"

    // 1:1 → Store
    @OneToOne
    @JoinColumn(name = "store_id", unique = true)
    private Store store;

    // 1:N → StoreTransaction
    @OneToMany(mappedBy = "storeAccount", cascade = CascadeType.ALL)
    private List<StoreTransaction> storeTransactions;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<StoreTransaction> getStoreTransactions() {
        return storeTransactions;
    }

    public void setStoreTransactions(List<StoreTransaction> storeTransactions) {
        this.storeTransactions = storeTransactions;
    }
}
