package ug.proj.warframe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.dto.WarframeLoadoutDTO;
import ug.proj.warframe.service.WarframeLoadoutService;

@RestController
@RequestMapping("/api/warframe/loadouts")
public class WarframeLoadoutController {

	private final WarframeLoadoutService warframeLoadoutService;

	public WarframeLoadoutController(WarframeLoadoutService warframeLoadoutService) {
		this.warframeLoadoutService = warframeLoadoutService;
	}

	@GetMapping
	public List<WarframeLoadoutDTO> getAllLoadouts() {
		return warframeLoadoutService.getAllLoadouts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WarframeLoadoutDTO> getLoadoutById(@PathVariable Long id) {
		return warframeLoadoutService.getLoadoutById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public WarframeLoadout createLoadout(@RequestBody WarframeLoadout loadout) {
		return warframeLoadoutService.addLoadout(loadout);
	}

	@PutMapping("/{id}")
	public ResponseEntity<WarframeLoadout> updateLoadout(@PathVariable Long id,
			@RequestBody WarframeLoadout loadout) {
		return warframeLoadoutService.getLoadoutById(id).map(existingLoadout -> {
			loadout.setId(id);
			return ResponseEntity.ok(warframeLoadoutService.addLoadout(loadout));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLoadout(@PathVariable Long id) {
		if (warframeLoadoutService.deleteLoadout(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/by-name-and-warframe")
	public List<WarframeLoadout> getByLoadoutNameAndWarframe(@RequestParam String loadoutName,
			@RequestParam String warframeName) {
		return warframeLoadoutService.findByLoadoutNameAndWarframe(loadoutName, warframeName);
	}

	@GetMapping("/by-name-or-player")
	public List<WarframeLoadout> getByLoadoutNameOrPlayer(@RequestParam("loadoutName") String loadoutName,
			@RequestParam("playerName") String playerName) {
		return warframeLoadoutService.findByLoadoutNameOrPlayer(loadoutName, playerName);
	}

	@GetMapping("/by-warframe-or-player")
	public List<WarframeLoadout> getByWarframeOrPlayer(@RequestParam String warframeName,
			@RequestParam String playerName) {
		return warframeLoadoutService.findLoadoutsByWarframeOrPlayer(warframeName, playerName);
	}
}
