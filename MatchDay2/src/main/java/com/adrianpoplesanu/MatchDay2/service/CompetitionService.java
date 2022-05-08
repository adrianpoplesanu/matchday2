package com.adrianpoplesanu.MatchDay2.service;

import com.adrianpoplesanu.MatchDay2.model.Competition;
import com.adrianpoplesanu.MatchDay2.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;

    public Competition getCompetitionByName(String name) {
        return competitionRepository.getCompetitionByName(name);
    }

    public Competition getCompetitionByCode(String code) {
        return competitionRepository.getCompetitionByCode(code);
    }

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public void insert(Competition competition) {
        competitionRepository.save(competition);
    }
}
