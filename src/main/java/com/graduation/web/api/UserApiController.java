package com.graduation.web.api;

import com.graduation.data.entity.User;
import com.graduation.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
}
