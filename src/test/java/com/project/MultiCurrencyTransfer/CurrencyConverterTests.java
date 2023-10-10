package com.project.MultiCurrencyTransfer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CurrencyConverterTests {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port;
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn("Mocked API Response JSON");
    }

    @Test
    public void testGetCountryList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/api/v1/user/countrylist")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLatestCurrencyRates_Success() throws Exception {
        // Mock the external API response with a sample JSON
        String sampleApiResponse = "{ \"data\": { \"AUD\": 1.5571402803 } }"; // Update the values
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn(sampleApiResponse);

        mockMvc.perform(MockMvcRequestBuilders.get(baseUrl + "/api/v1/user/latest")
                        .param("base_currency", "USD")
                        .param("currencies", "AUD")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.AUD").isNumber());
    }



    @Test
    public void testConvertCurrency_NonExistentConversionRate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/convert")
                        .param("base_currency", "USD")
                        .param("currencies", "JPY")
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void testConvertCurrency_InvalidCurrencyCodes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/convert")
                        .param("base_currency", "XYZ")
                        .param("currencies", "ABC")
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void testConvertCurrency_UnsupportedMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/convert")
                        .param("base_currency", "USD")
                        .param("currencies", "EUR")
                        .contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void testConvertCurrency_MissingFromParameter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/convert")
                        .param("base_currency", "EUR")
                        .param("currencies", "100.00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

}
