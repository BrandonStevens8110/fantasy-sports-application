package com.fantasy.sports.league.api;

import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.model.LeagueDTO;
import com.fantasy.sports.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeagueApiImpl implements LeagueApiDelegate{

    private final ModelMapper modelMapper;
    private final LeagueService leagueService;
    @Override
    public ResponseEntity<LeagueDTO> createLeague(LeagueDTO leagueDTO) {
        League leagueToCreate = modelMapper.map(leagueDTO, League.class);

        League createdLeague = leagueService.createLeague(leagueToCreate);

        return ResponseEntity.ok(modelMapper.map(createdLeague, LeagueDTO.class));
    }

    @Override
    public ResponseEntity<Void> deleteLeagueById(Long id) {
        leagueService.deleteLeague(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<LeagueDTO> getLeagueById(Long id) {
        League league = leagueService.getLeagueById(id);

        return ResponseEntity.ok(modelMapper.map(league, LeagueDTO.class));
    }
}
