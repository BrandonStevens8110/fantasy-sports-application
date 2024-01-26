package com.fantasy.sports.league.controller;

import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final ModelMapper modelMapper;
    private final LeagueService leagueService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<League> createLeague(@RequestBody League league) {
  //      TODO fix mapper issue
//        League leagueToCreate = modelMapper.map(League, League.class);
//
//        League createdLeague = leagueService.createLeague(leagueToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(leagueService.createLeague(league));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        League league = leagueService.getLeagueById(id);

        return ResponseEntity.ok(modelMapper.map(league, LeagueDTO.class));
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLeagueById(@PathVariable Long id) {
//        leagueService.deleteLeague(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    @PutMapping("/{id}")
//    @ResponseBody
//    public ResponseEntity<LeagueDTO> updateLeagueById(@PathVariable Long id,@RequestBody LeagueDTO leagueDTO) {
//
//
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(modelMapper.map());
//    }



}
