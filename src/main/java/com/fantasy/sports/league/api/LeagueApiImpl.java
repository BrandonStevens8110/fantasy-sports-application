package com.fantasy.sports.league.api;

import com.fantasy.sports.league.model.LeagueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeagueApiImpl implements LeagueApiDelegate{
    @Override
    public ResponseEntity<LeagueDTO> createLeague(LeagueDTO leagueDTO) {
        return LeagueApiDelegate.super.createLeague(leagueDTO);
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
