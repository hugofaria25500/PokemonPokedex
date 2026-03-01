package com.example.backend.dto;

public class StatDTO {


    private String name;
    private long value;

    public StatDTO(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public StatDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}