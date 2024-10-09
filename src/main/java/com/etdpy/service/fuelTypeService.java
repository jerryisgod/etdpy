package com.etdpy.service;
import com.etdpy.entity.Brand;
import com.etdpy.entity.fuelType;

import java.util.List;

public interface fuelTypeService {
    List<fuelType> findAll();
    fuelType findById(Long id);
    fuelType saveFuelType(fuelType fueltype);
    void deleteFuelType(Long id);
}
