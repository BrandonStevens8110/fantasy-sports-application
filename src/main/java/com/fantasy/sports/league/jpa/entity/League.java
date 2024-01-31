package com.fantasy.sports.league.jpa.entity;

import com.fantasy.sports.league.jpa.enums.ScoringType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String leagueName;
    private Integer numberOfTeams;
    private Integer rosterSize;
    private Integer numberOfStarters;
    private Integer numberOfBench;

    @Enumerated(EnumType.STRING)
    @Column(name = "scoring_type")
    private ScoringType scoringType;
}
