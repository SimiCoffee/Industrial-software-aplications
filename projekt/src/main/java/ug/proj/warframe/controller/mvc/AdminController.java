package ug.proj.warframe.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.service.PlayerService;
import ug.proj.warframe.service.WarframeItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final WarframeItemService warframeItemService;
	private final PlayerService playerService;

	public AdminController(WarframeItemService warframeItemService, PlayerService playerService) {
		this.warframeItemService = warframeItemService;
		this.playerService = playerService;
	}

	@GetMapping
	public String adminPanel() {
		return "admin/index";
	}

	@GetMapping("/warframes")
	public String listWarframes(Model model) {
		model.addAttribute("warframes", warframeItemService.getAllItems());
		return "admin/warframes";
	}

	@GetMapping("/warframes/new")
	public String showAddWarframeForm(Model model) {
		model.addAttribute("warframe", new WarframeItem());
		return "admin/warframe-form";
	}

	@PostMapping("/warframes")
	public String addWarframe(@ModelAttribute WarframeItem warframe) {
		warframeItemService.addItem(warframe);
		return "redirect:/admin/warframes";
	}

	@PostMapping("/warframes/delete/{id}")
	public String deleteWarframe(@PathVariable Long id) {
		warframeItemService.deleteItem(id);
		return "redirect:/admin/warframes";
	}

	@GetMapping("/players")
	public String listPlayers(Model model) {
		model.addAttribute("players", playerService.getAllPlayers());
		return "admin/players";
	}

	@PostMapping("/players/delete/{id}")
	public String deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
		return "redirect:/admin/players";
	}
}
