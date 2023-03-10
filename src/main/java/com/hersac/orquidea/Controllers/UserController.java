package com.hersac.orquidea.Controllers;

import java.io.IOException;
import java.util.List;

import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Services.UserService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4000/", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/data")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> userList() {
        return userService.userList();
    }

    @GetMapping("/user/{id}")
    public User userById(@PathVariable Long id) {
        return userService.userFindById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.userAdd(user);
    }

    @PostMapping("/validar")
    public User validate(@RequestBody User user, HttpServletResponse response) throws IOException {
        return userService.userValidation(user, response);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userInfo) {
        return userService.userUpdate(id, userInfo);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.userDelete(id);
    }

    @DeleteMapping("/deleteAllUser")
    public ResponseEntity<?> deleteAll() {
        return userService.deleteAll();
    }
}
