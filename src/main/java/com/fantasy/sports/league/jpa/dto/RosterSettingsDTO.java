package com.fantasy.sports.league.jpa.dto;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class RosterSettingsDTO {

    private Long id;

    private Long leagueId;
    private Integer rosterSize;
    private Integer numberOfStarters;
    private Integer numberOfBench;
}
