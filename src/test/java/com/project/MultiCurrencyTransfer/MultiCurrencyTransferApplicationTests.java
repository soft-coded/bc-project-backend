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
import org.springframework.http.HttpMethod;
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

    @Test
    public void testUpdateUserFirstName() {
        User user = new User("malaya.yosoufzai@example.com", "Malaya", "Yosoufzai", "password222");
        User savedUser = userRepository.save(user);

        savedUser.setFirstName("UpdatedMalaya");
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                baseUrl + savedUser.getUserId(),
                HttpMethod.PUT,
                new HttpEntity<>(savedUser),
                User.class
        );

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        User updatedUser = responseEntity.getBody();
        Assertions.assertNotNull(updatedUser);
        Assertions.assertEquals(savedUser.getUserId(), updatedUser.getUserId());
        Assertions.assertEquals("UpdatedMalaya", updatedUser.getFirstName());
    }

    @Test
    public void testUpdateUserEmail() {
        User user = new User("malaii.llama@example.com", "Malai", "Llama", "password222");
        User savedUser = userRepository.save(user);

        savedUser.setEmail("malai.updated@example.com");
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                baseUrl + savedUser.getUserId(),
                HttpMethod.PUT,
                new HttpEntity<>(savedUser),
                User.class
        );

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        User updatedUser = responseEntity.getBody();
        Assertions.assertNotNull(updatedUser);
        Assertions.assertEquals(savedUser.getUserId(), updatedUser.getUserId());
        Assertions.assertEquals("malai.updated@example.com", updatedUser.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("malaii.llama@example.com", "Malai", "Llama", "password222");
        User user2 = new User("bhupendra.jogi@example.com", "Bhupendra", "Jogi", "password123");

        User savedUser1 = userRepository.save(user1);
        User savedUser2 = userRepository.save(user2);

        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(baseUrl, User[].class);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        User[] users = responseEntity.getBody();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(2, users.length);
        Assertions.assertEquals("bhupendra.jogi@example.com", savedUser2.getEmail());
        Assertions.assertEquals("Bhupendra", savedUser2.getFirstName());


    }


}
