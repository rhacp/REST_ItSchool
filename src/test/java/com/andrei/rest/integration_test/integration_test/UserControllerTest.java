package com.andrei.rest.integration_test.integration_test;

import com.andrei.rest.models.dtos.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Transactional
@AutoConfigureTestDatabase
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateUserShouldPass() throws Exception {
        //GIVEN
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john@gmail.com");
        //WHEN
        MvcResult result = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        UserDTO userDTOConverted = objectMapper.readValue(resultAsString, UserDTO.class);

        log.info("UserDTO result: " + userDTOConverted);
        //THEN
        assertEquals(userDTO.getFirstName(), userDTOConverted.getFirstName());
        assertEquals(userDTO.getLastName(), userDTOConverted.getLastName());
        assertEquals(userDTO.getEmail(), userDTOConverted.getEmail());
    }

    @Test
    void testCreateUserWithInvalidFirstNameShouldFail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Jo");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john@gmail.com");

        MvcResult result = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isNotFound())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        assertTrue(resultAsString.contains("Invalid first name."));

    }
}
