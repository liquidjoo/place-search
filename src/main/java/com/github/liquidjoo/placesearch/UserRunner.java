package com.github.liquidjoo.placesearch;

import com.github.liquidjoo.placesearch.user.domain.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApplication implements CommandLineRunner {

    private UserService userService;

    public TestApplication(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(final String... args) throws Exception {
        userService.save();
    }
}
