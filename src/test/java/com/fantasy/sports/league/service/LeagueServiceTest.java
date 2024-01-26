package com.fantasy.sports.league.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.fantasy.sports.league.jpa.entity.BasicSettings;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.entity.RosterSettings;
import com.fantasy.sports.league.jpa.repository.BasicSettingsRepository;
import com.fantasy.sports.league.jpa.repository.DraftSettingsRepository;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import com.fantasy.sports.league.jpa.repository.RosterSettingsRepository;
import com.fantasy.sports.utils.MockData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LeagueServiceTest {

    @Mock
    private LeagueRepository leagueRepository;

    @Mock
    private BasicSettingsRepository basicSettingsRepository;

    @Mock
    private DraftSettingsRepository draftSettingsRepository;

    @Mock
    private RosterSettingsRepository rosterSettingsRepository;

    @InjectMocks
    private LeagueService leagueService;

    @Test
    void testCreateLeague() {
        // Mock data
        League league = new League();
        BasicSettings basicSettings = BasicSettings.builder().build();
        DraftSettings draftSettings = DraftSettings.builder().build();
        RosterSettings rosterSettings = RosterSettings.builder().build();

        // Mock repository save methods
        when(leagueRepository.save(league)).thenReturn(league);
        when(basicSettingsRepository.save(any(BasicSettings.class))).thenReturn(basicSettings);
        when(draftSettingsRepository.save(any(DraftSettings.class))).thenReturn(draftSettings);
        when(rosterSettingsRepository.save(any(RosterSettings.class))).thenReturn(rosterSettings);

        // Call the method
        League resultLeague = leagueService.createLeague(league);

        // Verify repository save method's
        verify(leagueRepository, times(1)).save(league);
        verify(basicSettingsRepository, times(1)).save(any(BasicSettings.class));
        verify(draftSettingsRepository, times(1)).save(any(DraftSettings.class));
        verify(rosterSettingsRepository, times(1)).save(any(RosterSettings.class));

        // Assertions using AssertJ
        assertThat(resultLeague).isNotNull();
        assertThat(resultLeague.getBasicSettings()).isNotNull();
        assertThat(resultLeague.getDraftSettings()).isNotNull();
        assertThat(resultLeague.getRosterSettings()).isNotNull();

        // Assert that leagueId is the same for all entities
        assertThat(resultLeague.getId()).isEqualTo(resultLeague.getBasicSettings().getLeagueId());
        assertThat(resultLeague.getId()).isEqualTo(resultLeague.getDraftSettings().getLeagueId());
        assertThat(resultLeague.getId()).isEqualTo(resultLeague.getRosterSettings().getLeagueId());
    }

    @Test
    public void testDeleteLeague() {
        Long sampleLeagueId = 1L;

        League sampleLeague = new League();
        when(leagueRepository.getLeagueById(sampleLeagueId)).thenReturn(Optional.of(sampleLeague));

        leagueService.deleteLeague(sampleLeagueId);

        verify(leagueRepository).getLeagueById(sampleLeagueId);

        verify(leagueRepository).deleteById(sampleLeagueId);
    }
}

