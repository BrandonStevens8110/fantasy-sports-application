package com.fantasy.sports.league.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.fantasy.sports.league.jpa.entity.League;
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
    public void testCreateLeague() {
        League sampleLeague = MockData.createLeague();

        when(leagueRepository.save(sampleLeague)).thenReturn(sampleLeague);

        League resultLeague = leagueService.createLeague(sampleLeague);

        assertEquals(sampleLeague, resultLeague);
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

    @Test
    public void testLeagueExistById() {
        // Sample league ID for testing
        long sampleLeagueId = 1L;

        // Configure the behavior of the leagueRepository.existsById method
        when(leagueRepository.existsById(sampleLeagueId)).thenReturn(true);

        // Call the method to be tested
        boolean result = leagueService.leagueExistById(sampleLeagueId);

        // Verify that the existsById method of leagueRepository was called with the sample ID
        verify(leagueRepository).existsById(sampleLeagueId);

        // Assert the expected result
        assertTrue(result);
    }
}

