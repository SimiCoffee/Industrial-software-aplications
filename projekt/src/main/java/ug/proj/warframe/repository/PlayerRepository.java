package ug.proj.warframe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ug.proj.warframe.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByName(String name);

	List<Player> findByNameAndProfile_MasteryRank(String name, int masteryRank);

	List<Player> findByNameOrProfile_Clan(String name, String clan);

	@Query("SELECT p FROM Player p WHERE p.profile.masteryRank > :rank AND p.statistics.grossIncome > :income")
	List<Player> findPlayersByMasteryRankAndIncome(@Param("rank") int masteryRank,
			@Param("income") long grossIncome);

	@Query("SELECT p FROM Player p WHERE p.profile.masteryRank > :rank OR p.statistics.grossIncome > :income")
	List<Player> findPlayersByMasteryRankOrIncome(@Param("rank") int masteryRank,
			@Param("income") long grossIncome);

	@Query(value = "SELECT p.id AS player_id, p.name, pp.id AS profile_id, pp.mastery_rank, pp.experience, pp.clan "
			+
			"FROM player p " +
			"JOIN player_profile pp ON p.profile_id = pp.id " +
			"WHERE pp.mastery_rank > :rank", nativeQuery = true)
	List<Object[]> findPlayersByNativeMasteryRank(@Param("rank") int rank);
}
