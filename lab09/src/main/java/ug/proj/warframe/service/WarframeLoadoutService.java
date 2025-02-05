package ug.proj.warframe.service;

import org.springframework.stereotype.Service;
import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.repository.WarframeLoadoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarframeLoadoutService {

	private final WarframeLoadoutRepository warframeLoadoutRepository;

	public WarframeLoadoutService(WarframeLoadoutRepository warframeLoadoutRepository) {
		this.warframeLoadoutRepository = warframeLoadoutRepository;
	}

	public WarframeLoadout addLoadout(WarframeLoadout loadout) {
		return warframeLoadoutRepository.save(loadout);
	}

	public List<WarframeLoadout> getAllLoadouts() {
		return warframeLoadoutRepository.findAll();
	}

	public Optional<WarframeLoadout> getLoadoutById(Long id) {
		return warframeLoadoutRepository.findById(id);
	}

	public boolean deleteLoadout(Long id) {
		if (warframeLoadoutRepository.existsById(id)) {
			warframeLoadoutRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
