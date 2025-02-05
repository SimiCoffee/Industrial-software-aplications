package ug.proj.warframe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatisticsDTO {
	private Long id;
	private int missionsCompleted;
	private int missionsFailed;
	private int missionsQuit;
	private int timePlayed;
	private int grossIncome;

	public PlayerStatisticsDTO(int timePlayed) {
		this.timePlayed = timePlayed;
	}

}
