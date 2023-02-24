package com.company;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Initializer {
    public static void initialize(Car car) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        for (Field field : car.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InitField.class)) {
                System.out.println("Enter value for " + field.getName() + " (" + field.getType().getName().split("\\.")[2] + ')');
                field.setAccessible(true);
                boolean fieldIsSet = false;
                while (!fieldIsSet) {
                    try {
                        Object value = inputConvert(scanner.next(), field);
                        field.set(car, value);
                        fieldIsSet = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Illegal argument");
                    }
                }
            }
        }
    }

    private static Object inputConvert(String s, Field field) {
        if (field.getType().equals(Integer.class)) {
            if (s.matches("[0-9]*")) {
                return Integer.valueOf(s);
            } else {
                throw new IllegalArgumentException();
            }
        } else return s;
    }
}
