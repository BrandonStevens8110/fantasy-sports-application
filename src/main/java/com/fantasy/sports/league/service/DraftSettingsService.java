package com.fantasy.sports.league.service;

import com.fantasy.sports.exception.NotFoundException;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.repository.DraftSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DraftSettingsService {

    private final DraftSettingsRepository draftSettingsRepository;

    public DraftSettings createDraftSettings(DraftSettings draftSettings) {
        return draftSettingsRepository.save(draftSettings);
    }

    public DraftSettings getDraftSettingsByLeagueId(Long leagueId) {
        return draftSettingsRepository.findByLeagueId(leagueId)
                .orElseThrow(() -> new NotFoundException("DraftSettings not found for leagueId: " + leagueId));
    }

    public DraftSettings updateDraftSettingsByLeagueId(Long leagueId, DraftSettings draftSettings) {
        getDraftSettingsByLeagueId(leagueId);
        draftSettings.setLeagueId(leagueId);
        return draftSettingsRepository.save(draftSettings);
    }

    public void deleteDraftSettingsByLeagueId(Long leagueId) {
        DraftSettings existingDraftSettings = getDraftSettingsByLeagueId(leagueId);
        draftSettingsRepository.delete(existingDraftSettings);
    }
}
