package com.etdpy.service;
import com.etdpy.entity.Brand;
import com.etdpy.entity.CarRecord;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand findById(Long id);
    Brand saveBrand(Brand brand);
    void deleteBrand(Long id);
}
