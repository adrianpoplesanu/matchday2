package com.adrianpoplesanu.MatchDay2.jobs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component("competitionDownloader")
public class CompetitionDownloader {

    @Value("${download.competitions}")
    private boolean downloadFlag;

    @Scheduled(cron = "0 * * * * *")
    public void downloadCompetitions() throws IOException {
        if (downloadFlag) {
            String timestamp = java.time.LocalDate.now() + " " + java.time.LocalTime.now();
            System.out.println("[Download Competition Cron] run: " + timestamp);
        }
    }
}
