package ug.proj.warframe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ug.proj.warframe.domain.WarframeItem;

@Repository
public interface WarframeItemRepository extends JpaRepository<WarframeItem, Long> {

	List<WarframeItem> findByName(String name);
}
