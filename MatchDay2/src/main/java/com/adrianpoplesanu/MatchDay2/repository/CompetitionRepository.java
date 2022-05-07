package com.adrianpoplesanu.MatchDay2.repository;

import com.adrianpoplesanu.MatchDay2.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    Competition getCompetitionByName(String name);
    Competition getCompetitionByCode(String code);
}
