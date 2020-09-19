package com.github.liquidjoo.placesearch.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        return "user/login.html";
    }
}
