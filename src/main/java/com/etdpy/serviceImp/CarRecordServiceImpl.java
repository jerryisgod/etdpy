package com.etdpy.serviceImp;

import com.etdpy.dao.CarRecordRepo;
import com.etdpy.entity.Brand;
import com.etdpy.entity.CarRecord;
import com.etdpy.service.CarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarRecordServiceImpl implements CarRecordService {

    @Autowired
    private CarRecordRepo carRecordRepo;

    @Override
    public CarRecord findById(Long id) {
        Optional<CarRecord> result = carRecordRepo.findById(id);
        return result.orElse(null); // 如果找不到返回 null，也可以抛出异常
    }

    @Override
    public List<CarRecord> getAllCarRecords() {
        return carRecordRepo.findAll();
    }

    @Override
    public CarRecord getCarRecordById(Long id) {
        return carRecordRepo.findById(id).orElse(null);
    }

    @Override
    public CarRecord saveCarRecord(CarRecord carRecord) {
        return carRecordRepo.save(carRecord);
    }

    @Override
    public void deleteCarRecord(Long id) {
        carRecordRepo.deleteById(id);
    }
}
