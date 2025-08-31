package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    public static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Toyota", "Camry", 2020));
        carList.add(new Car("BMW", "X5", 2018));
        carList.add(new Car("Audi", "A4", 2019));
        carList.add(new Car("Mercedes", "C-class", 2021));
        carList.add(new Car("Honda", "Civic", 2017));
    }
}
