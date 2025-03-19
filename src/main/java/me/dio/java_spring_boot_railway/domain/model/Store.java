package me.dio.java_spring_boot_railway.domain.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa a loja (filial) de uma locadora de carros.
 */


@Entity
@Table(name = "tb_stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String state;

    // 1:1 → StoreAccount
    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreAccount storeAccount;

    // 1:N → Employee
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // 1:N → Car (opcional: controle de estoque de carros por loja)
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Car> cars;

    // 1:N → Rental (loja como pick_up e/ou drop_off)
    @OneToMany(mappedBy = "pickUpStore", cascade = CascadeType.ALL)
    private List<Rental> rentalsAsPickUp;

    @OneToMany(mappedBy = "dropOffStore", cascade = CascadeType.ALL)
    private List<Rental> rentalsAsDropOff;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public StoreAccount getStoreAccount() {
        return storeAccount;
    }

    public void setStoreAccount(StoreAccount storeAccount) {
        this.storeAccount = storeAccount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Rental> getRentalsAsPickUp() {
        return rentalsAsPickUp;
    }

    public void setRentalsAsPickUp(List<Rental> rentalsAsPickUp) {
        this.rentalsAsPickUp = rentalsAsPickUp;
    }

    public List<Rental> getRentalsAsDropOff() {
        return rentalsAsDropOff;
    }

    public void setRentalsAsDropOff(List<Rental> rentalsAsDropOff) {
        this.rentalsAsDropOff = rentalsAsDropOff;
    }

}
