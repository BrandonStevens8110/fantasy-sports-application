package com.fantasy.sports.league.jpa.entity;

import com.fantasy.sports.league.model.ScoringType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

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
    private Integer secondsPerPick = 90;
}
