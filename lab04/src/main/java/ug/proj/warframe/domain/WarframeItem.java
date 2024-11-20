package ug.proj.warframe.domain;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

public class WarframeItem {

	private String id;

	@Pattern(regexp = "^[A-Za-z0-9\\s]{3,50}$", message = "Name must be between 3 and 50 alphanumeric characters")
	private String name;

	@Min(1)
	private int health;

	@Min(1)
	private int shields;

	@Min(1)
	private int armor;

	@Min(1)
	private int energy;

	private boolean isPrime;

	@PastOrPresent(message = "Release date must be in the past or present")
	private LocalDate releaseDate;

	public WarframeItem() {
		this.id = UUID.randomUUID().toString();
	}

	public WarframeItem(String name, int health, int shields, int armor, int energy, boolean isPrime,
			LocalDate releaseDate) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.health = health;
		this.shields = shields;
		this.armor = armor;
		this.energy = energy;
		this.isPrime = isPrime;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public boolean getIsPrime() {
		return isPrime;
	}

	public void setPrime(boolean prime) {
		isPrime = prime;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
}
