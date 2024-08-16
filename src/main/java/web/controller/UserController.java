package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserServiceImpl;
import web.model.User;


@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    //show
    @GetMapping(value = "/users")
    public String show(ModelMap model) {
        model.addAttribute("users", userService.show());
        return "/users";
    }

    @GetMapping(value = "/users/one")
    public String showOne(ModelMap model, @RequestParam(name = "id") Integer id){
        model.addAttribute("user",userService.showOne(id));
        return "/showOne";
    }

    //CREATE
    @GetMapping("/users/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping(value = "/users/create")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }
    //update

    @GetMapping(value = "/users/edit")
    public String edit(Model model,@RequestParam(name = "id") Integer id) {
        model.addAttribute("user",userService.showOne(id));
        return "/edit";
    }
    @PostMapping(value = "/users/update")
    public String update(@ModelAttribute("user") User user,@RequestParam(name = "id") Integer id) {
        userService.update(user,id);
        return "redirect:/users";
    }

    //delete
//    @PostMapping
//    public String delete(@RequestParam(name = "id") Integer id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }


}
