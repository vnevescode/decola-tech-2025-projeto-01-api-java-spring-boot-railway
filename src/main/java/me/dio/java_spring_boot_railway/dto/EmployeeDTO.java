package me.dio.java_spring_boot_railway.dto;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String role;
    private Double salary;
    private Long storeId;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String role, Double salary, Long storeId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.storeId = storeId;
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
