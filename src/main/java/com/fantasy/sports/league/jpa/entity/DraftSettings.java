package com.fantasy.sports.league.jpa.entity;

import com.fantasy.sports.league.jpa.enums.DraftType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class DraftSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    private Long leagueId;

    @Enumerated(EnumType.STRING)
    @Column(name = "draft_type")
    private DraftType draftType;

    private String draftDate;

    private String draftTime;

    private Integer secondsPerPick;

    private Boolean draftPickTrading;

    private Boolean draftReady;
}
