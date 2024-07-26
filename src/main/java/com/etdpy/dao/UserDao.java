package com.etdpy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etdpy.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
