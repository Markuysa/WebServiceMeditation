package com.example.meditationbackend;

import com.example.meditationbackend.Controllers.MainController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class MeditationBackendApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;
    @Test
    void testMeditationsFetch() throws Exception{
        this.mockMvc.perform(get("/api/meditations/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void loginTest() throws Exception{
        this.mockMvc.perform(get("/auth/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Login"));

    }

}
