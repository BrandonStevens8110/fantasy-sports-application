package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.enums.ScoringType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository <League, Long > {

    Optional<League> getLeagueById(Long id);

    @Query("""
            SELECT l FROM League l WHERE \s
                        (:leagueName IS NULL OR l.leagueName = :leagueName) AND \s
                        (:numberOfTeams IS NULL OR l.numberOfTeams = :numberOfTeams) AND \s
                        (:rosterSize IS NULL OR l.rosterSize = :rosterSize) AND \s
                        (:numberOfStarters IS NULL OR l.numberOfStarters = :numberOfStarters) AND \s
                        (:numberOfBench IS NULL OR l.numberOfBench = :numberOfBench) AND \s
                        (:scoringType IS NULL OR l.scoringType = :scoringType)
                        )
            """)
    List<League> findByParams(String leagueName, Integer numberOfTeams, Integer rosterSize, Integer numberOfStarters, Integer numberOfBench, ScoringType scoringType);
}
