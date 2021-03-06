package com.github.liquidjoo.placesearch.user.ui;

import com.github.liquidjoo.placesearch.user.application.UserRequest;
import com.github.liquidjoo.placesearch.user.application.UserResponse;
import com.github.liquidjoo.placesearch.user.application.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody UserRequest userRequest) {
        try {
            final UserResponse userResponse = userService.create(userRequest);
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserRequest userRequest, HttpServletRequest httpServletRequest) {
        try {
            final UserResponse userResponse = userService.login(userRequest);
            createSession(httpServletRequest.getSession(true), userResponse);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    private void createSession(HttpSession httpSession, UserResponse userResponse) {
        httpSession.setAttribute("user", userResponse.getUserId());
        httpSession.setMaxInactiveInterval(60 * 30);
    }

}
