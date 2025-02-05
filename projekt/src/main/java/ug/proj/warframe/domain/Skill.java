package ug.proj.warframe.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Skill name cannot be blank")
	private String name;

	@NotBlank(message = "Skill description cannot be blank")
	private String description;

	@ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	@Builder.Default
	private Set<WarframeLoadout> warframeLoadouts = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Skill skill = (Skill) o;
		return Objects.equals(id, skill.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
