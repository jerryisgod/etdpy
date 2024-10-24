package com.etdpy.controller;
import com.etdpy.dao.CategoryRepo;
import com.etdpy.dao.ItemRepo;
import com.etdpy.entity.CarRecord;
import com.etdpy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

        @PostMapping("/submitForm")
        public String submitData(
                @RequestParam("selectedItems") List<String> selectedItems,
                @RequestParam("input1") List<Integer> input1Values,
                @RequestParam("input2") List<Integer> input2Values,
                @RequestParam("input3") List<Integer> input3Values,
                @RequestParam("input4") List<Integer> input4Values,
                @RequestParam("result") List<Integer> resultValues,
                @RequestParam(value = "companyTaxId", required = false) Integer companyTaxId,
                @RequestParam("total") Integer total,
                @RequestParam("discount") Integer discount,
                @RequestParam("finalTotal") Integer finalTotal,
                @RequestParam("ownerName") String ownerName,

                @RequestParam("orderNumber") String orderNumber,
                @RequestParam("date") String date,
                @RequestParam("mileage") String mileage,
                @RequestParam("brand") String brand,
                @RequestParam("model01") String model01,
                @RequestParam("year") String year,
                @RequestParam("licensePlate") String licensePlate,
                @RequestParam("engineCapacity") String engineCapacity,
                @RequestParam("VIN") String VIN,
                Model model) {
            List<CarRecord> phone = customerService.findByLicensePlate(licensePlate);
            // 将接收到的数据添加到模型中
            model.addAttribute("selectedItems", selectedItems);
            model.addAttribute("input1", input1Values);
            model.addAttribute("input2", input2Values);
            model.addAttribute("input3", input3Values);
            model.addAttribute("input4", input4Values);
            model.addAttribute("result", resultValues);
            model.addAttribute("companyTaxId", companyTaxId);
            model.addAttribute("total", total);
            model.addAttribute("discount", discount);
            model.addAttribute("finalTotal", finalTotal);
            model.addAttribute("ownerName", ownerName);
            model.addAttribute("orderNumber", orderNumber);
            model.addAttribute("date", date);
            model.addAttribute("mileage", mileage);
            model.addAttribute("brand", brand);
            model.addAttribute("model01", model01);
            model.addAttribute("year", year);
            model.addAttribute("licensePlate", licensePlate);
            model.addAttribute("engineCapacity", engineCapacity);
            model.addAttribute("VIN", VIN);
            model.addAttribute("phone", phone);

            return "workOrder-FormPrint";
        }
}


