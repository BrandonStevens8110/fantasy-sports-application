package com.fantasy.sports.utils;

import com.fantasy.sports.league.jpa.dto.BasicSettingsDTO;
import com.fantasy.sports.league.jpa.dto.DraftSettingsDTO;
import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.dto.RosterSettingsDTO;
import com.fantasy.sports.league.jpa.entity.BasicSettings;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.entity.RosterSettings;
import com.fantasy.sports.league.jpa.enums.DraftType;
import com.fantasy.sports.league.jpa.enums.ScoringType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class MockData {
    public static BasicSettings createBasicSettings() {
        return BasicSettings.builder()
                .leagueName("Mock League")
                .numberOfTeams(8)
                .scoringType(ScoringType.STANDARD)
                .build();
    }

    public static DraftSettings createMockDraftSettings() {
        return DraftSettings.builder()
                .draftType(DraftType.SNAKE)
                .draftDate(LocalDate.now().toString())
                .draftTime(LocalDateTime.now().toString())
                .secondsPerPick(60)
                .build();
    }

    public static League createLeague() {
        return League.builder()
                .uuid(UUID.randomUUID())
                .basicSettings(createBasicSettings())
                .draftSettings(createMockDraftSettings())
                .rosterSettings(createRosterSettings())
                .build();
    }

    public static RosterSettings createRosterSettings() {
        return RosterSettings.builder()
                .leagueId(1L)
                .rosterSize(10)
                .numberOfStarters(8)
                .numberOfBench(2)
                .build();
    }

    public static BasicSettingsDTO createMockBasicSettingsDTO() {
        return BasicSettingsDTO.builder()
                .leagueName("Mock League")
                .numberOfTeams("8")
                .scoringType(ScoringType.STANDARD)
                .build();
    }

    public static DraftSettingsDTO createMockDraftSettingsDTO() {
        return DraftSettingsDTO.builder()
                .draftType(DraftType.AUCTION)
                .draftDate(LocalDate.now().toString())
                .draftTime(LocalDateTime.now().toString())

                .secondsPerPick(60)
                .build();
    }

    public static LeagueDTO createLeagueDTO() {
        return LeagueDTO.builder()
                .basicSettingDTO(createMockBasicSettingsDTO())
                .draftSettingsDTO(createMockDraftSettingsDTO())
                .rosterSettingsDTO(createMockRosterSettingsDTO())
                .build();
    }

    public static RosterSettingsDTO createMockRosterSettingsDTO() {
        return RosterSettingsDTO.builder()
                .rosterSize(10)
                .numberOfStarters(8)
                .numberOfBench(2)
                .build();
    }
}
