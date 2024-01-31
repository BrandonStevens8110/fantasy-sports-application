package com.fantasy.sports.league.controller;

import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.enums.ScoringType;
import com.fantasy.sports.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final ModelMapper modelMapper;
    private final LeagueService leagueService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity<LeagueDTO> createLeagueTest(@RequestBody LeagueDTO leagueDTO) {

        League leagueToCreate = modelMapper.map(leagueDTO, League.class);

        League createdLeague = leagueService.createLeague(leagueToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(createdLeague, LeagueDTO.class));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        League league = leagueService.getLeagueById(id);

        return ResponseEntity.ok(modelMapper.map(league, LeagueDTO.class));
    }

    @GetMapping("/filterLeagues")
    @ResponseBody
    public ResponseEntity<List<LeagueDTO>> filterLeagues(
            @RequestParam(required = false) String leagueName,
            @RequestParam(required = false) Integer numberOfTeams,
            @RequestParam(required = false) Integer rosterSize,
            @RequestParam(required = false) Integer numberOfStarters,
            @RequestParam(required = false) Integer numberOfBench,
            @RequestParam(required = false) ScoringType scoringType) {

        List<League> filteredLeagues = leagueService.filterLeagues(
                leagueName, numberOfTeams, rosterSize, numberOfStarters, numberOfBench, scoringType);

        return ResponseEntity.ok(filteredLeagues.stream()
                .map(league -> modelMapper.map(league, LeagueDTO.class))
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LeagueDTO> updateLeagueById(@PathVariable Long id,@RequestBody LeagueDTO leagueDTO) {

        League leagueToUpdate = modelMapper.map(leagueDTO, League.class);

        League league = leagueService.updateLeague(id,leagueToUpdate);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(modelMapper.map(league, LeagueDTO.class));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteLeagueById(@PathVariable Long id) {

        leagueService.deleteLeague(id);


        return ResponseEntity.noContent().build();
    }






}
