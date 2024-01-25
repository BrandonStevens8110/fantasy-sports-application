package com.fantasy.sports.league.api;

import com.fantasy.sports.league.jpa.entity.League;
import com.fantasy.sports.league.model.LeagueDTO;
import com.fantasy.sports.league.service.LeagueService;
import com.fantasy.sports.utils.MockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
class LeagueControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private LeagueController leagueController;

    @Mock
    LeagueService leagueService;
    @Mock
    ModelMapper modelMapper;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(leagueController).build();
    }

    @Test
    void createLeague() throws Exception {
        LeagueDTO leagueDTO = MockData.createLeagueDTO();
        League league = new League();


        ObjectMapper objectMapper1 = new ObjectMapper();

        when(leagueService.createLeague(any())).thenReturn(league);

        String result = (mockMvc.perform(post("/leagues-new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(leagueDTO)))
                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn())
                .getResponse()
                .getContentType();

        LeagueDTO resultLeague = objectMapper.readValue(result, LeagueDTO.class);
        assertNotNull(resultLeague);
    }


}
