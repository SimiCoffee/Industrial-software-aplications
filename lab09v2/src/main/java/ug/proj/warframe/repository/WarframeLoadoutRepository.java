package ug.proj.warframe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ug.proj.warframe.domain.WarframeLoadout;

@Repository
public interface WarframeLoadoutRepository extends JpaRepository<WarframeLoadout, Long> {

	List<WarframeLoadout> findByPlayerId(Long playerId);

	List<WarframeLoadout> findByLoadoutNameAndWarframe_Name(String loadoutName, String warframeName);

	List<WarframeLoadout> findByLoadoutNameOrPlayer_Name(String loadoutName, String playerName);

	@Query("SELECT wl FROM WarframeLoadout wl WHERE wl.warframe.name = :warframeName ORDER BY wl.loadoutName")
	List<WarframeLoadout> findLoadoutsByWarframeOrderedByName(@Param("warframeName") String warframeName);

	@Query("SELECT wl FROM WarframeLoadout wl WHERE wl.warframe.name = :warframeName OR wl.player.name = :playerName ORDER BY wl.loadoutName")
	List<WarframeLoadout> findLoadoutsByWarframeOrPlayer(@Param("warframeName") String warframeName,
			@Param("playerName") String playerName);
}
