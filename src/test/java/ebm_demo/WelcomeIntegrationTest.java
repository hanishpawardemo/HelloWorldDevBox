package ebm_demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = {com.xyz.Application.class})
public class WelcomeIntegrationTest {

    @LocalServerPort
    private int localPort;

    private HttpHeaders headers;
    private TestRestTemplate restTemplate;

    private String url = "/ebm-demo/api/v1/json/welcomeMessage";

    @Before
    public void setup(){
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    }

    @Test
    public void testHelloWorldAPI(){
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(url), HttpMethod.GET,
                entity, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + localPort + uri;
    }
}
