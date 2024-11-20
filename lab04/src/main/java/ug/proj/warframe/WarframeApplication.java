package ug.proj.warframe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.service.ItemManager;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class WarframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarframeApplication.class, args);
	}

	@Bean
	CommandLineRunner appSetup(ItemManager itemManager) {
		return args -> {
			List<WarframeItem> warframes = List.of(
					new WarframeItem("Excalibur", 300, 300, 225, 150, false,
							LocalDate.of(2012, 10, 25)),
					new WarframeItem("Mag", 225, 450, 65, 150, false, LocalDate.of(2012, 10, 25)),
					new WarframeItem("Volt", 300, 300, 100, 150, false, LocalDate.of(2012, 10, 25)),
					new WarframeItem("Rhino", 370, 555, 240, 150, false,
							LocalDate.of(2012, 10, 25)),
					new WarframeItem("Nyx", 300, 450, 50, 150, false, LocalDate.of(2012, 12, 6)),
					new WarframeItem("Loki", 300, 300, 100, 150, false, LocalDate.of(2012, 10, 25)),
					new WarframeItem("Frost", 300, 450, 300, 150, false,
							LocalDate.of(2012, 12, 29)),
					new WarframeItem("Ember", 300, 300, 125, 150, false, LocalDate.of(2013, 2, 9)),
					new WarframeItem("Trinity", 300, 300, 15, 150, false,
							LocalDate.of(2013, 2, 18)),
					new WarframeItem("Ash", 450, 300, 150, 100, false, LocalDate.of(2013, 2, 21)),

					new WarframeItem("Excalibur Prime", 300, 300, 250, 150, true,
							LocalDate.of(2012, 12, 18)),
					new WarframeItem("Mag Prime", 300, 450, 65, 175, true,
							LocalDate.of(2013, 9, 6)),
					new WarframeItem("Volt Prime", 300, 300, 100, 175, true,
							LocalDate.of(2015, 9, 29)),
					new WarframeItem("Rhino Prime", 300, 450, 275, 150, true,
							LocalDate.of(2014, 3, 5)),
					new WarframeItem("Nyx Prime", 300, 450, 50, 175, true,
							LocalDate.of(2014, 11, 11)),
					new WarframeItem("Loki Prime", 300, 300, 65, 175, true,
							LocalDate.of(2014, 6, 11)),
					new WarframeItem("Frost Prime", 300, 525, 300, 150, true,
							LocalDate.of(2013, 5, 8)),
					new WarframeItem("Ember Prime", 300, 300, 125, 200, true,
							LocalDate.of(2014, 7, 10)),
					new WarframeItem("Trinity Prime", 300, 300, 15, 200, true,
							LocalDate.of(2015, 10, 6)),
					new WarframeItem("Ash Prime", 450, 300, 150, 125, true,
							LocalDate.of(2015, 7, 7)));

			warframes.forEach(itemManager::addItem);
		};
	}
}
