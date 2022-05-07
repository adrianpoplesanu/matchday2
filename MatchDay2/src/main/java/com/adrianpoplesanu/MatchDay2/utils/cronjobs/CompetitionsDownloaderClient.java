package com.adrianpoplesanu.MatchDay2.utils.cronjobs;

import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.FootballDataApiClient;
import com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("competitionsDownloaderClient")
public class CompetitionsDownloaderClient {
    @Autowired
    private FootballDataApiClient footballDataApiClient;

    public void downloadPLCompetitionMatches() {
        Match[] matches = footballDataApiClient.getMatchesForCompetition("PL");
        System.out.println(matches);
    }
}
