package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.DraftSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftSettingsRepository extends JpaRepository<DraftSettings, Long> {

}
