package com.project.MultiCurrencyTransfer.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.services.account.IAccountService;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user/")

public class CurrencyConverterController {
    // Add your API key and other necessary parameters
    @GetMapping("countrylist")
    public ResponseEntity<?> getCountryList()
    {
        System.out.println("hello");
        String apiUrl = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl,String.class);
            return response;
        } catch (HttpClientErrorException e) {
            // Handle client errors (e.g., 4xx status codes)
            return ResponseEntity.status(e.getRawStatusCode()).body(e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {
            // Handle network or resource acce
            return ResponseEntity.status(500).body("Failed to connect to the external API.");
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(500).body("An error occurred while fetching data from the external API.");
        }
    }
}
