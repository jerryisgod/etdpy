package com.etdpy.dao;

import com.etdpy.entity.MemberPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<MemberPo, Long> {
    // 自動生成查找用戶名的方法
    MemberPo findByUsername(String username);
}
