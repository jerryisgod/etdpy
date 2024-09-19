package com.etdpy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class LoginRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自增策略
    @Column(name = "id")
    private Long id;

    private String username;
    @Temporal(TemporalType.TIMESTAMP) // 指定精确到时间戳
    private Date loginTime;


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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginRecord{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
