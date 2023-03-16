package com.example.quintor;

public class User {
    private String email;
    private String username;
    private int role;

    public User(String email, String username, int role) {
        setEmail(email);
        setUsername(username);
        setRole(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
