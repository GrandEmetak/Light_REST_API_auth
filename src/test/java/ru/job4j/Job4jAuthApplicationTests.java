package ru.job4j;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.domain.Person;
import ru.job4j.servise.PersonService;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 0. RESTFull. Описание архитектуры [#6884]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.8. Rest
 * 3. Составить полноценные junit тесты.
 */
@SpringBootTest
@AutoConfigureMockMvc
class Job4jAuthApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService service;
    @Autowired
    private Gson gson;

    @Test
    public void whenGet() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(Person.of(1, "1login", "1password")));
        when(service.findById(2)).thenReturn(Optional.of(Person.of(2, "2login", "2password")));
        this.mockMvc.perform(get("/person/"))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/person/1"))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/person/2"))
                .andDo(print())
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/person/-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void whenCreate() throws Exception {
        Person person = Person.of(1, "login", "password");
        this.mockMvc.perform(post("/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(person)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void whenDelete() throws Exception {
        Person person = Person.of(1, "login", "password");
        this.mockMvc.perform(post("/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(person)))
                .andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(delete("/person/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenUpdate() throws Exception {
        Person person = Person.of(1, "login", "password");
        this.mockMvc.perform(post("/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(person)))
                .andExpect(status().is2xxSuccessful());
        person.setLogin("newlogin");
        person.setPassword("newpassword");
        this.mockMvc.perform(put("/person/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(person)))
                .andExpect(status().isOk());
    }

}
