package com.etdpy.dao;

import com.etdpy.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
    // 可以根据需要添加自定义查询方法
}
