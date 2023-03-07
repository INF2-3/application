package com.example.quintor;

public class User {
    private int id;
    private int role;
    private String email;
    private String username;
    private String hashedPassword;

    public User(int role, String email, String hashedPassword) throws IllegalArgumentException {
        if (!setRole(role) && !setEmail(email) && !setHashedPassword(hashedPassword)) {
            throw new IllegalArgumentException("Geen geldige dingen");
        }
    }

    public int getId() {
        return this.id;
    }

    public int getRole() {
        return this.role;
    }

    public boolean setRole(int role) {
        if (role < 0) {
            return false;
        }
        this.role = role;
        return true;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean setEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        this.email = email;
        return true;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean setUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        this.username = username;
        return true;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public boolean setHashedPassword(String hashedPassword) {
        if (hashedPassword == null || hashedPassword.isEmpty()) {
            return false;
        }
        this.hashedPassword = hashedPassword;
        return true;
    }
}
