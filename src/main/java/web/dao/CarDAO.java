package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;

@Component
public class CarDAO {
    private List<Car> cars = List.of(
            new Car("Volvo", "white", 2024),
            new Car("BMW", "red", 2023),
            new Car("Lada", "black", 2022),
            new Car("Nissan", "orange", 2021),
            new Car("Chery", "purple", 2022)
    );

    public List<Car> show(int count) {
        if (count == 0 || count >= 5) {
            return cars;
        } else {
            return cars.stream()
                    .limit(count)
                    .toList();
        }
    }
}
