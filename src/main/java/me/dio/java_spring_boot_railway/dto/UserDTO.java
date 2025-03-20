package me.dio.java_spring_boot_railway.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String documentId;
    private Long accountId;
    private Long creditCardId;

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, String phone, String documentId, Long accountId, Long creditCardId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.documentId = documentId;
        this.accountId = accountId;
        this.creditCardId = creditCardId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }

    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    public Long getCreditCardId() { return creditCardId; }
    public void setCreditCardId(Long creditCardId) { this.creditCardId = creditCardId; }
}
