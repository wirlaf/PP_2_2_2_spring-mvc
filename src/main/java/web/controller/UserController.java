package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserServiceImpl;
import web.model.User;

import java.util.List;


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
        List<User> users = userService.show();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        model.addAttribute("user1", new User());
        model.addAttribute("user3",new User());
        return "/users";
    }

    @PostMapping(value = "/users/create")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }
    //update


    @PostMapping(value = "/users/update")
    public String update(@ModelAttribute("user1") User user) {
        userService.update(user, user.getId());
        return "redirect:/users";
    }

    //delete
    @PostMapping(value = "/users/delete")
    public String delete(@ModelAttribute("user3") User user) {
        userService.delete(user.getId());
        return "redirect:/users";
    }


}
