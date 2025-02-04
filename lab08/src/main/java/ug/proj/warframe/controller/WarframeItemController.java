package ug.proj.warframe.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.exception.ItemNotFoundException;
// import ug.proj.warframe.service.ItemManager;
import ug.proj.warframe.service.WarframeItemService;

@RestController
@RequestMapping("/api/warframes")
@Validated
public class WarframeItemController {

	// private final ItemManager itemManager;
	private final WarframeItemService warframeItemService;

	public WarframeItemController(WarframeItemService warframeItemService) {
		this.warframeItemService = warframeItemService;
	}

	@GetMapping
	public List<WarframeItem> getAllItems() {
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
}
