package com.fantasy.sports.league.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.jpa.enums.ScoringType;
import com.fantasy.sports.league.service.LeagueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ExtendWith(MockitoExtension.class)
class LeagueControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private LeagueController leagueController;

    @Mock
    LeagueService leagueService;
    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(leagueController).build();
    }

    @Test
    void createLeague() throws Exception {
        LeagueDTO leagueDTO = LeagueDTO
                .builder()
                .leagueName("test LeagueName")
                .numberOfBench(16)
                .numberOfStarters(8)
                .scoringType(ScoringType.PPR)
                .build();
        League league = new League();

        when(leagueService.createLeague(any())).thenReturn(league);

        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(leagueDTO);

        MvcResult result = mockMvc.perform(post("/leagues")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        assertNotNull(resultContent);
    }



    @Test
    void getLeagueById() throws Exception {
        Long leagueId = 1L;
        League league = new League();
        when(leagueService.getLeagueById(leagueId)).thenReturn(league);
        when(modelMapper.map(league, LeagueDTO.class)).thenReturn(new LeagueDTO());

        mockMvc.perform(get("/leagues/{id}", leagueId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void filterLeagues() throws Exception {
        when(leagueService.filterLeagues(any(), any(), any(), any(), any(), any())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/leagues/filterLeagues"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void updateLeagueById() throws Exception {
        Long leagueId = 1L;
        LeagueDTO leagueDTO = new LeagueDTO();
        League league = new League();
        when(leagueService.updateLeague(eq(leagueId), any())).thenReturn(league);
        when(modelMapper.map(any(), eq(League.class))).thenReturn(new League());
        when(modelMapper.map(league, LeagueDTO.class)).thenReturn(new LeagueDTO());

        // Act
        String result = mockMvc.perform(put("/leagues/{id}", leagueId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(leagueDTO)))
                .andExpect(status().isNoContent())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertNotNull(result);
    }

    @Test
    void deleteLeagueById() throws Exception {
        Long leagueId = 1L;
        doNothing().when(leagueService).deleteLeague(leagueId);

        mockMvc.perform(delete("/leagues/{id}", leagueId))
                .andExpect(status().isNoContent());
    }


}
