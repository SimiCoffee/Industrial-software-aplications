package ug.proj.warframe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WarframeItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "^[A-Za-z0-9\\s]{3,50}$", message = "Name must be between 3 and 50 alphanumeric characters")
	private String name;

	@Min(value = 1, message = "Health must be at least 1")
	private int health;

	@Min(value = 0, message = "Shields must be at least 1")
	private int shields;

	@Min(value = 1, message = "Armor must be at least 1")
	private int armor;

	@Min(value = 1, message = "Energy must be at least 1")
	private int energy;

}
