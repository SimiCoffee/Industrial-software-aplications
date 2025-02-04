package ug.proj.warframe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ug.proj.warframe.domain.WarframeLoadout;

@Repository
public interface WarframeLoadoutRepository extends JpaRepository<WarframeLoadout, Long> {

	List<WarframeLoadout> findByPlayerId(Long playerId);
}
