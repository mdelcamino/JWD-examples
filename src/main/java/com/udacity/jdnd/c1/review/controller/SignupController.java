package com.udacity.jdnd.c1.review.controller;

import com.udacity.jdnd.c1.review.model.User;
import com.udacity.jdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private UserService userservice;

    public SignupController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping()
    public String signupView() {
        return "signup";
    }

    @PostMapping()
    public String signupuser(@ModelAttribute User user, Model model) {
        String signupError = null;

        if (!userservice.isUserAvailable(user.getUsername())) {
            signupError = "The user already exists";
        }
        if (signupError == null) {

            userservice.createUser(user);
        }

        return "signup";

    }
}