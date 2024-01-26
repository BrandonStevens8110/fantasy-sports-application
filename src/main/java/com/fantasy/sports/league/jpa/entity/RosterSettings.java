package com.fantasy.sports.league.jpa.entity;

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
public class RosterSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;
    private Long leagueId;
    private Integer rosterSize;
    private Integer numberOfStarters;
    private Integer numberOfBench;
}
