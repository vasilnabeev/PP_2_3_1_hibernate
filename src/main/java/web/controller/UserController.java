package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;

@Controller
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        ArrayList<User> resultList = (ArrayList<User>) userService.getAllUsers();
        model.addAttribute("users", resultList);
        return "users";
    }

    @GetMapping(value ="/user")
    public String userById(@RequestParam(name = "id", required = false) Long id, ModelMap model) {
        if (id == null) {
            id = 1L;
        }
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit")
    public String editUser(@RequestParam(name = "id", required = false) Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(name = "id", required = false) Long id, ModelMap model) {
        userService.updateUser(user);

        return "redirect:/users";
    }

    @PostMapping(value = "/users/delete")
    public String deleteUser(@RequestParam(name = "id", required = false) Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
