package com.fantasy.sports.utils;

import com.fantasy.sports.league.jpa.entity.BasicSettings;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.entity.RosterSettings;
import com.fantasy.sports.league.model.*;

import java.time.LocalDate;
import java.util.UUID;

public class MockData {
    public static BasicSettings createMockBasicSettings() {
        return BasicSettings.builder()
                .leagueId(1L)
                .leagueName("Mock League")
                .numberOfTeams("8")
                .scoringType(ScoringType.STANDARD)
                .build();
    }

    public static DraftSettings createMockDraftSettings() {
        return DraftSettings.builder()
                .leagueId(1L)
                .draftType("Mock Draft")
                .draftDate(LocalDate.now())
                .secondsPerPick(60)
                .build();
    }

    public static League createLeague() {
        return League.builder()
                .id(1L)
                .uuid(UUID.randomUUID())
                .basicSettings(createMockBasicSettings())
                .draftSettings(createMockDraftSettings())
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
                .draftType("Mock Draft")
                .draftDate(LocalDate.now())
                .secondsPerPick(60)
                .build();
    }

    public static LeagueDTO createLeagueDTO() {
        return LeagueDTO.builder()
                .uuid(UUID.randomUUID())
                .basicSettingDTO(createMockBasicSettingsDTO())
                .draftSettingsDTO(createMockDraftSettingsDTO())
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
