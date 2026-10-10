package com.skh.controller;

import com.skh.models.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/signup")
    public String showSignUpForm(UserVO userVO) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("userVO") UserVO userVO, Model model) {
        System.out.println("User submitted: " + userVO);

        // Add a flag to trigger the alert
        model.addAttribute("success", true);
        model.addAttribute("userVO", new UserVO()); // reset form

        return "add-user";
    }

}