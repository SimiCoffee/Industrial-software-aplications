package ug.proj.warframe.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.repository.WarframeItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarframeItemService {

	private final WarframeItemRepository warframeItemRepository;

	public WarframeItemService(WarframeItemRepository warframeItemRepository) {
		this.warframeItemRepository = warframeItemRepository;
	}

	public WarframeItem addItem(WarframeItem item) {
		return warframeItemRepository.save(item);
	}

	public List<WarframeItem> getAllItems() {
		return warframeItemRepository.findAll();
	}

	public Optional<WarframeItem> findById(Long id) {
		return warframeItemRepository.findById(id);
	}

	public boolean updateItem(Long id, WarframeItem item) {
		if (warframeItemRepository.existsById(id)) {
			item.setId(id);
			warframeItemRepository.save(item);
			return true;
		}
		return false;
	}

	public boolean deleteItem(Long id) {
		if (warframeItemRepository.existsById(id)) {
			warframeItemRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<WarframeItem> findByHealthAndShields(int health, int shields) {
		return warframeItemRepository.findByHealthAndShields(health, shields);
	}

	public List<WarframeItem> findByHealthOrArmor(int health, int armor) {
		return warframeItemRepository.findByHealthOrArmor(health, armor);
	}

	public List<WarframeItem> findWarframesWithHealthBetween(int minHealth, int maxHealth) {
		return warframeItemRepository.findWarframesWithHealthBetween(minHealth, maxHealth);
	}

	public List<WarframeItem> findWarframesWithHighHealthOrArmor() {
		return warframeItemRepository.findWarframesWithHighHealthOrArmor();
	}
}
