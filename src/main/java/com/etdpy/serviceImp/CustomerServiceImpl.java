package com.etdpy.serviceImp;

import com.etdpy.dao.CustomerRepo;
import com.etdpy.entity.CarRecord;
import com.etdpy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Page<CarRecord> getPaginatedCustomerList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // 创建分页请求
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<CarRecord> searchCustomer(String licensePlate, String ownerName, String companyName, Pageable pageable) {
        return customerRepo.searchByConditions(licensePlate, ownerName, companyName, pageable);
    }

    @Override
    public List<CarRecord> findByLicensePlate(String licensePlate) {
        return customerRepo.findByLicensePlate(licensePlate);
    }


}
