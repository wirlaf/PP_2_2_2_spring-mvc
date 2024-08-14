package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model) {
        model.addAttribute("cars",carService.returnCar());
        return "cars";
    }
    @GetMapping(value = "/cars?count={num}")
    public String showCars(ModelMap model, @PathVariable("num") int num) {
        ArrayList<Car> cars = carService.show(num);
        model.addAttribute("cars",cars);
        return "cars?count="+num;
    }
}
