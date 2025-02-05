package ug.proj.warframe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int missionsCompleted;
    private int missionsFailed;
    private int missionsQuit;
    private int timePlayed; // In minutes
    private long grossIncome; // In credits

    public PlayerStatistics() {
    }

    public PlayerStatistics(int missionsCompleted, int missionsFailed, int missionsQuit, int timePlayed,
            long grossIncome) {
        this.missionsCompleted = missionsCompleted;
        this.missionsFailed = missionsFailed;
        this.missionsQuit = missionsQuit;
        this.timePlayed = timePlayed;
        this.grossIncome = grossIncome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMissionsCompleted() {
        return missionsCompleted;
    }

    public void setMissionsCompleted(int missionsCompleted) {
        this.missionsCompleted = missionsCompleted;
    }

    public int getMissionsFailed() {
        return missionsFailed;
    }

    public void setMissionsFailed(int missionsFailed) {
        this.missionsFailed = missionsFailed;
    }

    public int getMissionsQuit() {
        return missionsQuit;
    }

    public void setMissionsQuit(int missionsQuit) {
        this.missionsQuit = missionsQuit;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public long getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(long grossIncome) {
        this.grossIncome = grossIncome;
    }
}
