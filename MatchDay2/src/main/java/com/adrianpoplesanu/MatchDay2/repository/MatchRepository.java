package com.adrianpoplesanu.MatchDay2.repository;

import com.adrianpoplesanu.MatchDay2.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Match findByCompetitionCodeAndHomeTeamAndAwayTeam(String competitionCode, String homeTeam, String awayTeam);
    List<Match> findByCompetitionCode(String competitionCode);
}
