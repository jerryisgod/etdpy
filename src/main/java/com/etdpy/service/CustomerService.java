package com.etdpy.service;

import com.etdpy.entity.CarRecord;
import org.springframework.data.domain.Page;

public interface CustomerService {


    Page<CarRecord> getPaginatedCustomerList(int page, int size);

    Page<CarRecord> searchOrderHistories(String keyword, int page, int size);


}
