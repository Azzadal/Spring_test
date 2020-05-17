package com.springapp.controller;

import com.springapp.Repos.ArtefactRepository;
import com.springapp.model.Artefact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArtefactRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ArtefactRepository artefactRepository;

    private Artefact createNewArtefact(String userId, String category) {
        Artefact artefact = new Artefact(userId, category);
        return artefactRepository.save(artefact);
    }

    @Test
    public void getAll() throws Exception {

        this.mockMvc.perform(get("/api/artefact/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOne() throws Exception {
        UUID id = createNewArtefact("user1", "catExz").getId();
        this.mockMvc.perform(get("/api/artefact/" + id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        this.mockMvc.perform(post("/api/artefact")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\":\"test1\",\"category\":\"test1\"}"))
                .andDo(print());
    }

}