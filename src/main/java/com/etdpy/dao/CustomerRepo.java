package com.etdpy.dao;

import com.etdpy.entity.CarRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CarRecord, Long> {
    //撈全部客戶資料
    Page<CarRecord> findAll(Pageable pageable);

    //根據車牌號碼或車主名稱或公司名稱進行模糊查詢
    Page<CarRecord> findByLicensePlateOrOwnerNameOrCompanyName(String licensePlate, String ownerName,String companyName, Pageable pageable);
}
