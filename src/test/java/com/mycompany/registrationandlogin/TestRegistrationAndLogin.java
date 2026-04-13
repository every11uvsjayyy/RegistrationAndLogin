package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void testValidUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("abc_"),
            "Username with underscore and <= 5 chars should be valid");
    }

    @Test
    void testInvalidUserName() {
        Login login = new Login();
        assertFalse(login.checkUserName("abcdef"),
            "Username longer than 5 chars should be invalid");
    }

    @Test
    void testValidPassword() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Passw0rd!"),
            "Password with uppercase, number, special char, and >= 8 chars should be valid");
    }

    @Test
    void testInvalidPassword_NoSpecialChar() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("Password1"),
            "Password missing special character should be invalid");
    }

    @Test
    void testValidCellPhone() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27831234567"),
            "Valid SA number with +27 prefix should be accepted");
    }

    @Test
    void testInvalidCellPhone() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("0831234567"),
            "Cellphone missing +27 prefix should be invalid");
    }

    @Test
    void testRegisterUserSuccess() {
        Login login = new Login();
        String result = login.registerUser("abc_", "Passw0rd!", "+27831234567");
        assertTrue(result.contains("successfully"),
            "Registration should succeed with valid inputs");
    }

    @Test
    void