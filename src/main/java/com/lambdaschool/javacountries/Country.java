package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private final static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int mass;
    private int age;


    public Country(String name, int population, int mass, int age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.mass = mass;
        this.age = age;
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
