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
@RequestMapping("/api/v1/user/")

public class CurrencyConverterController {
    @CrossOrigin(origins = "*")
    @GetMapping("countrylist")
    public ResponseEntity<?> getCountryList()
    {
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

    @GetMapping("latest")
    public ResponseEntity<?> getLatestCurrencyRates(@RequestParam("base_currency") String param1,
                                                    @RequestParam("currencies") String param2)
    {
        String apiUrl = "https://api.freecurrencyapi.com/v1/latest";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);

        builder.queryParam("apikey", "fca_live_49jfgbN2zuQFEuPN1zO2POWSlUPvm7dgOj175GRN")
                .queryParam("base_currency", param1)
                .queryParam("currencies", param2);


        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(),String.class);
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
