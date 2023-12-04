package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.BasicSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicSettingsRepository extends JpaRepository<BasicSettings, Long> {
}
