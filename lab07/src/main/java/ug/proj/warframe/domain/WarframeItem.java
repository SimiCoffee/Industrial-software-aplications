package ug.proj.warframe.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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

	@Min(value = 1, message = "Shields must be at least 1")
	private int shields;

	@Min(value = 1, message = "Armor must be at least 1")
	private int armor;

	@Min(value = 1, message = "Energy must be at least 1")
	private int energy;

	@ManyToMany
	@JoinTable(name = "warframe_skills", joinColumns = @JoinColumn(name = "warframe_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

	@ManyToOne
	@JoinColumn(name = "loadout_id")
	private WarframeLoadout loadout;

	// Gettery i settery
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getShields() {
		return shields;
	}

	public void setShields(int shields) {
		this.shields = shields;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public WarframeLoadout getLoadout() {
		return loadout;
	}

	public void setLoadout(WarframeLoadout loadout) {
		this.loadout = loadout;
	}
}
