package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.RosterSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RosterSettingsRepository extends JpaRepository<RosterSettings, Long> {
}
