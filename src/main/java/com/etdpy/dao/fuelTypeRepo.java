package com.etdpy.dao;

import com.etdpy.entity.fuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fuelTypeRepo extends JpaRepository<fuelType, Long> {
    // 可以根据需要添加自定义查询方法
}
