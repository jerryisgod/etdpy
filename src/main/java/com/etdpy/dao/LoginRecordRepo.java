package com.etdpy.dao;

import com.etdpy.entity.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRecordRepo extends JpaRepository<LoginRecord, Long> {

    List<LoginRecord> findByUsernameOrderByLoginTimeDesc(String username);
}
