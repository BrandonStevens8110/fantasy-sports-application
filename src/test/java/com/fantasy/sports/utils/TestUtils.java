package com.fantasy.sports.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    public static String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
