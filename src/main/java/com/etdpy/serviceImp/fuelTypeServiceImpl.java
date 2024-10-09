package com.etdpy.serviceImp;

import com.etdpy.dao.fuelTypeRepo;
import com.etdpy.entity.fuelType;
import com.etdpy.service.fuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class fuelTypeServiceImpl implements fuelTypeService {

    @Autowired
    private fuelTypeRepo fuelTypeRepository;

    @Override
    public List<fuelType> findAll() {
        return fuelTypeRepository.findAll();
    }

    @Override
    public fuelType findById(Long id) {
        Optional<fuelType> result = fuelTypeRepository.findById(id);
        return result.orElse(null); // 如果找不到返回 null，也可以抛出异常
    }

    @Override
    public fuelType saveFuelType(fuelType fueltype) {
        return fuelTypeRepository.save(fueltype);
    }

    public void deleteFuelType(Long id) {
        fuelTypeRepository.deleteById(id);
    }
}
