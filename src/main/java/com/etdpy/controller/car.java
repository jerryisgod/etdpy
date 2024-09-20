package com.etdpy.controller;

import com.etdpy.dao.CarRecordRepo;
import com.etdpy.entity.CarRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class car {

    @Autowired
    private CarRecordRepo carRecordRepo;

    @GetMapping("/car-records/car")
    public String showCarRecordForm(Model model) {
        model.addAttribute("carRecord", new CarRecord());
        return "car"; // Thymeleaf 页面名
    }

    @PostMapping("/car/record/save")
    public String saveCarRecord(@ModelAttribute CarRecord carRecord) {
        carRecordRepo.save(carRecord); // 保存到数据库
        return "redirect:/car-records/car"; // 成功后重定向到成功页面
    }

    @GetMapping("/car/record/success")
    public String showSuccessPage() {
        return "success"; // 成功页面
    }
}
