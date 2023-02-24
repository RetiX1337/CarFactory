package com.company;

public class Car {
    @InitField
    private String color;
    @InitField
    private String model;
    @InitField
    private String make;
    @InitField
    private Integer year;

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }
}
