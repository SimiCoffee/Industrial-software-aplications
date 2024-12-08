package ug.proj.warframe.domain;

import jakarta.persistence.*;

@Entity
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int masteryRank;
    private long experience;
    private String clan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMasteryRank() {
        return masteryRank;
    }

    public void setMasteryRank(int masteryRank) {
        this.masteryRank = masteryRank;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }
}
