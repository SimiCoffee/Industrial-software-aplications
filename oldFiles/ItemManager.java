package ug.proj.warframe.service;

import java.util.List;
import java.util.Optional;

import ug.proj.warframe.domain.WarframeItem;

public interface ItemManager {
	WarframeItem addItem(WarframeItem item);

	List<WarframeItem> getAllItems();

	Optional<WarframeItem> findById(String id);

	boolean updateItem(Long id, WarframeItem item);

	boolean deleteItem(Long id);
}
