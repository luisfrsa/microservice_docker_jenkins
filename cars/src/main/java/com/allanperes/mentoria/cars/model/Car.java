package com.allanperes.mentoria.cars.model;

public class Car {

    private String brand;
    private Long year;
    private String collor;

    public Car(String brand, Long year, String collor) {
        this.brand = brand;
        this.year = year;
        this.collor = collor;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getCollor() {
        return collor;
    }

    public void setCollor(String collor) {
        this.collor = collor;
    }
}
