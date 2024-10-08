package com.etdpy.controller;

import com.etdpy.dao.CarRecordRepo;
import com.etdpy.entity.CarRecord;
import com.etdpy.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;


@Controller
public class car {

    @Autowired
    private CarRecordRepo carRecordRepo;

    public car(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/addCustomer")
    public String showCarRecordForm(Model model) {
        model.addAttribute("carRecord", new CarRecord());
        return "addCustomer"; //
    }

    @PostMapping("/SaveCustomer")
    public String saveCarRecord(@Valid @ModelAttribute CarRecord carRecord, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addCustomer";
        }
        carRecordRepo.save(carRecord);
        return "redirect:/SaveCustomerSuccess";
    }

    @GetMapping("/SaveCustomerSuccess")
    public String showSuccessPage() {
        return "saveSuccess"; // 成功页面
    }
    private final CustomerService customerService;
    @GetMapping("/customerList")
    public String getCustomerList(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
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
    public String searchCarRecords(
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) String ownerName,
            @RequestParam(required = false) String companyName,
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        Page<CarRecord> carRecords = customerService.searchCustomer(licensePlate, ownerName, companyName, pageable);
        model.addAttribute("carRecords", carRecords);
        model.addAttribute("licensePlate", licensePlate);
        model.addAttribute("ownerName", ownerName);
        model.addAttribute("companyName", companyName);

        // 判断是否有搜索结果
        if (carRecords.isEmpty()) {
            model.addAttribute("message", "查無資料"); // 添加消息
        }

        return "searchResults"; // 返回显示订单历史的页面

            }
}

