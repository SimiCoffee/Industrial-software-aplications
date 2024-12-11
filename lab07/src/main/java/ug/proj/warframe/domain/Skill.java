package ug.proj.warframe.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Skill name cannot be blank")
    private String name;

    @NotBlank(message = "Skill description cannot be blank")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<WarframeItem> warframes;

    @ManyToMany(mappedBy = "skills")
    private Set<WarframeLoadout> warframeLoadouts = new HashSet<>();

    public Skill() {
    }

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WarframeItem> getWarframes() {
        return warframes;
    }

    public void setWarframes(List<WarframeItem> warframes) {
        this.warframes = warframes;
    }

    public Set<WarframeLoadout> getWarframeLoadouts() {
        return warframeLoadouts;
    }

    public void setWarframeLoadouts(Set<WarframeLoadout> warframeLoadouts) {
        this.warframeLoadouts = warframeLoadouts;
    }
}
