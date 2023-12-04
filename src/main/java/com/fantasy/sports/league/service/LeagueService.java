package com.fantasy.sports.league.service;

import com.fantasy.sports.Exception.InvalidDataException;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public League createLeague(League league) {


        return leagueRepository.save(league);
    }

    public void deleteLeague(League league) {
        //verify league doesn't exist
        Boolean exist = leagueExistById(league.getId());

        if (exist) {
            throw new InvalidDataException("League");
        }

        leagueRepository.delete(league);
    }

    private Boolean leagueExistById (long id) {

        return leagueRepository.existsById(id);
    }
}
