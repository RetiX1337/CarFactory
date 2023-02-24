package com.company;


public class CarAssembler {

    public Car carAssemble() {
        Car car = new Car();
        try {
            Initializer.initialize(car);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(car);
        return car;
    }
}
