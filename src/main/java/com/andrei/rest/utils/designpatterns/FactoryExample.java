package com.andrei.rest.utils.designpatterns;

public class FactoryExample {
}

abstract class Vehicle {
    //... Vehicle common properties and methods
}

class Truck extends Vehicle {
    //... Truck common properties and methods
}


class Car extends Vehicle {
    //... Car common properties and methods
}


class Bicycle extends Vehicle {
    //... Bicycle common properties and methods
}

class VehicleFactory {

    public static Vehicle createVehicle(String type) {
        switch (type) {
            case "truck":
                return new Truck();
            case "car":
                return new Car();
            case "bicycle":
                return new Bicycle();
            default:
                throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}

