package ug.proj.warframe.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.dto.ApiResponse;
import ug.proj.warframe.dto.PlayerDTO;
import ug.proj.warframe.service.PlayerService;

@RestController
@RequestMapping("/api/warframe/players")
public class PlayerController {

	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping
	public List<PlayerDTO> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound()
						.build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse> addPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("created", "Player was added"));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePlayer(@PathVariable Long id) {
		return playerService.deletePlayer(id) ? ResponseEntity.ok(new ApiResponse("Ok", "Player removed"))
				: ResponseEntity.notFound().build();
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

	@GetMapping("/by-mastery-rank")
	public List<PlayerDTO> getPlayersByMasteryRank(@RequestParam int rank) {
		return playerService.getPlayersByMasteryRank(rank);
	}
}
