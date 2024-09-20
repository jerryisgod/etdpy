package com.etdpy.controller;
import com.etdpy.entity.CarRecord;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.CarRecordService;
import com.etdpy.service.LoginRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/car-records")
public class car {
    @Autowired
    private CarRecordService carRecordService;

    private static final Logger logger
            = LoggerFactory.getLogger(login.class);
    @GetMapping("/car")
    public String carForm() {
        return "car";
    }

    @PostMapping("/save")
    public CarRecord createCarRecord(@ModelAttribute CarRecord carRecord) {
        return carRecordService.saveCarRecord(carRecord);
    }



}


