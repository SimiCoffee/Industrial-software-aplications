package ug.proj.warframe.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.dto.SkillDTO;
import ug.proj.warframe.dto.WarframeLoadoutDTO;
import ug.proj.warframe.repository.WarframeLoadoutRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarframeLoadoutService {

	private final WarframeLoadoutRepository warframeLoadoutRepository;

	public WarframeLoadoutService(WarframeLoadoutRepository warframeLoadoutRepository) {
		this.warframeLoadoutRepository = warframeLoadoutRepository;
	}

	public WarframeLoadout addLoadout(WarframeLoadout loadout) {
		return warframeLoadoutRepository.save(loadout);
	}

	@Transactional
	public List<WarframeLoadoutDTO> getAllLoadouts() {
		return warframeLoadoutRepository.findAll().stream()
				.map(loadout -> new WarframeLoadoutDTO(
						loadout.getId(),
						loadout.getLoadoutName(),
						loadout.getWarframe(),
						loadout.getSkills().stream()
								.map(skill -> new SkillDTO(skill.getId(),
										skill.getName(),
										skill.getDescription()))
								.collect(Collectors.toSet()),
						loadout.getPlayer().getName()))
				.toList();
	}

	@Transactional
	public Optional<WarframeLoadoutDTO> getLoadoutById(Long id) {
		return warframeLoadoutRepository.findById(id)
				.map(loadout -> new WarframeLoadoutDTO(
						loadout.getId(),
						loadout.getLoadoutName(),
						loadout.getWarframe(),
						loadout.getSkills().stream()
								.map(skill -> new SkillDTO(skill.getId(),
										skill.getName(),
										skill.getDescription()))
								.collect(Collectors.toSet()),
						loadout.getPlayer().getName()));

	}

	public boolean deleteLoadout(Long id) {
		if (warframeLoadoutRepository.existsById(id)) {
			warframeLoadoutRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<WarframeLoadout> findByLoadoutNameAndWarframe(String loadoutName, String warframeName) {
		return warframeLoadoutRepository.findByLoadoutNameAndWarframe_Name(loadoutName, warframeName);
	}

	public List<WarframeLoadout> findByLoadoutNameOrPlayer(String loadoutName, String playerName) {
		return warframeLoadoutRepository.findByLoadoutNameOrPlayer_Name(loadoutName, playerName);
	}

	public List<WarframeLoadout> findLoadoutsByWarframeOrPlayer(String warframeName, String playerName) {
		return warframeLoadoutRepository.findLoadoutsByWarframeOrPlayer(warframeName, playerName);
	}
}
