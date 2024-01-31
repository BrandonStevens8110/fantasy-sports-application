package com.fantasy.sports.league.jpa.dto;

import com.fantasy.sports.league.jpa.enums.ScoringType;
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

    private String leagueName;
    private Integer numberOfTeams;
    private Integer rosterSize;
    private Integer numberOfStarters;
    private Integer numberOfBench;
    private ScoringType scoringType;
}
