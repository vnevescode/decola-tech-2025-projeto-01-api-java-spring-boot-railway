package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;

public class AccountDTO {

    private Long id;
    private BigDecimal balance;
    private String accountNumber;
    private Long userId;

    public AccountDTO() {
    }

    public AccountDTO(Long id, BigDecimal balance, String accountNumber, Long userId) {
        this.id = id;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
