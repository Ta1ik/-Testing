package com.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class UserTest {

    private final static String LOGIN = "User";
    private final static String LOGIN2 = "Test User";
    private final static String EMAIL = "email@gmail.com";
    private final static String EMAIL2 = "email@mail.ru";
    private final static String INCORRECT_EMAIL = "mail@gmail";
    private final static String MATCHER_MAIL = ("(\\w+)@(\\w+)\\.(com|ru)");
    private static User userTest;

    @BeforeEach
    void createUser(){
        userTest = new User(LOGIN, EMAIL);
    }

    @Test
    void shouldCorrectUserLogin() {
        Assertions.assertEquals(LOGIN, userTest.getLogin());
    }

    @Test
    void shouldCorrectSetLogin() {
        userTest.setLogin(LOGIN2);
        Assertions.assertEquals(LOGIN2, userTest.getLogin());
    }

    @Test
    void shouldCorrectUserEmail() {
        Assertions.assertEquals(EMAIL, userTest.getEmail());
    }

    @Test
    void shouldCorrectSetEmail() {
        userTest.setEmail(EMAIL2);
        Assertions.assertEquals(EMAIL2, userTest.getEmail());
    }

    @Test
    void shouldVerifyEmail(){
        Assertions.assertTrue(Pattern.matches(MATCHER_MAIL, userTest.getEmail()));
    }

    @Test
    void shouldNotVerifyIncorrectEmail(){
        userTest.setEmail(INCORRECT_EMAIL);
        Assertions.assertFalse(Pattern.matches(MATCHER_MAIL, userTest.getEmail()));
    }
}