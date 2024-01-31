package com.fantasy.sports.league.controller;

import com.fantasy.sports.league.jpa.dto.DraftSettingsDTO;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.service.DraftSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/draft-settings")
@RequiredArgsConstructor
public class DraftSettingsController {

    private final DraftSettingsService draftSettingsService;

    @PostMapping("/create")
    public ResponseEntity<DraftSettings> createDraftSettings(@RequestBody DraftSettings draftSettings) {
        DraftSettings createdDraftSettings = draftSettingsService.createDraftSettings(draftSettings);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDraftSettings);
    }

    @GetMapping("/league/{leagueId}")
    public ResponseEntity<DraftSettings> getDraftSettingsByLeagueId(@PathVariable Long leagueId) {
        DraftSettings draftSettings = draftSettingsService.getDraftSettingsByLeagueId(leagueId);
        return ResponseEntity.ok(draftSettings);
    }

    @PutMapping("/league/{leagueId}")
    public ResponseEntity<DraftSettings> updateDraftSettingsByLeagueId(
            @PathVariable Long leagueId, @RequestBody DraftSettings draftSettings) {
        DraftSettings updatedDraftSettings = draftSettingsService.updateDraftSettingsByLeagueId(leagueId, draftSettings);
        return ResponseEntity.ok(updatedDraftSettings);
    }

    @DeleteMapping("/league/{leagueId}")
    public ResponseEntity<Void> deleteDraftSettingsByLeagueId(@PathVariable Long leagueId) {
        draftSettingsService.deleteDraftSettingsByLeagueId(leagueId);
        return ResponseEntity.noContent().build();
    }
}
