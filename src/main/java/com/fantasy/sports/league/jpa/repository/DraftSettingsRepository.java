package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.DraftSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DraftSettingsRepository extends JpaRepository<DraftSettings, Long> {

    Optional<DraftSettings> findByLeagueId(Long leagueId);
}
