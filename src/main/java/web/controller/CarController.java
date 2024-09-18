package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    @Autowired
    CarServiceImpl carService;

    @GetMapping("/car")
    public String printCars(ModelMap model, @RequestParam(required = false) Integer count) {
        if (count != null && count > 1 && count < 5) {
            model.addAttribute("cars", carService.getCars(count));
        } else {
            model.addAttribute("cars", carService.getCars());
        }
        return "car";
    }
}
