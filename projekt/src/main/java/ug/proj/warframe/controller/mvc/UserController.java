package ug.proj.warframe.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ug.proj.warframe.service.PlayerService;
import ug.proj.warframe.service.WarframeItemService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final WarframeItemService warframeItemService;
	private final PlayerService playerService;

	public UserController(WarframeItemService warframeItemService, PlayerService playerService) {
		this.warframeItemService = warframeItemService;
		this.playerService = playerService;
	}

	@GetMapping("/warframes")
	public String listWarframes(Model model) {
		model.addAttribute("warframes", warframeItemService.getAllItems());
		return "user/warframes";
	}

}
