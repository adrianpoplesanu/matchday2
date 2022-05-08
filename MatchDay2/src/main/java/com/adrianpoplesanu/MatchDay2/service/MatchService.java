package com.adrianpoplesanu.MatchDay2.service;

import com.adrianpoplesanu.MatchDay2.model.Competition;
import com.adrianpoplesanu.MatchDay2.model.Match;
import com.adrianpoplesanu.MatchDay2.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match getMatchByCompetitionAndTeams(String competitionId, String homeTeam, String awayTeam) {
        return matchRepository.findByCompetitionCodeAndHomeTeamAndAwayTeam(competitionId, homeTeam, awayTeam).get(0);
    }

    public List<Match> getMatchesByCompetition(String competitionId) {
        return matchRepository.findByCompetitionCode(competitionId);
    }
    
    public void addMatches(com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match[] matches, Competition competition) {
        List<com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match> allMatches = Arrays.stream(matches).collect(Collectors.toList());
        //matchRepository.saveAll(allMatches); // this is an issue with duplicates
        allMatches.forEach(m -> {
            Match match = getMatchByCompetitionAndTeams(competition.getCode(), m.getHomeTeam().getName(), m.getAwayTeam().getName());
            if (match == null) {
                //... insert
            } else {
                //... update
            }
        });
    }
}
