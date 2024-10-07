package com.etdpy.dao;

import com.etdpy.entity.CarRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CarRecord, Long> {
    //撈全部客戶資料
    Page<CarRecord> findAll(Pageable pageable);

    //根據車牌號碼或車主名稱或公司名稱進行模糊查詢
    Page<CarRecord> findByLicensePlateContainingIgnoreCaseOrOwnerNameContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(String licensePlate, String ownerName,String companyName, Pageable pageable);


    @Query("SELECT c FROM CarRecord c WHERE " +
            "(COALESCE(:licensePlate, '') = '' OR LOWER(c.licensePlate) LIKE LOWER(CONCAT('%', :licensePlate, '%'))) " +
            "AND (COALESCE(:ownerName, '') = '' OR LOWER(c.ownerName) LIKE LOWER(CONCAT('%', :ownerName, '%'))) " +
            "AND (COALESCE(:companyName, '') = '' OR LOWER(c.companyName) LIKE LOWER(CONCAT('%', :companyName, '%')))")
    Page<CarRecord> searchByConditions(
            @Param("licensePlate") String licensePlate,
            @Param("ownerName") String ownerName,
            @Param("companyName") String companyName,
            Pageable pageable);

}
