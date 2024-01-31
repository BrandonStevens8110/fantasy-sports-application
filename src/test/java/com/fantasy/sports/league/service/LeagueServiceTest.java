package com.fantasy.sports.league.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.fantasy.sports.exception.NotFoundException;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.enums.ScoringType;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LeagueServiceTest {

    @Mock
    private LeagueRepository leagueRepository;

    @InjectMocks
    private LeagueService leagueService;

    @Test
    void testCreateLeague() {
        League league = League
                .builder()
                .leagueName("testName")
                .scoringType(ScoringType.PPR)
                .numberOfTeams(12)
                .numberOfStarters(12)
                .build();

        when(leagueRepository.save(league)).thenReturn(league);

        League resultLeague = leagueService.createLeague(league);

        verify(leagueRepository, times(1)).save(league);

        assertThat(resultLeague).isNotNull();
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
    public void testGetLeagueById() {
        Long sampleLeagueId = 1L;

        League sampleLeague = new League();
        when(leagueRepository.getLeagueById(sampleLeagueId)).thenReturn(Optional.of(sampleLeague));

        // Call the method
        League resultLeague = leagueService.getLeagueById(sampleLeagueId);

        // Assertions using AssertJ
        assertThat(resultLeague).isNotNull();
        assertThat(resultLeague).isEqualTo(sampleLeague);
    }

    @Test
    public void testGetLeagueByIdNotFound() {
        Long nonExistingLeagueId = 99L;

        when(leagueRepository.getLeagueById(nonExistingLeagueId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> leagueService.getLeagueById(nonExistingLeagueId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("League with Id" + nonExistingLeagueId);
    }

    @Test
    public void testFilterLeagues() {
        // Mock data
        String leagueName = "testName";
        Integer numberOfTeams = 12;
        Integer rosterSize = 16;
        Integer numberOfStarters = 8;
        Integer numberOfBench = 4;
        ScoringType scoringType = ScoringType.PPR;

        when(leagueRepository.findByParams(leagueName, numberOfTeams, rosterSize, numberOfStarters, numberOfBench, scoringType))
                .thenReturn(List.of());

        List<League> resultLeagues = leagueService.filterLeagues(leagueName, numberOfTeams, rosterSize, numberOfStarters, numberOfBench, scoringType);

        assertThat(resultLeagues).isNotNull();
        assertThat(resultLeagues).isEmpty();
    }

    @Test
    public void testUpdateLeague() {
        Long existingLeagueId = 1L;

        League existingLeague = League.builder()
                .id(existingLeagueId)
                .leagueName("Existing League")
                .numberOfTeams(10)
                .rosterSize(15)
                .numberOfStarters(7)
                .numberOfBench(5)
                .scoringType(ScoringType.STANDARD)
                .build();

        League updatedLeague = League.builder()
                .leagueName("Updated League")
                .numberOfTeams(12)
                .rosterSize(16)
                .numberOfStarters(8)
                .numberOfBench(4)
                .scoringType(ScoringType.PPR)
                .build();

        when(leagueRepository.getLeagueById(existingLeagueId)).thenReturn(Optional.of(existingLeague));
        when(leagueRepository.save(any())).thenReturn(updatedLeague);

        League resultLeague = leagueService.updateLeague(existingLeagueId, updatedLeague);

        verify(leagueRepository, times(1)).getLeagueById(existingLeagueId);
        verify(leagueRepository, times(1)).save(any());

        assertThat(resultLeague).isNotNull();
        assertThat(resultLeague.getLeagueName()).isEqualTo(updatedLeague.getLeagueName());
        assertThat(resultLeague.getNumberOfTeams()).isEqualTo(updatedLeague.getNumberOfTeams());
        assertThat(resultLeague.getRosterSize()).isEqualTo(updatedLeague.getRosterSize());
        assertThat(resultLeague.getNumberOfStarters()).isEqualTo(updatedLeague.getNumberOfStarters());
        assertThat(resultLeague.getNumberOfBench()).isEqualTo(updatedLeague.getNumberOfBench());
        assertThat(resultLeague.getScoringType()).isEqualTo(updatedLeague.getScoringType());
    }
}
