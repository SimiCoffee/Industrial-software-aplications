package ug.proj.warframe;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.domain.PlayerProfile;
import ug.proj.warframe.domain.PlayerStatistics;
import ug.proj.warframe.domain.Skill;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.domain.WarframeLoadout;
import ug.proj.warframe.service.PlayerService;
import ug.proj.warframe.service.WarframeItemService;
import ug.proj.warframe.service.WarframeLoadoutService;

@SpringBootApplication
@ComponentScan(basePackages = "ug.proj.warframe")
public class WarframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarframeApplication.class, args);
	}

	@Bean
	CommandLineRunner appSetup(WarframeItemService warframeItemService, PlayerService playerService,
			WarframeLoadoutService warframeLoadoutService) {
		return args -> {
			WarframeItem excalibur = WarframeItem.builder().name("Excalibur").health(370).shields(370)
					.armor(240).energy(150).build();
			WarframeItem mag = WarframeItem.builder().name("Mag").health(280).shields(555).armor(105)
					.energy(190).build();
			WarframeItem volt = WarframeItem.builder().name("Volt").health(370).shields(555).armor(105)
					.energy(150).build();
			WarframeItem inaros = WarframeItem.builder().name("Inaros").health(2310).shields(0).armor(240)
					.energy(150).build();
			WarframeItem grendelPrime = WarframeItem.builder().name("Grendel Prime").health(1295)
					.shields(95).armor(400).energy(250).build();
			WarframeItem wukongPrime = WarframeItem.builder().name("Wukong Prime").health(555).shields(445)
					.armor(290).energy(195).build();
			WarframeItem zephyrPrime = WarframeItem.builder().name("Zephyr Prime").health(555).shields(555)
					.armor(135).energy(225).build();
			WarframeItem atlasPrime = WarframeItem.builder().name("Atlas Prime").health(650).shields(655)
					.armor(500).energy(265).build();

			warframeItemService.addItem(excalibur);
			warframeItemService.addItem(mag);
			warframeItemService.addItem(volt);
			warframeItemService.addItem(inaros);
			warframeItemService.addItem(grendelPrime);
			warframeItemService.addItem(wukongPrime);
			warframeItemService.addItem(zephyrPrime);
			warframeItemService.addItem(atlasPrime);

			Skill slashDash = Skill.builder().name("Slash Dash")
					.description("Dashes between enemies with energy slashes.").build();
			Skill pull = Skill.builder().name("Pull").description("Pulls enemies towards you.").build();
			Skill shock = Skill.builder().name("Shock").description("Sends an electric bolt to a target.")
					.build();
			Skill sandstorm = Skill.builder().name("Sandstorm").description("Creates a whirlwind of sand.")
					.build();
			Skill primalFury = Skill.builder().name("Primal Fury").description("Unleashes staff attacks.")
					.build();
			Skill landslide = Skill.builder().name("Landslide").description("Dashes and punches enemies.")
					.build();
			Skill tornado = Skill.builder().name("Tornado").description("Summons destructive tornadoes.")
					.build();

			Set<Skill> excaliburSkills = Set.of(slashDash);
			Set<Skill> magSkills = Set.of(pull);
			Set<Skill> voltSkills = Set.of(shock);
			Set<Skill> inarosSkills = Set.of(sandstorm);
			Set<Skill> grendelSkills = Set.of(primalFury);
			Set<Skill> atlasSkills = Set.of(landslide);
			Set<Skill> zephyrSkills = Set.of(tornado);

			PlayerProfile profile1 = PlayerProfile.builder()
					.masteryRank(10)
					.experience(50000)
					.clan("Tenno")
					.build();

			PlayerProfile profile2 = PlayerProfile.builder()
					.masteryRank(20)
					.experience(120000)
					.clan("Lotus")
					.build();

			PlayerStatistics stats1 = PlayerStatistics.builder()
					.missionsCompleted(100)
					.missionsFailed(10)
					.missionsQuit(5)
					.timePlayed(500)
					.grossIncome(100000)
					.build();

			PlayerStatistics stats2 = PlayerStatistics.builder()
					.missionsCompleted(250)
					.missionsFailed(15)
					.missionsQuit(8)
					.timePlayed(1200)
					.grossIncome(250000)
					.build();

			Player player1 = Player.builder().name("WarframeMaster").profile(profile1).statistics(stats1)
					.build();
			Player player2 = Player.builder().name("FrameCollector").profile(profile2).statistics(stats2)
					.build();

			playerService.addPlayer(player1);
			playerService.addPlayer(player2);

			WarframeLoadout loadout1 = WarframeLoadout.builder().loadoutName("Excalibur's Loadout")
					.warframe(excalibur).skills(excaliburSkills).player(player1).build();
			WarframeLoadout loadout2 = WarframeLoadout.builder().loadoutName("Mag's Loadout").warframe(mag)
					.skills(magSkills).player(player1).build();
			WarframeLoadout loadout3 = WarframeLoadout.builder().loadoutName("Volt's Loadout")
					.warframe(volt).skills(voltSkills).player(player1).build();
			WarframeLoadout loadout4 = WarframeLoadout.builder().loadoutName("Sandstorm Build")
					.warframe(inaros).skills(inarosSkills).player(player2).build();
			WarframeLoadout loadout5 = WarframeLoadout.builder().loadoutName("Titan Strength")
					.warframe(atlasPrime).skills(atlasSkills).player(player2).build();
			WarframeLoadout loadout6 = WarframeLoadout.builder().loadoutName("Wukong Fury")
					.warframe(wukongPrime).skills(grendelSkills).player(player2).build();
			WarframeLoadout loadout7 = WarframeLoadout.builder().loadoutName("Zephyr's Storm")
					.warframe(zephyrPrime).skills(zephyrSkills).player(player1).build();

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
