package ug.proj.warframe.controller.rest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.dto.ApiResponse;
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
				.orElse(ResponseEntity.notFound()
						.build());
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createLoadout(@RequestBody WarframeLoadout loadout) {
		warframeLoadoutService.addLoadout(loadout);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("created", "Loadout created"));
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
	public ResponseEntity<ApiResponse> deleteLoadout(@PathVariable Long id) {
		if (warframeLoadoutService.deleteLoadout(id)) {
			return ResponseEntity.ok(new ApiResponse("Ok", "Loadout removed"));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/search")
	public Page<WarframeLoadoutDTO> searchLoadouts(
			@RequestParam(required = false) String warframeName,
			@RequestParam(required = false) String playerName,
			@RequestParam(required = false) Integer minHealth,
			@RequestParam(required = false) Integer maxHealth,
			@RequestParam(required = false) Integer armor,
			Pageable pageable) {

		return warframeLoadoutService.searchLoadouts(warframeName, playerName, minHealth, maxHealth, armor,
				pageable);
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
