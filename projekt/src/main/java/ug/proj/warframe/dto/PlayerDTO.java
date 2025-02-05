package ug.proj.warframe.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ug.proj.warframe.domain.PlayerProfile;
import ug.proj.warframe.domain.PlayerStatistics;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
	private Long id;
	private String name;
	private PlayerProfileDTO profile;
	private PlayerStatisticsDTO statistics;
	private Set<WarframeLoadoutDTO> warframeLoadouts;

	public PlayerDTO(Long id, String name, PlayerProfileDTO profile) {
		this.id = id;
		this.name = name;
		this.profile = profile;
	}
}
