package com.example.SpringSecEx.Service;

import com.example.SpringSecEx.Model.UserPricipal;
import com.example.SpringSecEx.Model.Users;
import com.example.SpringSecEx.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService
{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPricipal(user);
    }
}
