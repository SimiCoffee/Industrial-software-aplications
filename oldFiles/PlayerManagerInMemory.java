
package ug.proj.warframe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.domain.PlayerProfile;
import ug.proj.warframe.domain.PlayerStatistics;
import ug.proj.warframe.domain.WarframeItem;
import ug.proj.warframe.domain.WarframeLoadout;

@Service
public class PlayerManagerInMemory implements PlayerManager {

	private final List<Player> players = Collections.synchronizedList(new ArrayList<>());

	@Override
	public Player addPlayer(Player player) {
		PlayerProfile defaultProfile = new PlayerProfile();
		defaultProfile.setMasteryRank(0);
		defaultProfile.setClan("No Clan");
		defaultProfile.setExp(0);

		PlayerStatistics defaultStatistics = new PlayerStatistics();
		defaultStatistics.setTimePlayed(0);
		defaultStatistics.setMissionsCompleted(0);
		defaultStatistics.setMissionsFailed(0);
		defaultStatistics.setMissionsQuit(0);
		defaultStatistics.setGrossIncome(0);

		player.setProfile(defaultProfile);
		player.setStatistics(defaultStatistics);

		players.add(player);
		return player;
	}

	@Override
	public List<Player> getAllPlayers() {
		return players;
	}

	@Override
	public Player findPlayerById(Long id) {
		return players.stream()
				.filter(player -> player.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean deletePlayer(Long id) {
		Optional<Player> playerToRemove = players.stream()
				.filter(player -> player.getId().equals(id))
				.findFirst();

		playerToRemove.ifPresent(players::remove);
		return playerToRemove.isPresent();
	}

	@Override
	public WarframeItem addWarframeToPlayer(Long playerId, WarframeItem warframe) {
		Player player = findPlayerById(playerId);
		if (player != null) {
			WarframeLoadout loadout = new WarframeLoadout("Custom Loadout", warframe, new HashSet<>(),
					player);
			player.getWarframeLoadouts().add(loadout);
			return warframe;
		}
		return null;
	}

	@Override
	public List<WarframeItem> getWarframesForPlayer(Long playerId) {
		Player player = findPlayerById(playerId);
		return (player != null)
				? player.getWarframeLoadouts().stream()
						.map(WarframeLoadout::getWarframe) // Pobieramy WarframeItem z Loadout
						.toList() // Konwertujemy na List<WarframeItem>
				: List.of();
	}
}
