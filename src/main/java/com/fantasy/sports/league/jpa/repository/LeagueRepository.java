package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository <League, Long > {

    Optional<League> getLeagueById(Long id);

}
