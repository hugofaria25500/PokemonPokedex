package com.example.backend.entity;

public class Abilities {

    private String name;

    private String description;

    public Abilities(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Abilities() {
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
