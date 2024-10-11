package com.etdpy.dao;

import com.etdpy.entity.CarRecord;
import com.etdpy.entity.LoginRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CarRecord, Long> {
    Page<CarRecord> findAll(Pageable pageable);

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

    // 完全匹配查询
    List<CarRecord> findByLicensePlate(String licensePlate);

}
