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
@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BasicSettings basicSettings;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DraftSettings draftSettings;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private RosterSettings rosterSettings;
}
