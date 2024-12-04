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
import ug.proj.warframe.exception.ItemNotFoundException;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.service.ItemManager;

@RestController
@RequestMapping("/api/warframe/items")
@Validated
public class WarframeItemController {

	private final ItemManager itemManager;

	public WarframeItemController(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	@GetMapping
	public List<WarframeItem> getAllItems() {
		return itemManager.getAllItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WarframeItem> getItemById(@PathVariable String id) {
		return itemManager.findById(id)
				.map(ResponseEntity::ok)
				.orElseThrow(ItemNotFoundException::new);
	}

	@PostMapping
	public ResponseEntity<WarframeItem> addItem(@Valid @RequestBody WarframeItem item) {
		WarframeItem savedItem = itemManager.addItem(item);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/warframe/items/" + savedItem.getId());
		return new ResponseEntity<>(savedItem, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<WarframeItem> updateItem(@PathVariable String id, @Valid @RequestBody WarframeItem item) {
		if (itemManager.updateItem(id, item)) {
			return ResponseEntity.ok(item);
		} else {
			throw new ItemNotFoundException();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable String id) {
		if (itemManager.deleteItem(id)) {
			return ResponseEntity.noContent().build();
		} else {
			throw new ItemNotFoundException();
		}
	}
}
