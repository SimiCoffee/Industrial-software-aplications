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
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "ug.proj.warframe.repository")
@EntityScan(basePackages = "ug.proj.warframe.domain")
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

	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistrationBean(
			DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(
				dispatcherServlet);
		registration.getUrlMappings().clear();
		registration.addUrlMappings("/api/*");
		return registration;
	}

	@Bean
	CommandLineRunner appSetup(WarframeItemService warframeItemService, PlayerService playerService,
			WarframeLoadoutService warframeLoadoutService) {
		return args -> {
			WarframeItem excalibur = new WarframeItem("Excalibur", 300, 300, 225, 150);
			WarframeItem mag = new WarframeItem("Mag", 225, 450, 65, 150);
			WarframeItem volt = new WarframeItem("Volt", 300, 300, 100, 150);

			Skill skill1 = new Skill("Slash Dash", "Dashes between enemies with energy slashes.");
			Skill skill2 = new Skill("Pull", "Pulls enemies towards you.");
			Skill skill3 = new Skill("Shock", "Sends an electric bolt to a target.");

			Set<Skill> excaliburSkills = Set.of(skill1);
			Set<Skill> magSkills = Set.of(skill2);
			Set<Skill> voltSkills = Set.of(skill3);

			warframeItemService.addItem(excalibur);
			warframeItemService.addItem(mag);
			warframeItemService.addItem(volt);

			PlayerProfile profile = new PlayerProfile(10, 50000, "Tenno");
			PlayerStatistics stats = new PlayerStatistics(100, 10, 5, 500, 100000);
			Player player = new Player("WarframeMaster", profile, stats);
			playerService.addPlayer(player);

			WarframeLoadout loadout1 = new WarframeLoadout("Excalibur's Loadout", excalibur,
					excaliburSkills, player);
			WarframeLoadout loadout2 = new WarframeLoadout("Mag's Loadout", mag, magSkills, player);
			WarframeLoadout loadout3 = new WarframeLoadout("Volt's Loadout", volt, voltSkills, player);

			warframeLoadoutService.addLoadout(loadout1);
			warframeLoadoutService.addLoadout(loadout2);
			warframeLoadoutService.addLoadout(loadout3);
		};
	}
}
