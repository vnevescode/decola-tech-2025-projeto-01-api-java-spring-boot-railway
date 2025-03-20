package me.dio.java_spring_boot_railway.dto;

import java.math.BigDecimal;

public class CreditCardDTO {

    private Long id;
    private String number;
    private String expirationDate;
    private BigDecimal creditLimit;

    public CreditCardDTO() {}

    public CreditCardDTO(Long id, String number, String expirationDate, BigDecimal creditLimit) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.creditLimit = creditLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
