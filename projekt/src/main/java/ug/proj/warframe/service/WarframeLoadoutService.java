package ug.proj.warframe.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ug.proj.warframe.domain.Skill;
import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.dto.SkillDTO;
import ug.proj.warframe.dto.WarframeLoadoutDTO;
import ug.proj.warframe.repository.WarframeLoadoutRepository;
import ug.proj.warframe.specification.WarframeLoadoutSpecification;

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
				.map(this::convertToDTO)
				.toList();
	}

	@Transactional
	public Optional<WarframeLoadoutDTO> getLoadoutById(Long id) {
		return warframeLoadoutRepository.findById(id)
				.map(this::convertToDTO);
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

	@Transactional(readOnly = true)
	public Page<WarframeLoadoutDTO> searchLoadouts(
			String warframeName, String playerName, Integer minHealth, Integer maxHealth, Integer armor,
			Pageable pageable) {

		Specification<WarframeLoadout> spec = WarframeLoadoutSpecification.filterByCriteria(
				warframeName, playerName, minHealth, maxHealth, armor);

		return warframeLoadoutRepository.findAll(spec, pageable)
				.map(loadout -> new WarframeLoadoutDTO(
						loadout.getId(),
						loadout.getLoadoutName(),
						loadout.getWarframe(),
						convertSkillsToDTO(loadout.getSkills()),
						loadout.getPlayer().getName()));
	}

	private Set<SkillDTO> convertSkillsToDTO(Set<Skill> skills) {
		return skills != null
				? skills.stream()
						.map(skill -> new SkillDTO(skill.getId(), skill.getName(),
								skill.getDescription()))
						.collect(Collectors.toSet())
				: Set.of();
	}

	private WarframeLoadoutDTO convertToDTO(WarframeLoadout loadout) {
		Set<Skill> skills = new HashSet<>(loadout.getSkills());

		Set<SkillDTO> skillDTOs = skills.stream()
				.map(skill -> new SkillDTO(skill.getId(), skill.getName(), skill.getDescription()))
				.collect(Collectors.toSet());

		return new WarframeLoadoutDTO(
				loadout.getId(),
				loadout.getLoadoutName(),
				loadout.getWarframe(),
				skillDTOs,
				loadout.getPlayer() != null ? loadout.getPlayer().getName() : "Unknown");
	}
}
