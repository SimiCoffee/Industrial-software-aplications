package ug.proj.warframe.dto;

import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.domain.Skill;

import java.util.Set;

public class WarframeLoadoutDTO {
	private Long id;
	private String loadoutName;
	private WarframeItem warframe;
	private Set<SkillDTO> skills;
	private String playerName;

	public WarframeLoadoutDTO(Long id, String loadoutName, WarframeItem warframe, Set<SkillDTO> skills,
			String playerName) {
		this.id = id;
		this.loadoutName = loadoutName;
		this.warframe = warframe;
		this.skills = skills;
		this.playerName = playerName;
	}

	public Long getId() {
		return id;
	}

	public String getLoadoutName() {
		return loadoutName;
	}

	public WarframeItem getWarframe() {
		return warframe;
	}

	public Set<SkillDTO> getSkills() {
		return skills;
	}

	public String getPlayerName() {
		return playerName;
	}
}
