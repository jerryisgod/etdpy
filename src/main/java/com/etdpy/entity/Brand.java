package com.etdpy.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "sh_Brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自增策略
    private Long id;
    private String username;

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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
