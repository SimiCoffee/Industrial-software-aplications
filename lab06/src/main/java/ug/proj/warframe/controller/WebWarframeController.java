package ug.proj.warframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.exception.ItemNotFoundException;
import ug.proj.warframe.service.ItemManager;

@Controller
@RequestMapping("/warframe")
public class WebWarframeController {

	private final ItemManager itemManager;

	public WebWarframeController(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	@GetMapping
	public String getAllWarframes(Model model) {
		model.addAttribute("warframes", itemManager.getAllItems());
		return "warframe-list"; // Thymeleaf template: warframe-list.html
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("warframe", new WarframeItem());
		return "warframe-add"; // Thymeleaf template: warframe-add.html
	}

	@PostMapping("/add")
	public String addWarframe(@Valid @ModelAttribute("warframe") WarframeItem warframe,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "warframe-add";
		}
		itemManager.addItem(warframe);
		return "redirect:/warframe";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable String id, Model model) {
		WarframeItem warframe = itemManager.findById(id)
				.orElseThrow(ItemNotFoundException::new);
		model.addAttribute("warframe", warframe);
		return "warframe-edit"; // Thymeleaf template: warframe-edit.html
	}

	@PostMapping("/edit/{id}")
	public String editWarframe(@PathVariable String id,
			@Valid @ModelAttribute("warframe") WarframeItem warframe,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "warframe-edit";
		}
		if (!itemManager.updateItem(id, warframe)) {
			throw new ItemNotFoundException();
		}
		return "redirect:/warframe";
	}

	@GetMapping("/delete/{id}")
	public String deleteWarframe(@PathVariable String id) {
		if (!itemManager.deleteItem(id)) {
			throw new ItemNotFoundException();
		}
		return "redirect:/warframe";
	}
}
