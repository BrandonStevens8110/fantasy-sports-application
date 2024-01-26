package com.fantasy.sports.league.jpa.dto;

import com.fantasy.sports.league.jpa.enums.ScoringType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class BasicSettingsDTO {


    private Long id;
    private Long leagueId;
    private String leagueName;
    private String numberOfTeams;
    private ScoringType scoringType;
}
