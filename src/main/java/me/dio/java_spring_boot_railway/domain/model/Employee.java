package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;

/**
 * Funcionário vinculado a uma loja.
 */
@Entity
@Table(name = "tb_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;   // ex.: "Gerente", "Atendente"
    private Double salary; // ou BigDecimal

    // N:1 → Store
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
