package web.Service;

import web.model.Car;

import java.util.ArrayList;

public interface CarService {
    ArrayList<Car> returnCar();
    ArrayList<Car> show(int num);
}
