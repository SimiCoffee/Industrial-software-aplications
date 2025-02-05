package ug.proj.warframe;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.DispatcherServlet;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.domain.PlayerProfile;
import ug.proj.warframe.domain.PlayerStatistics;
import ug.proj.warframe.domain.Skill;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.service.PlayerService;
import ug.proj.warframe.service.WarframeItemService;
// import ug.proj.warframe.service.ItemManager;
import ug.proj.warframe.service.WarframeLoadoutService;

@SpringBootApplication
// @EnableAutoConfiguration
// @EnableJpaRepositories(basePackages = "ug.proj.warframe.repository")
// @EntityScan(basePackages = "ug.proj.warframe.domain")
@ComponentScan(basePackages = "ug.proj.warframe")
public class WarframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarframeApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// return args -> {
	// System.out.println("Registered beans:");
	// for (String beanName : ctx.getBeanDefinitionNames()) {
	// System.out.println(beanName);
	// }
	// };
	// }

	// @Bean
	// public ServletRegistrationBean<DispatcherServlet>
	// dispatcherServletRegistrationBean(
	// DispatcherServlet dispatcherServlet) {
	// ServletRegistrationBean<DispatcherServlet> registration = new
	// ServletRegistrationBean<>(
	// dispatcherServlet);
	// registration.getUrlMappings().clear();
	// registration.addUrlMappings("/api/*");
	// return registration;
	// }

	@Bean
	CommandLineRunner appSetup(WarframeItemService warframeItemService, PlayerService playerService,
			WarframeLoadoutService warframeLoadoutService) {
		return args -> {
			WarframeItem excalibur = new WarframeItem("Excalibur", 370, 370, 240, 150);
			WarframeItem mag = new WarframeItem("Mag", 280, 555, 105, 190);
			WarframeItem volt = new WarframeItem("Volt", 370, 555, 105, 150);
			WarframeItem inaros = new WarframeItem("Inaros", 2310, 0, 240, 150);
			WarframeItem grendelPrime = new WarframeItem("Grendel Prime", 1295, 95, 400, 250);
			WarframeItem wukongPrime = new WarframeItem("Wukong Prime", 555, 445, 290, 195);
			WarframeItem zephyrPrime = new WarframeItem("Zephyr Prime", 555, 555, 135, 225);
			WarframeItem atlasPrime = new WarframeItem("Atlas Prime", 650, 655, 500, 265);

			warframeItemService.addItem(excalibur);
			warframeItemService.addItem(mag);
			warframeItemService.addItem(volt);
			warframeItemService.addItem(inaros);
			warframeItemService.addItem(grendelPrime);
			warframeItemService.addItem(wukongPrime);
			warframeItemService.addItem(zephyrPrime);
			warframeItemService.addItem(atlasPrime);

			Skill slashDash = new Skill("Slash Dash", "Dashes between enemies with energy slashes.");
			Skill pull = new Skill("Pull", "Pulls enemies towards you.");
			Skill shock = new Skill("Shock", "Sends an electric bolt to a target.");
			Skill sandstorm = new Skill("Sandstorm", "Creates a whirlwind of sand.");
			Skill primalFury = new Skill("Primal Fury", "Unleashes staff attacks.");
			Skill landslide = new Skill("Landslide", "Dashes and punches enemies.");
			Skill tornado = new Skill("Tornado", "Summons destructive tornadoes.");

			Set<Skill> excaliburSkills = Set.of(slashDash);
			Set<Skill> magSkills = Set.of(pull);
			Set<Skill> voltSkills = Set.of(shock);
			Set<Skill> inarosSkills = Set.of(sandstorm);
			Set<Skill> grendelSkills = Set.of(primalFury);
			Set<Skill> atlasSkills = Set.of(landslide);
			Set<Skill> zephyrSkills = Set.of(tornado);

			PlayerProfile profile1 = new PlayerProfile(10, 50000, "Tenno");
			PlayerProfile profile2 = new PlayerProfile(20, 100000, "Lotus");

			PlayerStatistics stats1 = new PlayerStatistics(100, 10, 5, 500, 100000);
			PlayerStatistics stats2 = new PlayerStatistics(250, 15, 8, 1200, 250000);

			Player player1 = new Player("WarframeMaster", profile1, stats1);
			Player player2 = new Player("FrameCollector", profile2, stats2);

			playerService.addPlayer(player1);
			playerService.addPlayer(player2);

			WarframeLoadout loadout1 = new WarframeLoadout("Excalibur's Loadout", excalibur,
					excaliburSkills, player1);
			WarframeLoadout loadout2 = new WarframeLoadout("Mag's Loadout", mag, magSkills, player1);
			WarframeLoadout loadout3 = new WarframeLoadout("Volt's Loadout", volt, voltSkills, player1);
			WarframeLoadout loadout4 = new WarframeLoadout("Sandstorm Build", inaros, inarosSkills,
					player2);
			WarframeLoadout loadout5 = new WarframeLoadout("Titan Strength", atlasPrime, atlasSkills,
					player2);
			WarframeLoadout loadout6 = new WarframeLoadout("Wukong Fury", wukongPrime, grendelSkills,
					player2);
			WarframeLoadout loadout7 = new WarframeLoadout("Zephyr's Storm", zephyrPrime, zephyrSkills,
					player1);

			warframeLoadoutService.addLoadout(loadout1);
			warframeLoadoutService.addLoadout(loadout2);
			warframeLoadoutService.addLoadout(loadout3);
			warframeLoadoutService.addLoadout(loadout4);
			warframeLoadoutService.addLoadout(loadout5);
			warframeLoadoutService.addLoadout(loadout6);
			warframeLoadoutService.addLoadout(loadout7);
		};
	}
}
