package com.etdpy.controller;

import com.etdpy.dao.BrandRepo;
import com.etdpy.dao.CarRecordRepo;
import com.etdpy.dao.fuelTypeRepo;
import com.etdpy.entity.Brand;
import com.etdpy.entity.CarRecord;
import com.etdpy.entity.fuelType;
import com.etdpy.service.BrandService;
import com.etdpy.service.CarRecordService;
import com.etdpy.service.CustomerService;
import com.etdpy.service.fuelTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;


@Controller
public class car {

    @Autowired
    private CarRecordRepo carRecordRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private fuelTypeRepo fueltypeRepo;
    @Autowired
    private CarRecordService carrecordService;


    public car(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/addCustomer")
    public String showCarRecordForm(Model model) {
        model.addAttribute("carRecord", new CarRecord());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("fuelTypes", fueltypeRepo.findAll());
        return "addCustomer"; //
    }

    @PostMapping("/SaveCustomer")
    public String saveCarRecord(@Valid @ModelAttribute CarRecord carRecord, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", brandRepo.findAll());
            model.addAttribute("fuelTypes", fueltypeRepo.findAll());
            return "addCustomer";
        }
        carRecordRepo.save(carRecord);
        return "redirect:/SaveCustomerSuccess";
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

    @PostMapping("/detailsCustomer")
    public String getBrandById(@RequestParam("id") Long id, Model model) {
        CarRecord carRecord = carrecordService.findById(id);
        model.addAttribute("carRecord", carRecord);
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("fuelTypes", fueltypeRepo.findAll());
        return "detailsCustomer";
    }
    @PostMapping("/SaveCustomer1")
    public String saveCarRecord1(
            @Valid @ModelAttribute CarRecord carRecord,
            BindingResult bindingResult,
            Model model,
            @RequestParam("action") String action) {

        // 处理表单验证错误
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", brandRepo.findAll());
            model.addAttribute("fuelTypes", fueltypeRepo.findAll());
            return "detailsCustomer"; // 返回表单页面，显示错误信息
        }

        // 根据不同的操作进行处理
        return switch (action) {
            case "modify" -> {
                carRecordRepo.save(carRecord); // 保存修改
                yield "redirect:/saveSuccess1"; // 保存修改
            }
            case "repair" -> {
                model.addAttribute("carRecord", carRecord); // 将 carRecord 添加到模型中以供查询
                // 可以添加逻辑来查询维修记录
                yield "maintenance"; // 将 carRecord 添加到模型中以供查询
                // 可以添加逻辑来查询维修记录
            }
            case "delete" -> {
                carRecordRepo.delete(carRecord); // 删除记录
                yield "redirect:/saveSuccess2"; // 删除记录
            }
            default -> "redirect:/maintenance"; // 未知操作时重定向到错误页面
        };
    }

}

