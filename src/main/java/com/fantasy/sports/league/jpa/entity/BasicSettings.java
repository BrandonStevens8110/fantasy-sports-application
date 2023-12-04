package com.fantasy.sports.league.jpa.entity;

import com.fantasy.sports.league.model.ScoringType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class BasicSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    private Long leagueId;
    private String leagueName;
    private String numberOfTeams;
    private ScoringType scoringType;

}