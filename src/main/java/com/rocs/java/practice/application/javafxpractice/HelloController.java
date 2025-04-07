package com.rocs.java.practice.application.javafxpractice;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    // Simulated user database
    private final Map<String, String> validUsers = new HashMap<>();

    public HelloController() {
        // Add valid usernames and passwords
        validUsers.put("admin", "admin123");
        validUsers.put("user1", "pass1");
        validUsers.put("john", "doe123");
    }

    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            statusLabel.setText("Login successful! Welcome, " + username + "!");
            statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else {
            statusLabel.setText("Invalid username or password.");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }

    @FXML
    protected void handleClear() {
        usernameField.clear();
        passwordField.clear();
        statusLabel.setText("");
        statusLabel.setStyle("");
    }
}