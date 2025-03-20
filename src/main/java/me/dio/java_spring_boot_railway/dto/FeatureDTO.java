package me.dio.java_spring_boot_railway.dto;

public class FeatureDTO {
    private Long id;
    private String name;

    public FeatureDTO() {}

    public FeatureDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
