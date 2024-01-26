package com.fantasy.sports.league.jpa.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class LeagueDTO {

    private Long id;

    private UUID uuid;

    private BasicSettingsDTO basicSettingDTO;

    private DraftSettingsDTO draftSettingsDTO;

    private RosterSettingsDTO rosterSettingsDTO;
}
