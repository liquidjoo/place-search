package com.github.liquidjoo.placesearch.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("seongju", "tjdwn");
    }

    @Test
    @DisplayName("객체 비교")
    void equalsToUserByUserId() {
        User actualUser = user;
        User expectedUser = new User("seongju", "123");

        boolean same = actualUser.equals(expectedUser);

        assertThat(same).isTrue();
    }
}
