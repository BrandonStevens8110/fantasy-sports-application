package com.fantasy.sports.league.service;

import com.fantasy.sports.Exception.InvalidDataException;
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

        buildDefaultLeagueSettings(league);

        return leagueRepository.save(league);
    }

    public void deleteLeague(League league) {
        //verify league doesn't exist
        Boolean exist = leagueExistById(league.getId());

        if (exist) {
            throw new InvalidDataException("League");
        }

        leagueRepository.delete(league);
    }

    private League buildDefaultLeagueSettings(League league) {

        BasicSettings basicSettings = BasicSettings
                .builder()
                .leagueId(league.getId())
                .leagueName(league.getBasicSettings().getLeagueName())
                .numberOfTeams(league.getBasicSettings().getNumberOfTeams())
                .scoringType(league.getBasicSettings().getScoringType())
                .build();

        DraftSettings draftSettings = DraftSettings
                .builder()
                .leagueId(league.getId())
                .secondsPerPick(league.getDraftSettings().getSecondsPerPick())
                .draftType(league.getDraftSettings().getDraftType())
                .draftDate(league.getDraftSettings().getDraftDate())
                .build();

        RosterSettings rosterSettings = RosterSettings
                .builder()
                .leagueId(league.getId())
                .rosterSize(league.getRosterSettings().getRosterSize())
                .build();

        basicSettingsRepository.save(basicSettings);
        draftSettingsRepository.save(draftSettings);
        rosterSettingsRepository.save(rosterSettings);

        league.setBasicSettings(basicSettings);
        league.setDraftSettings(draftSettings);
        league.setRosterSettings(rosterSettings);

        return league;
    }

    private Boolean leagueExistById (long id) {

        return leagueRepository.existsById(id);
    }
}
