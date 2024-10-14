package com.etdpy.controller;
import com.etdpy.dao.CategoryRepo;
import com.etdpy.dao.ItemRepo;
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
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ItemRepo itemRepo;

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
        model.addAttribute("categories", categoryRepo.findAll());  // 加载类别列表
        model.addAttribute("items", itemRepo.findAll());            // 加载项目列表
        return "workOrder-showForm";
    }
}