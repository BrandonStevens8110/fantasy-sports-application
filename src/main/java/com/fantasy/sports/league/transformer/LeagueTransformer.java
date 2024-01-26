package com.fantasy.sports.league.transformer;

import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.transformer.Transformer;
import org.springframework.stereotype.Component;


@Component
public class LeagueTransformer implements Transformer<LeagueDTO, League > {

    @Override
    public League convertToEntity(LeagueDTO dto) {
        League league = new League();
        league.setId(dto.getId());


        return league;
    }

    @Override
    public LeagueDTO convertToDTO(League entity) {
        LeagueDTO leagueDTO = new LeagueDTO();

        return leagueDTO;
    }
}
