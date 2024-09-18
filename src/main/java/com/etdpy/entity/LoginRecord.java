package com.etdpy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LoginRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自增策略
    @Column(name = "id")
    private Long id;

    private String username;
    private LocalDateTime loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginAttempt{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
