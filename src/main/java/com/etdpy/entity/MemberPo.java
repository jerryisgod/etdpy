package com.etdpy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "sh_members") // 映射到 MySQL 中的 "members" 表
public class MemberPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自增策略
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true) // 設定列名、不可為空和唯一性
    private String username;

    @Column(name = "password", nullable = false) // 設定列名和不可為空
    private String password;

    @Column(name = "email", nullable = false, unique = true) // 設定列名、不可為空和唯一性
    private String email;

    @Column(name = "authority") // 設定列名
    private String authority; // 例如 "ROLE_USER,ROLE_ADMIN"

    // Getters and Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
