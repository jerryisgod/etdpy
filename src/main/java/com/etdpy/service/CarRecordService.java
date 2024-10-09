package com.etdpy.service;
import com.etdpy.entity.Brand;
import com.etdpy.entity.CarRecord;

import javax.smartcardio.Card;
import java.util.List;

public interface CarRecordService {
    CarRecord findById(Long id);

    List<CarRecord> getAllCarRecords();

    CarRecord getCarRecordById(Long id);

    CarRecord saveCarRecord(CarRecord carRecord);

    void deleteCarRecord(Long id);
}
