package com.adrianpoplesanu.MatchDay2.utils.cronjobs;

import com.adrianpoplesanu.MatchDay2.service.CompetitionService;
import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.FootballDataApiClient;
import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("competitionsDownloaderClient")
public class CompetitionsDownloaderClient {
    @Autowired
    private FootballDataApiClient footballDataApiClient;

    @Autowired
    private CompetitionService competitionService;

    public void downloadPLCompetitionMatches() {
        competitionService.getAllCompetitions()
                .stream()
                .filter(competition -> {
                    return "ACTIVE".equals(competition.getActive());
                }).forEach(competition -> {
                    System.out.println("Downloading competition: " + competition.getName());
                });
        Match[] matches = footballDataApiClient.getMatchesForCompetition("PL");
        System.out.println(matches);
    }
}
