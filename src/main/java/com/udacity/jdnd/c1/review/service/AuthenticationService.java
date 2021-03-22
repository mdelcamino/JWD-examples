package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.model.User;
import com.udacity.jdnd.c1.review.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@EnableWebSecurity
public class AuthenticationService implements AuthenticationProvider {
    private UserMapper userMapper;
    private HashService hashservice;

    public AuthenticationService(UserMapper userMapper, HashService hashservice) {
        this.userMapper = userMapper;
        this.hashservice = hashservice;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username= authentication.getName();
        System.out.println("username: " +username);
        String password= authentication.getCredentials().toString();
        System.out.println("password: " + password);
        User user= userMapper.getUser(username);
        System.out.println("user: " + user);
        if (user != null){
            System.out.println("user not null ");
            String encodedsalt = user.getSalt();
            String hashedpass = hashservice.getHashedValue(password, encodedsalt);
            if(user.getPassword().equals(hashedpass)){
                System.out.println("contraseñas salteadas iguales");
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());

                }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication){

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
