package com.fantasy.sports.league.service;

import com.fantasy.sports.exception.NotFoundException;
import com.fantasy.sports.league.jpa.entity.BasicSettings;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.entity.RosterSettings;
import com.fantasy.sports.league.jpa.repository.BasicSettingsRepository;
import com.fantasy.sports.league.jpa.repository.DraftSettingsRepository;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import com.fantasy.sports.league.jpa.repository.RosterSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final BasicSettingsRepository basicSettingsRepository;
    private final DraftSettingsRepository draftSettingsRepository;
    private final RosterSettingsRepository rosterSettingsRepository;

    public League createLeague(League league) {
        League savedLeague = leagueRepository.save(league);

        BasicSettings basicSettings = BasicSettings.builder()
                .leagueId(savedLeague.getId())
                .scoringType(league.getBasicSettings().getScoringType())
                .leagueName(league.getBasicSettings().getLeagueName())
                .numberOfTeams(league.getBasicSettings().getNumberOfTeams())
                .build();
        BasicSettings savedBasicSettings = basicSettingsRepository.save(basicSettings);

        DraftSettings draftSettings = DraftSettings.builder()
                .leagueId(savedLeague.getId())
                .draftTime(league.getDraftSettings().getDraftTime())
                .draftDate(league.getDraftSettings().getDraftDate())
                .secondsPerPick(league.getDraftSettings().getSecondsPerPick())
                .draftReady(league.getDraftSettings().getDraftReady())
                .draftPickTrading(league.getDraftSettings().getDraftPickTrading())
                .build();
        DraftSettings savedDraftSettings = draftSettingsRepository.save(draftSettings);

        RosterSettings rosterSettings = RosterSettings.builder()
                .leagueId(savedLeague.getId())
                .numberOfStarters(league.getRosterSettings().getNumberOfStarters())
                .numberOfBench(league.getRosterSettings().getNumberOfBench())
                .rosterSize(league.getRosterSettings().getRosterSize() + league.getRosterSettings().getNumberOfStarters())
                .build();
        RosterSettings savedRosterSettings = rosterSettingsRepository.save(rosterSettings);

        savedLeague.setBasicSettings(savedBasicSettings);
        savedLeague.setDraftSettings(savedDraftSettings);
        savedLeague.setRosterSettings(savedRosterSettings);

        return savedLeague;
    }

    public void deleteLeague(Long id) {

        leagueRepository.deleteById(id);
    }

    public League getLeagueById(Long id) {
        return leagueRepository.getLeagueById(id)
                .orElseThrow(() -> new NotFoundException("League with Id" + id));
    }
}
