package ug.proj.warframe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import ug.proj.warframe.domain.WarframeItem;

@Service
public class ItemManagerInMemory implements ItemManager {

	private final Map<String, WarframeItem> items = new ConcurrentHashMap<>();

	@Override
	public WarframeItem addItem(WarframeItem item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		if (item.getId() == null) {
			// Automatyczne generowanie ID, jeśli jest null
			item.setId(UUID.randomUUID().toString());
		}
		items.put(item.getId(), item);
		return item;
	}

	@Override
	public List<WarframeItem> getAllItems() {
		return new ArrayList<>(items.values());
	}

	@Override
	public Optional<WarframeItem> findById(String id) {
		return Optional.ofNullable(items.get(id));
	}

	@Override
	public boolean updateItem(String id, WarframeItem item) {
		if (items.containsKey(id)) {
			items.put(id, item);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteItem(String id) {
		return items.remove(id) != null;
	}
}
