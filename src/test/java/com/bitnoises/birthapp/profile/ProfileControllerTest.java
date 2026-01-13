package com.bitnoises.birthapp.profile;

import com.bitnoises.birthapp.common.services.ValidationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest
class ProfileControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProfileService profileService;

    @MockitoBean
    ValidationService validationService;


    @BeforeEach
    void setUp() {
        when(profileService.search()).thenReturn(
                List.of(Profile.builder().email("john@gmail.com").build(),
                        Profile.builder().email("abc@gmail.com").build()
                ));
    }

    @Test
    void search() throws Exception {
        mockMvc.perform(get("/profile")).andExpect(status().isOk())
                .andExpect(content().string(containsString("abc@gmail.com")))
                .andExpect(content().string(containsString("john@gmail.com")));
    }

    @Test
    void create() throws Exception {
        Profile profile = Profile.builder().email("doc@gmail.com").build();
        String profileAsString = new ObjectMapper().writeValueAsString(profile);

        mockMvc.perform(
                post("/profile").contentType(APPLICATION_JSON_VALUE).content(profileAsString)
        ).andExpect(status().isCreated());
    }
}