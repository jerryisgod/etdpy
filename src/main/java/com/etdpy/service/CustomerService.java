package com.etdpy.service;

import com.etdpy.entity.CarRecord;
import com.etdpy.entity.LoginRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {


    Page<CarRecord> getPaginatedCustomerList(int page, int size);

    Page<CarRecord> searchCustomer(String licensePlate, String ownerName, String companyName, Pageable pageable);

    List<CarRecord> findByLicensePlate(String licensePlate);
}
