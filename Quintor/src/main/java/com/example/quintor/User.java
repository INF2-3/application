package com.example.quintor;

public class User {
    private int id;
    private int role;
    private String email;
    private String username;
    private String hashedPassword;

    public User(int id, int role, String email, String username, String hashedPassword) {
        setId(id);
        setRole(role);
        setEmail(email);
        setUsername(username);
        setHashedPassword(hashedPassword);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
