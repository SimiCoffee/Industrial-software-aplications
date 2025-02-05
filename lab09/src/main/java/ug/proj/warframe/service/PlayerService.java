package ug.proj.warframe.service;

import org.springframework.stereotype.Service;
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
}
