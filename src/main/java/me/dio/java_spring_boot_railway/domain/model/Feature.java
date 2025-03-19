package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;

/**
 * Por exemplo: "Ar-condicionado", "Automático", "Blindado" etc.
 */
@Entity
@Table(name = "tb_features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Se usar a tabela de associação CarFeature, não precisamos ManyToMany aqui.

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
}
