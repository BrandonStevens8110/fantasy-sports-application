package com.fantasy.sports.league.jpa.dto;


import com.fantasy.sports.league.jpa.enums.DraftType;
import lombok.*;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DraftSettingsDTO {

    private Long id;

    private Long leagueId;

    private DraftType draftType;

    private String draftDate;

    private String draftTime;

    private Integer secondsPerPick;

    private Boolean draftPickTrading;

    private Boolean draftReady;
}
