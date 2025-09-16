package com.Job.Job.Application.Portal.service;

import com.Job.Job.Application.Portal.model.UserPrincipal;
import com.Job.Job.Application.Portal.model.Users;
import com.Job.Job.Application.Portal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Users users= userRepo.findByUsername(username);
        if(users == null)
        {
            throw new UsernameNotFoundException("404 Not FOund");
        }
        return new UserPrincipal(users);
    }
}
