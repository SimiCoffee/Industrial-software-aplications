package ug.proj.warframe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.service.PlayerService;

@RestController
@RequestMapping("/api/warframe/players")
public class PlayerController {

	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping("/by-name-and-rank")
	public List<Player> getByNameAndMasteryRank(@RequestParam String name, @RequestParam int masteryRank) {
		return playerService.findByNameAndMasteryRank(name, masteryRank);
	}

	@GetMapping("/by-name-or-clan")
	public List<Player> getByNameOrClan(@RequestParam String name, @RequestParam String clan) {
		return playerService.findByNameOrClan(name, clan);
	}

	@GetMapping("/by-rank-or-income")
	public List<Player> getByMasteryRankOrIncome(@RequestParam("masteryRank") int masteryRank,
			@RequestParam("income") long income) {
		return playerService.findPlayersByMasteryRankOrIncome(masteryRank, income);
	}
}
