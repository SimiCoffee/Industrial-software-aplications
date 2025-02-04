package ug.proj.warframe.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class WarframeLoadout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Warframe name cannot be blank")
    private String loadoutName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warframe_id")
    private WarframeItem warframe;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "warframe_loadout_skills", joinColumns = @JoinColumn(name = "warframe_loadout_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

    public WarframeLoadout() {
    }

    public WarframeLoadout(String loadoutName, WarframeItem warframe, Set<Skill> skills, Player player) {
        this.loadoutName = loadoutName;
        this.warframe = warframe;
        this.skills = skills;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLoadoutName() {
        return loadoutName;
    }

    public void setLoadoutName(String loadoutName) {
        this.loadoutName = loadoutName;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public WarframeItem getWarframe() {
        return this.warframe;
    }

    public void setWarframe(WarframeItem warframe) {
        this.warframe = warframe;
    }

}
