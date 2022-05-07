package com.adrianpoplesanu.MatchDay2.cronjobs;

import com.adrianpoplesanu.MatchDay2.utils.cronjobs.CompetitionsDownloaderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("cronjobManager")
public class CronjobManager {

    @Value("${download.competitions}")
    private boolean downloadFlag;

    @Autowired
    private CompetitionsDownloaderClient competitionsDownloaderClient;

    @Scheduled(cron = "0 * * * * *")
    public void downloadCompetitions() throws IOException {
        if (downloadFlag) {
            String timestamp = java.time.LocalDate.now() + " " + java.time.LocalTime.now();
            competitionsDownloaderClient.downloadPLCompetitionMatches();
            System.out.println("[Download Competition Cron] run: " + timestamp);
        }
    }
}
