package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;

public class StoreAccountDTO {
    private Long id;
    private BigDecimal balance;
    private String accountNumber;
    private Long storeId;

    public StoreAccountDTO() {}

    public StoreAccountDTO(Long id, BigDecimal balance, String accountNumber, Long storeId) {
        this.id = id;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.storeId = storeId;
    }

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

    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
