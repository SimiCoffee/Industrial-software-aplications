package ug.proj.warframe.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ug.proj.warframe.domain.Player;
import ug.proj.warframe.dto.PlayerDTO;
import ug.proj.warframe.dto.PlayerProfileDTO;
import ug.proj.warframe.dto.PlayerStatisticsDTO;
import ug.proj.warframe.dto.SkillDTO;
import ug.proj.warframe.dto.WarframeLoadoutDTO;
import ug.proj.warframe.repository.PlayerRepository;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Player addPlayer(Player player) {
		return playerRepository.save(player);
	}

	@Transactional
	public List<PlayerDTO> getAllPlayers() {
		return playerRepository.findAll().stream()
				.map(player -> convertToDTO(player, false))
				.toList();
	}

	@Transactional
	public Optional<PlayerDTO> getPlayerById(Long id) {
		return playerRepository.findById(id)
				.map(player -> convertToDTO(player, true));
	}

	public boolean deletePlayer(Long id) {
		if (playerRepository.existsById(id)) {
			playerRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Player> findByNameAndMasteryRank(String name, int masteryRank) {
		return playerRepository.findByNameAndProfile_MasteryRank(name, masteryRank);
	}

	public List<Player> findByNameOrClan(String name, String clan) {
		return playerRepository.findByNameOrProfile_Clan(name, clan);
	}

	public List<Player> findPlayersByMasteryRankOrIncome(int masteryRank, long income) {
		return playerRepository.findPlayersByMasteryRankOrIncome(masteryRank, income);
	}

	public List<PlayerDTO> getPlayersByMasteryRank(int rank) {
		List<Object[]> results = playerRepository.findPlayersByNativeMasteryRank(rank);

		return results.stream().map(obj -> new PlayerDTO(
				((Number) obj[0]).longValue(),
				(String) obj[1],
				new PlayerProfileDTO(
						((Number) obj[2]).longValue(),
						((Number) obj[3]).intValue(),
						((Number) obj[4]).longValue(),
						(String) obj[5])))
				.toList();
	}

	private PlayerDTO convertToDTO(Player player, boolean showPlayerName) {
		return new PlayerDTO(
				player.getId(),
				player.getName(),
				new PlayerProfileDTO(
						player.getProfile().getId(),
						player.getProfile().getMasteryRank(),
						player.getProfile().getExperience(),
						player.getProfile().getClan()),
				new PlayerStatisticsDTO(
						player.getStatistics().getTimePlayed()),
				player.getWarframeLoadouts() != null
						? player.getWarframeLoadouts().stream()
								.map(loadout -> new WarframeLoadoutDTO(
										loadout.getId(),
										loadout.getLoadoutName(),
										loadout.getWarframe(),
										loadout.getSkills() != null
												? loadout.getSkills()
														.stream()
														.map(skill -> new SkillDTO(
																skill.getId(),
																skill.getName(),
																skill.getDescription()))
														.collect(Collectors
																.toSet())
												: Collections.emptySet(),
										showPlayerName ? player.getName()
												: null))
								.collect(Collectors.toSet())
						: Collections.emptySet());
	}
}
