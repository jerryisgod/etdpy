package com.etdpy.controller;
import com.etdpy.dao.BrandRepo;
import com.etdpy.dao.CategoryRepo;
import com.etdpy.dao.ItemRepo;
import com.etdpy.dao.fuelTypeRepo;
import com.etdpy.entity.Brand;
import com.etdpy.entity.Category;
import com.etdpy.entity.Item;
import com.etdpy.entity.fuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class Backend {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private BrandRepo brandRepo;
	@Autowired
	private fuelTypeRepo fueltypeRepo;

	@Transactional
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Category> categories = categoryRepo.findAll();
		List<Item> items = itemRepo.findAll(); // 获取所有 Item
		model.addAttribute("categories", categories);
		model.addAttribute("items", items); // 将 items 添加到模型
		return "backEnd/dashboard";
	}
	@GetMapping("/brandList")
	public String showBrands(Model model) {
		List<Brand> brands = brandRepo.findAll();
		System.out.println("Brands: " + brands);  // Debug line
		model.addAttribute("brands", brands);
		return "backEnd/brandList";

	}
	@GetMapping("/fuelTypesList")
	public String showFuelTypes(Model model) {
		model.addAttribute("fuelTypes", fueltypeRepo.findAll());
		return "backEnd/fuelTypesList";
	}

	// 保存类别
	@PostMapping("/category/save")
	public String saveCategory(Category category, RedirectAttributes redirectAttributes) {
		if (categoryRepo.existsByName(category.getName())) {
			redirectAttributes.addFlashAttribute("errorMessage", "類別已存在");
			return "redirect:/dashboard";
		}
		categoryRepo.save(category);
		redirectAttributes.addFlashAttribute("okMessage", "類別已新增");
		return "redirect:/dashboard";
	}

	@PostMapping("/item/save")
	public String saveItem(@RequestParam String itemName, @RequestParam Long categoryId, RedirectAttributes redirectAttributes) {
		if (itemRepo.existsByName(itemName)) {
			redirectAttributes.addFlashAttribute("errorMessage", "項目已存在");
			return "redirect:/dashboard";
		}

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));

		Item item = new Item();
		item.setName(itemName);
		item.setCategory(category);

		itemRepo.save(item);
		redirectAttributes.addFlashAttribute("okMessage", "項目已新增");
		return "redirect:/dashboard";
	}



	// 保存廠牌
	@PostMapping("/brand/save")
	public String saveBrand(Brand brand) {
		brandRepo.save(brand);
		return "redirect:/brandList";
	}
	// 保存燃料
	@PostMapping("/fuelType/save")
	public String saveFuelType(fuelType fueltype) {
		fueltypeRepo.save(fueltype);
		return "redirect:/fuelTypesList";
	}
	// 删除类别
	@PostMapping("/category/delete")
	public String deleteCategory(@RequestParam Long id) {
		categoryRepo.deleteById(id);
		return "redirect:/dashboard";
	}


	// 删除项目
	@PostMapping("/item/delete")
	public String deleteItem(@RequestParam Long id) {
		itemRepo.deleteById(id);
		return "redirect:/dashboard";
	}

	// 删除厂牌
	@PostMapping("/brand/delete")
	public String deleteBrand(@RequestParam Long id) {
		brandRepo.deleteById(id);
		return "redirect:/brandList";
	}

	// 删除燃料
	@PostMapping("/fuelType/delete")
	public String deleteFuelType(@RequestParam Long id) {
		fueltypeRepo.deleteById(id);
		return "redirect:/fuelTypesList";
	}

}

