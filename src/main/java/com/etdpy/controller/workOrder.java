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
            Model model) {

        // 将接收到的数据添加到模型中
        model.addAttribute("selectedItems", selectedItems);
        model.addAttribute("input1", input1Values);
        model.addAttribute("input2", input2Values);
        model.addAttribute("input3", input3Values);
        model.addAttribute("input4", input4Values);
        model.addAttribute("result", resultValues);
        return "workOrder-FormPrint";
    }
}