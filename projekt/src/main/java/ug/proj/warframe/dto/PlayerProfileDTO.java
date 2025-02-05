package ug.proj.warframe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProfileDTO {
	private Long id;
	private int masteryRank;
	private Long experience;
	private String clan;
}
