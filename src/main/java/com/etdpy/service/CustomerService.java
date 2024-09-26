package com.etdpy.service;

import com.etdpy.entity.CarRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {


    Page<CarRecord> getPaginatedCustomerList(int page, int size);

    Page<CarRecord> searchCustomer(String licensePlate, String ownerName, String companyName, Pageable pageable);

}
