package com.adrianpoplesanu.MatchDay2.utils.data_initializer;

import com.adrianpoplesanu.MatchDay2.model.Competition;
import com.adrianpoplesanu.MatchDay2.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Value("${populate.database.initial.data:false}")
    private boolean populateInitialData;

    @Autowired
    private CompetitionService competitionService;

    @Override
    public void run(String... args) throws Exception {
        if (populateInitialData) {
            System.out.println("MAKING INITIAL DATABASE INSERTIONS");
            Competition competition = competitionService.getCompetitionByName("Premier League");
            if (competition == null) {
                competition = new Competition();
                competition.setName("Premier League");
                competition.setCode("PL");
                competition.setActive("ACTIVE");
                competition.setExternalId("?");
                competitionService.insert(competition);
            }
            System.out.println("done MAKING DATABASE INSERTIONS");
        } else {
            System.out.println("skipping data initial insertions");
        }
    }
}
