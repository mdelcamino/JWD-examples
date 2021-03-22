package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.model.User;
import com.udacity.jdnd.c1.review.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private UserMapper usermaper;
    private HashService hashservice;

    public UserService(UserMapper usermaper, HashService hashservice) {
        this.usermaper = usermaper;
        this.hashservice = hashservice;
    }

    //usuario disponible

    public boolean isUserAvailable(String username){

        return usermaper.getUserName(username) ? true : false;
    }
    //crearusuario
    public int createUser(User user){
        //codificar la pass con el hashservice y la salt encoded
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt= Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashservice.getHashedValue(user.getPassword(), encodedSalt);
        return usermaper.insert(new User(user.getUsername(), hashedPassword,encodedSalt,null,user.getSurname(), user.getLastname()));

    }
    //devolver user

}
