package com.fantasy.sports.league.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class DraftSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    private Long leagueId;
    private String draftType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate draftDate;

    private Integer secondsPerPick;
}
