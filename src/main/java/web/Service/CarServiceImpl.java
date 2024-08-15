package web.Service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;
    private static int year = 1990;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Rus", "Volga", ++year));
        cars.add(new Car("Rus", "Vesta", ++year));
        cars.add(new Car("Rus", "Kalina", ++year));
        cars.add(new Car("Rus", "Priora", ++year));
        cars.add(new Car("Rus", "Granta", ++year));
    }

    public List<Car> show(Integer num) {
        if (num != null) {
            return cars.stream().limit(num).collect(Collectors.toList());
        }else {
            return cars;
        }
    }
}
