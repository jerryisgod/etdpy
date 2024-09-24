package com.etdpy.controller;

import com.etdpy.dao.CarRecordRepo;
import com.etdpy.entity.CarRecord;
import com.etdpy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class car {

    @Autowired
    private CarRecordRepo carRecordRepo;

    public car(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/car-records/car")
    public String showCarRecordForm(Model model) {
        model.addAttribute("carRecord", new CarRecord());
        return "car"; // Thymeleaf 页面名
    }

    @PostMapping("/car/record/save")
    public String saveCarRecord(@ModelAttribute CarRecord carRecord) {
        carRecordRepo.save(carRecord); // 保存到数据库
        return "redirect:/car/record/success"; // 成功后重定向到成功页面
    }

    @GetMapping("/car/record/success")
    public String showSuccessPage() {
        return "saveSuccess"; // 成功页面
    }
    private final CustomerService customerService;
    @GetMapping("/customerList")
    public String getCustomerList(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size) {
        Page<CarRecord> carRecordsPage = customerService.getPaginatedCustomerList(page, size);

        model.addAttribute("carRecords", carRecordsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carRecordsPage.getTotalPages());

        return "customerList"; //
    }

    @GetMapping("/search")
    public String searchList() {
        return "search"; // 成功页面
    }

    @GetMapping("/orderHistorySearch")
    public String searchOrderHistories(@RequestParam("searchKeyword") String searchKeyword,
                                       @RequestParam(defaultValue = "0") int page,
                                       Model model) {
        int size = 5; // 每页显示10条记录
        Page<CarRecord> carRecordsPage = customerService.searchCustomer(searchKeyword, page, size);
        model.addAttribute("carRecords", carRecordsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carRecordsPage.getTotalPages());
        model.addAttribute("searchKeyword", searchKeyword);
        return "search"; // 返回显示订单历史的页面
    }


}

