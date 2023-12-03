package com.fantasy.sports.league.jpa.repository;

import com.fantasy.sports.league.jpa.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository <League, Long >{

}
