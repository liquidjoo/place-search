package com.github.liquidjoo.placesearch.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordUtilsTest {

    private String actualSecurityPassword;

    @BeforeEach
    void setUp() {
        String rawPassword = "test123";
        actualSecurityPassword = PasswordUtils.generatePasswordBySecure(rawPassword);
    }

    @Test
    @DisplayName("패스워드 암호화")
    void encryptTest() {
        String expectedSecurityPassword = PasswordUtils.generatePasswordBySecure("test123");

        boolean same = actualSecurityPassword.equalsIgnoreCase(expectedSecurityPassword);

        assertThat(same).isTrue();
    }
}
