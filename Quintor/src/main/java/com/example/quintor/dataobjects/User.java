package com.example.quintor.dataobjects;

public class User {
    private int id;
    private int role;
    private String email;
    private String username;
    private String hashedPassword;

    public User(String email, String username, int role) {
        setEmail(email);
        setUsername(username);
        setRole(role);
    }

    public User(int role, String email, String hashedPassword) throws IllegalArgumentException {
        if (!setRole(role) && !setEmail(email) && !setHashedPassword(hashedPassword)) {
            throw new IllegalArgumentException("Geen geldige gegevens");
        }
    }

    public int getId() {
        return this.id;
    }

    public boolean setId(int id) {
        if (id < 0) {
            return false;
        }
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        this.email = email;
        return true;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        this.username = username;
        return true;
    }

    public int getRole() {
        return role;
    }

    public boolean setRole(int role) {
        if (role < 0) {
            return false;
        }
        this.role = role;
        return true;
    }
}
