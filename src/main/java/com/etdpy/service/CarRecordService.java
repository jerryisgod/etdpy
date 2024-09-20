package com.etdpy.service;
import com.etdpy.entity.CarRecord;

import java.util.List;

public interface CarRecordService {

    List<CarRecord> getAllCarRecords();

    CarRecord getCarRecordById(Long id);

    CarRecord saveCarRecord(CarRecord carRecord);

    void deleteCarRecord(Long id);
}
