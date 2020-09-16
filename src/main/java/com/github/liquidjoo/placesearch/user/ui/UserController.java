package com.github.liquidjoo.placesearch.user.ui;

import com.github.liquidjoo.placesearch.user.application.UserRequest;
import com.github.liquidjoo.placesearch.user.application.UserResponse;
import com.github.liquidjoo.placesearch.user.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody UserRequest userRequest) {
        try {
            logger.info(userRequest.getUserId());
            logger.info(userRequest.getPassword());
            final UserResponse userResponse = userService.create(userRequest);
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserRequest userRequest) {
        try {
            logger.info(userRequest.getUserId());
            logger.info(userRequest.getPassword());
            final UserResponse userResponse = userService.login(userRequest);
            return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
