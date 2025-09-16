package com.Job.Job.Application.Portal.service;

import com.Job.Job.Application.Portal.model.Users;
import com.Job.Job.Application.Portal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService
{
    @Autowired
    private UserRepo userRepo;

    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    public Users addUser(Users users)
    {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepo.save(users);
    }

    public List<Users> getUsers()
    {
        return userRepo.findAll();
    }


}
