package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.config.UserDao.UserDao;
import web.User.User;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private final UserDao userDao;

	public HelloController(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<User> userList = userDao.index();

		if(userList.isEmpty()) {
			model.addAttribute("emptyList", true);
		} else {
			model.addAttribute("userList", userList);
		}
		model.addAttribute("user", new User());
		return "index";
	}
	@GetMapping(value = "/addUser")
	public String addUser(Model model){
		model.addAttribute("user", new User());
		return "addUser";
	}
	@PostMapping(value = "/addUser")
	public String addUserSubmit(User user, Model model) {
		userDao.addUser(user);
		model.addAttribute("message", "Пользователь успешно добавлен");
		return "redirect:/";
}
}