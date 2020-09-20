package com.github.liquidjoo.placesearch.user.application;

import com.github.liquidjoo.placesearch.user.domain.User;
import com.github.liquidjoo.placesearch.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse create(UserRequest userRequest) {
        final User user = userRepository.save(new User(userRequest.getUserId(), userRequest.getPassword()));
        return new UserResponse(user.getUserId());
    }

    public UserResponse login(UserRequest userRequest) {

        final User user = userRepository.findByUserId(userRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("not found user info"));

        if (user.match(userRequest.getPassword())) {
            return new UserResponse(user.getUserId());
        }

        throw new IllegalArgumentException("not found user info");
    }
}
