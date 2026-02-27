package com.example.backend.dto;

public class StatsDTO {

    private long hp;
    private long attack;
    private long defense;
    private long specialAttack;
    private long specialDefense;
    private long speed;

    public StatsDTO(long hp, long attack, long defense, long specialAttack, long specialDefense, long speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public StatsDTO() {
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public long getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(long specialAttack) {
        this.specialAttack = specialAttack;
    }

    public long getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(long specialDefense) {
        this.specialDefense = specialDefense;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
}