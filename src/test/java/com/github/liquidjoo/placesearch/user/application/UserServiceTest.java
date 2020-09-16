package com.github.liquidjoo.placesearch.user.application;

import com.github.liquidjoo.placesearch.user.domain.User;
import com.github.liquidjoo.placesearch.user.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("seongju", "test111");
    }

    @Test
    void name() {
        given(userRepository.save(new User("seongju", "test111")))
                .willReturn(user);

        final UserResponse response = userService.create(new UserRequest("seongju", "test111"));

        String actualUserId = response.getUserId();
        String expectedUserId = "seongju";

        boolean same = actualUserId.equals(expectedUserId);

        assertThat(same).isTrue();
    }
}
