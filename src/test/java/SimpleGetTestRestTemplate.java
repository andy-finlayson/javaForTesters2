import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleGetTestRestTemplate {
    @Test
    public void getWeather() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://restapi.demoqa.com/utilities/weather/city";
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/Hyderabad", String.class);
        HttpHeaders headers = response.getHeaders();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response.getBody());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name = root.path("City");
        assertThat(name.asText(), notNullValue());
        assertThat(name.asText(), is("Hyderabad"));

        assertThat(headers.getContentType().toString(),is("application/json"));
        assertThat(headers.get("Server").toString(),is("[nginx/1.12.2]"));
        System.out.println(headers);
    }
}
