package com.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Qualities {

    public static final int MAX_VALUE = 10;

    private int responsibility;
    private int honest;
    private int intelligence;
    private int beauty;

    public Qualities() {

    }

    public Qualities(int responsibility, int honest, int intelligence, int beauty) {
        this.responsibility = responsibility;
        this.honest = honest;
        this.intelligence = intelligence;
        this.beauty = beauty;
    }

    public static Qualities generate() {
        Qualities result = new Qualities();

        result.responsibility = ThreadLocalRandom.current().nextInt(0, MAX_VALUE + 1);
        result.honest = ThreadLocalRandom.current().nextInt(0, MAX_VALUE + 1);
        result.intelligence = ThreadLocalRandom.current().nextInt(0, MAX_VALUE + 1);
        result.beauty = ThreadLocalRandom.current().nextInt(0, MAX_VALUE + 1);

        return result;
    }

    public int getResponsibility() {
        return responsibility;
    }

    public int getHonest() {
        return honest;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getBeauty() {
        return beauty;
    }

    @Override
    public String toString() {
        return "responsibility: " + responsibility + ", honest: " + honest +", intelligence: " + intelligence + ", beauty " + beauty;
    }
}
