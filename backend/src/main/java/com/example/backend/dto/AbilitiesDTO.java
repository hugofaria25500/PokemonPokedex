package com.example.backend.dto;

public class AbilitiesDTO {

    private String name;

    private String description;

    public AbilitiesDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AbilitiesDTO() {
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
