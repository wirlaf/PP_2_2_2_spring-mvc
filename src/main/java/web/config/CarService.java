package web.config;

import org.springframework.stereotype.Service;
import web.controller.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 2020));
        cars.add(new Car("Honda", "Civic", 2019));
        cars.add(new Car("Ford", "Mustang", 2018));
        cars.add(new Car("Chevrolet", "Camaro", 2017));
        cars.add(new Car("BMW", "X5", 2021));
    }

    public List<Car> getCars(int count) {
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}