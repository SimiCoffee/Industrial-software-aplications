package ug.proj.warframe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ug.proj.warframe.domain.WarframeItem;

@Repository
public interface WarframeItemRepository extends JpaRepository<WarframeItem, Long> {

	List<WarframeItem> findByName(String name);

	List<WarframeItem> findByHealthAndShields(int health, int shields);

	List<WarframeItem> findByHealthOrArmor(int health, int armor);

	@Query("SELECT w FROM WarframeItem w WHERE w.health BETWEEN :minHealth AND :maxHealth")
	List<WarframeItem> findWarframesWithHealthBetween(@Param("minHealth") int minHealth,
			@Param("maxHealth") int maxHealth);

	@Query("SELECT w FROM WarframeItem w WHERE w.health > 500 OR w.armor > 400")
	List<WarframeItem> findWarframesWithHighHealthOrArmor();
}
