package ug.proj.warframe.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import ug.proj.warframe.domain.WarframeLoadout;

public class WarframeLoadoutSpecification {

	public static Specification<WarframeLoadout> filterByCriteria(
			String warframeName, String playerName, Integer minHealth, Integer maxHealth, Integer armor) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (warframeName != null && !warframeName.isEmpty()) {
				predicates.add(criteriaBuilder.like(
						criteriaBuilder.lower(root.get("warframe").get("name")),
						"%" + warframeName.toLowerCase() + "%"));
			}

			if (playerName != null && !playerName.isEmpty()) {
				predicates.add(criteriaBuilder.like(
						criteriaBuilder.lower(root.get("player").get("name")),
						"%" + playerName.toLowerCase() + "%"));
			}

			if (minHealth != null) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("warframe").get("health"),
						minHealth));
			}
			if (maxHealth != null) {
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("warframe").get("health"),
						maxHealth));
			}

			if (armor != null) {
				predicates.add(criteriaBuilder.equal(root.get("warframe").get("armor"), armor));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
