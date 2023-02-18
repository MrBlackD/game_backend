package com.example.demo.api;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User create(HttpServletRequest request, @RequestBody Map<String, String> body) {
        String userName = body.get("username");
        User user = this.userService.addUser(userName);
        request.getSession().setAttribute("id", user.getId());
        return user;
    }

    @PutMapping("/user")
    public User update(HttpServletRequest request, @RequestBody Map<String, String> body) {
        String userName = body.get("username");
        String id = request.getSession().getAttribute("id").toString();
        return this.userService.rename(id, userName);
    }

    @GetMapping("/user")
    public User getUserInfo(HttpServletRequest request) {
        String id = request.getSession().getAttribute("id").toString();
        return this.userService.getUser(id);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return this.userService.getUser(id);
    }
}
