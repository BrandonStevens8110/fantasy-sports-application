package com.fantasy.sports.league.controller;

import com.fantasy.sports.league.jpa.dto.LeagueDTO;
import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.service.LeagueService;
import com.fantasy.sports.utils.MockData;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        League leagueDTO = MockData.createLeague();
        League league = new League();

        when(leagueService.createLeague(any())).thenReturn(league);

        ObjectMapper mapper = new ObjectMapper();

        String result = ((mockMvc.perform(post("/leagues")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(leagueDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn())
                .getResponse()
                .getContentAsString());

        League resultLeague = mapper.readValue(result, League.class);

        assertNotNull(resultLeague);
    }


}
