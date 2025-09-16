package com.Job.Job.Application.Portal.controller;

import com.Job.Job.Application.Portal.model.Users;
import com.Job.Job.Application.Portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
   private UserService userService;

    @PostMapping("register")
    public Users addUser(@RequestBody Users users)
    {
        return userService.addUser(users);
    }
    @GetMapping("users")
    public List<Users> getUsers()
    {
        return userService.getUsers();
    }
}
