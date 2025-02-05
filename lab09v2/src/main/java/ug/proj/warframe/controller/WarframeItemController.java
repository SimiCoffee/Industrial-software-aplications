package ug.proj.warframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.exception.ItemNotFoundException;
import ug.proj.warframe.service.WarframeItemService;

@RestController
@RequestMapping("/api/warframe/items")
@Validated
public class WarframeItemController {

	@Autowired
	private final WarframeItemService warframeItemService;

	public WarframeItemController(WarframeItemService warframeItemService) {
		System.out.println("✅ WarframeItemController został załadowany");
		this.warframeItemService = warframeItemService;
		System.out.println("✅ WarframeItemController został załadowany2");
	}

	@GetMapping
	public List<WarframeItem> getAllItems() {
		System.out.println("GET /api/warframe/items was called"); // Debug log
		return warframeItemService.getAllItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WarframeItem> getItemById(@PathVariable Long id) {
		return warframeItemService.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(ItemNotFoundException::new);
	}

	@PostMapping
	public ResponseEntity<WarframeItem> addItem(@Valid @RequestBody WarframeItem item) {
		WarframeItem savedItem = warframeItemService.addItem(item);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/warframe/items/" + savedItem.getId());
		return new ResponseEntity<>(savedItem, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<WarframeItem> updateItem(@PathVariable Long id, @Valid @RequestBody WarframeItem item) {
		if (warframeItemService.updateItem(id, item)) {
			return ResponseEntity.ok(item);
		} else {
			throw new ItemNotFoundException();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		if (warframeItemService.deleteItem(id)) {
			return ResponseEntity.noContent().build();
		} else {
			throw new ItemNotFoundException();
		}
	}

	@GetMapping("/by-health-and-shields")
	public List<WarframeItem> getByHealthAndShields(@RequestParam int health, @RequestParam int shields) {
		return warframeItemService.findByHealthAndShields(health, shields);
	}

	@GetMapping("/by-health-or-armor")
	public List<WarframeItem> getByHealthOrArmor(@RequestParam int health, @RequestParam int armor) {
		return warframeItemService.findByHealthOrArmor(health, armor);
	}

	@GetMapping("/by-health-range")
	public List<WarframeItem> getByHealthRange(@RequestParam int minHealth, @RequestParam int maxHealth) {
		return warframeItemService.findWarframesWithHealthBetween(minHealth, maxHealth);
	}

	@GetMapping("/high-stats")
	public List<WarframeItem> getHighStatsWarframes() {
		return warframeItemService.findWarframesWithHighHealthOrArmor();
	}

}
