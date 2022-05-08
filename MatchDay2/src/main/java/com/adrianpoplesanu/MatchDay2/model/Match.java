package com.adrianpoplesanu.MatchDay2.model;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "matchid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "externalid")
    private String externalId;

    @Column(name = "competitioncode")
    private String competitionCode;

    @Column(name = "hometeam")
    private String homeTeam;

    @Column(name = "awayteam")
    private String awayTeam;

    @Column(name = "status")
    private String status;

    @Column(name = "homescore")
    private String homeScore;

    @Column(name = "awayscore")
    private String awayScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getCompetitionCode() {
        return competitionCode;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }
}
