package com.github.liquidjoo.placesearch;

import com.github.liquidjoo.placesearch.user.application.UserRequest;
import com.github.liquidjoo.placesearch.user.application.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserApplicationRunner implements ApplicationRunner {

    private UserService userService;

    public UserApplicationRunner(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("initialize user info");
        userService.create(new UserRequest("tjdwn", "1234"));
    }
}
