package dummy;

import java.util.Scanner;

public enum Planet {
	MERCURY(0.2408467),
	VENUS(0.61519726),
	EARTH(1),
	MARS(1.8808158),
	JUPITER(11.862615),
	SATURN(29.447498),
	URANUS(84.016846),
	NEPTUNE(164.79132);

	private final double revolutionTimeInYears;

	Planet(double revolutionTimeInYears) {
		this.revolutionTimeInYears = revolutionTimeInYears;
	}

	public double getRevolutionTimeInYears() {
		return this.revolutionTimeInYears;
	}

	public double getAgeByPlanet(int seconds) {
		double earthYear = 31557600;
		double earthAge = seconds / earthYear;
		return earthAge /= this.revolutionTimeInYears;
	}
}
