package com.project.MultiCurrencyTransfer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.MultiCurrencyTransfer.controllers.*;
import com.project.MultiCurrencyTransfer.repositories.*;
import com.project.MultiCurrencyTransfer.entities.*;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MultiCurrencyTransferApplicationTests {

    //	@Test
//	void contextLoads() {
//	}
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api/v1/user/";
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void testCreateUser() {
        User user = new User("john@example.com", "Malay", "Raj", "password123");
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(baseUrl + "register", user, User.class);

        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        User savedUser = responseEntity.getBody();
        assert savedUser != null;
        Assertions.assertNotNull(savedUser.getUserId());
        Assertions.assertEquals(user.getFirstName(), savedUser.getFirstName());
    }

}
