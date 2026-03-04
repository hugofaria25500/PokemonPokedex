package com.example.backend.dto;

public class AbilitiyDTO {

    private String name;

    private String description;

    public AbilitiyDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbilitiyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
