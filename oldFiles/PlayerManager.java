package ug.proj.warframe.service;

import ug.proj.warframe.domain.Player;
import ug.proj.warframe.domain.WarframeItem;

import java.util.List;

public interface PlayerManager {

	Player addPlayer(Player player);

	List<Player> getAllPlayers();

	Player findPlayerById(Long id);

	boolean deletePlayer(Long id);

	WarframeItem addWarframeToPlayer(Long playerId, WarframeItem warframe);

	List<WarframeItem> getWarframesForPlayer(Long playerId);
}
