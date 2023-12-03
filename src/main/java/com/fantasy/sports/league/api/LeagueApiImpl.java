package com.fantasy.sports.league.api;

import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.model.LeagueDTO;
import com.fantasy.sports.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
        return LeagueApiDelegate.super.deleteLeagueById(id);
    }

    @Override
    public ResponseEntity<LeagueDTO> getLeagueById(Long id) {
        return LeagueApiDelegate.super.getLeagueById(id);
    }

    @Override
    public ResponseEntity<LeagueDTO> updateLeagueById(Long id, LeagueDTO leagueDTO) {
        return LeagueApiDelegate.super.updateLeagueById(id, leagueDTO);
    }
}
