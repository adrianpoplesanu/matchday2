package com.adrianpoplesanu.MatchDay2.utils.convertion;

import com.adrianpoplesanu.MatchDay2.model.Match;

public class ConvertionUtils {
    public static Match toMatch(com.adrianpoplesanu.MatchDay2.utils.footbal_data_api.model.Match api_match) {
        Match match = new Match();
        match.setHomeTeam(api_match.getHomeTeam().getName());
        match.setAwayTeam(api_match.getAwayTeam().getName());
        match.setStatus(api_match.getStatus());
        match.setHomeScore(String.valueOf(api_match.getScore().getFullTime().getHomeTeam()));
        match.setAwayScore(String.valueOf(api_match.getScore().getFullTime().getAwayTeam()));
        return match;
    }
}
