package com.example.mytelegrambot.models;

import javax.persistence.*;

@Entity
public class TgUser {
    @Id
    private Long id;

    private String fullName;


    @Enumerated(EnumType.STRING)
    private Role role;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
