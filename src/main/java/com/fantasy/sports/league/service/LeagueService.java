package com.fantasy.sports.league.service;

import com.fantasy.sports.exception.NotFoundException;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.enums.ScoringType;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public League createLeague(League league) {
        League savedLeague = leagueRepository.save(league);

        return savedLeague;
    }

    public void deleteLeague(Long id) {
        getLeagueById(id); //verify league exists
        leagueRepository.deleteById(id);
    }


    public League getLeagueById(Long id) {
        return leagueRepository.getLeagueById(id)
                .orElseThrow(() -> new NotFoundException("League with Id" + id));
    }

    public List<League> filterLeagues(
            String leagueName, Integer numberOfTeams, Integer rosterSize,
            Integer numberOfStarters, Integer numberOfBench, ScoringType scoringType) {

        return leagueRepository.findByParams(
                leagueName, numberOfTeams, rosterSize, numberOfStarters, numberOfBench, scoringType);
    }

    public League updateLeague(Long id, League league) {
            League existingLeague = getLeagueById(id);

        existingLeague = League.builder()
                .id(existingLeague.getId())
                .uuid(existingLeague.getUuid())
                .leagueName(league.getLeagueName())
                .numberOfTeams(league.getNumberOfTeams())
                .rosterSize(league.getRosterSize())
                .numberOfStarters(league.getNumberOfStarters())
                .numberOfBench(league.getNumberOfBench())
                .scoringType(league.getScoringType())
                .build();

            return leagueRepository.save(existingLeague);

    }
}
