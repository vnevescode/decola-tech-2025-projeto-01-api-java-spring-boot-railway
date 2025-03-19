package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Cartão de crédito vinculado ao cliente (User).
 */
@Entity
@Table(name = "tb_credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;         // "XXXX-XXXX-XXXX-1234"

    private String expirationDate; // ex.: "12/2028"
    private String cvv;           // ex.: "123"

    private BigDecimal creditLimit; // limite total

    // Getters & Setters

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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
