package com.etdpy.controller;
import com.etdpy.entity.CarRecord;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.CustomerService;
import com.etdpy.service.LoginRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
public class workOrder {
    @Autowired
    CustomerService customerService;

    @GetMapping("/workOrder-search")
    public String workOrderSearch() {
        return "workOrder-search"; // 成功页面
    }

    @GetMapping("/searchLicensePlate")
    public String searchLicensePlate(@RequestParam("licensePlate") String licensePlate, Model model) {
        List<CarRecord> result = customerService.findByLicensePlate(licensePlate);

        if (result.isEmpty()) {
            model.addAttribute("errorMessage", "請先登錄客戶資訊");
            return "workOrder-search"; // 返回搜索页面
        }

        model.addAttribute("result", result);
        return "workOrder-showForm";
    }
}