package com.arthi.prime.calculator.web.rest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.arthi.prime.calculator.Application;

/**
 * Integration tests for Prime Calculator Web Services
 * @author arthi.shridharan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeCaculatorControllerIntTest {
    
    @LocalServerPort
    private int port;
    
    HttpHeaders headers = new HttpHeaders();
    TestRestTemplate restTemplate = new TestRestTemplate();
    
    private static String EXPECTED_XML_RESULT = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                                                 + "<primes><initial>23</initial>"
                                                 + "<primes>1</primes>"
                                                 + "<primes>2</primes>" 
                                                 + "<primes>3</primes>"
                                                 + "<primes>5</primes>"
                                                 + "<primes>7</primes>"
                                                 + "<primes>11</primes>"
                                                 + "<primes>13</primes>"
                                                 + "<primes>17</primes>"
                                                 + "<primes>19</primes>"
                                                 + "<primes>23</primes>"
                                                 + "</primes>";
    private static String EXPECTED_JSON_RESULT = "{initial:23,primes:[1,2,3,5,7,11,13,17,19,23]}";
    
    @Test
    public void testGetPrimeNumbersUptoIncludingForJSONResponse() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/23.json"),
                HttpMethod.GET, entity, String.class);

        JSONAssert.assertEquals(EXPECTED_JSON_RESULT, response.getBody(), false);
    }
    
    @Test
    public void testGetPrimeNumbersUptoIncludingForXMLResponse() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/23.xml"),
                HttpMethod.GET, entity, String.class);

        assertEquals(EXPECTED_XML_RESULT, response.getBody().toString());
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
