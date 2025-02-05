package ug.proj.warframe.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ug.proj.warframe.domain.Player;
import ug.proj.warframe.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Player addPlayer(Player player) {
		return playerRepository.save(player);
	}

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Transactional
	public Optional<Player> findPlayerById(Long id) {
		return playerRepository.findById(id);
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
}
