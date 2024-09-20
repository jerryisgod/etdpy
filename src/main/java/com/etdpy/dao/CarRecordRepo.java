package com.etdpy.dao;

import com.etdpy.entity.CarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRecordRepo extends JpaRepository<CarRecord, Long> {
    // 可以根据需要添加自定义查询方法
}
