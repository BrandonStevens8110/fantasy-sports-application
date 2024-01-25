package com.fantasy.sports.league.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToOne
    private BasicSettings basicSettings;

    @OneToOne
    private DraftSettings draftSettings;

    @OneToOne
    private RosterSettings rosterSettings;
}
