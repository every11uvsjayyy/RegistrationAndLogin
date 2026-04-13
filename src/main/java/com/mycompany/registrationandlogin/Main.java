/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;




import java.util.Scanner;

class Login {

    private String username;
    private String password;
    private String cellphone;

    // Check username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }

    // Check SA cellphone number
    public boolean checkCellPhoneNumber(String cellphone) {
        if (!cellphone.startsWith("+27")) {
            return false;
        }

        String numbersOnly = cellphone.substring(3);
        return numbersOnly.length() <= 10 && numbersOnly.matches("\\d+");
    }

    // Register user
    public String registerUser(String username, String password, String cellphone) { 

        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please make sure it includes an underscore and is no more than five characters long.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please ensure it meets all the required complexity rules.";
        }

        if (!checkCellPhoneNumber(cellphone)) {
            return "Cellphone number is incorrectly formatted or missing the international code.";
        }

        this.username = username;
        this.password = password;
        this.cellphone = cellphone;

        return "Username successfully captured.\nPassword successfully captured.\nCellphone number successfully added.";
    }

    // Login check
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Return login message
    public String returnLoginStatus(boolean loginSuccess, String username) {
        if (loginSuccess) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password is incorrect, please try again.";
        }
    }
}


// Main class to run everything
public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            Login user = new Login();
            
            // Registration
            System.out.println("=== Register ===");
            System.out.print("Enter username: ");
            String username = input.nextLine();
            
            System.out.print("Enter password: ");
            String password = input.nextLine();
            
            System.out.print("Enter cellphone (+27...): ");
            String cellphone = input.nextLine();
            
            String registerMessage = user.registerUser(username, password, cellphone);
            System.out.println(registerMessage);
            
            // Login
            System.out.println("\n=== Login ===");
            System.out.print("Enter username: ");
            String loginUser = input.nextLine();
            
            System.out.print("Enter password: ");
            String loginPass = input.nextLine();
            
            boolean loginStatus = user.loginUser(loginUser, loginPass);
            System.out.println(user.returnLoginStatus(loginStatus, loginUser));
        }
    }
}