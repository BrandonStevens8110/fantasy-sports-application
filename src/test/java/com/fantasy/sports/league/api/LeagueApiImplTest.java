package com.fantasy.sports.league.api;

import com.fantasy.sports.league.jpa.entity.BasicSettings;
import com.fantasy.sports.league.jpa.entity.DraftSettings;
import com.fantasy.sports.league.jpa.repository.BasicSettingsRepository;
import com.fantasy.sports.league.jpa.repository.DraftSettingsRepository;
import com.fantasy.sports.league.jpa.repository.LeagueRepository;
import com.fantasy.sports.league.jpa.repository.RosterSettingsRepository;
import com.fantasy.sports.league.model.LeagueDTO;
import com.fantasy.sports.league.service.LeagueService;
import com.fantasy.sports.utils.MockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
class LeagueApiImplTest {

    @MockBean
    LeagueService leagueService;
    @InjectMocks
    LeagueApiImpl leagueApi;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(leagueApi).build();
    }

    @Test
    void createLeague() throws Exception {
        LeagueDTO leagueDTO = MockData.createLeagueDTO();

        when(leagueService.createLeague(any())).thenReturn(any());
        String result = (mockMvc.perform(post("")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn())
                .getResponse()
                .getContentType();

    }
}
