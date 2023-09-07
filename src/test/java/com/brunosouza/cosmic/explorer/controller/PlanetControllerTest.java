package com.brunosouza.cosmic.explorer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PlanetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRightRotation() throws Exception {
        String commands = "MMRMMRMM";
        mockMvc.perform(post("/rest/mars").content(commands))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void testLeftRotation() throws Exception {
        String commands = "MML";
        mockMvc.perform(post("/rest/mars").content(commands))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }


    @Test
    public void testRepeatedCommands() throws Exception {
        String commands = "MML";
        mockMvc.perform(post("/rest/mars").content(commands))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void testInvalidCommand() throws Exception {
        String commands = "AAA";
        mockMvc.perform(post("/rest/mars").content(commands))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("invalid command"));
    }

    @Test
    public void testInvalidPosition() throws Exception {
        String commands = "MMMMMMMMMMMMMMMMMMMMMMMM";
        mockMvc.perform(post("/rest/mars").content(commands))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("invalid position"));
    }
}