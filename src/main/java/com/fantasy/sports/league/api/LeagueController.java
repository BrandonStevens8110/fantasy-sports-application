package com.fantasy.sports.league.api;

import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.model.LeagueDTO;
import com.fantasy.sports.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leagues-new")
@RequiredArgsConstructor
public class LeagueController {

    private final ModelMapper modelMapper;
    private final LeagueService leagueService;

    @PostMapping
    public ResponseEntity<LeagueDTO> createLeague(LeagueDTO leagueDTO) {

        League leagueToCreate = modelMapper.map(leagueDTO, League.class);

        League createdLeague = leagueService.createLeague(leagueToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(createdLeague, LeagueDTO.class));
    }

}
