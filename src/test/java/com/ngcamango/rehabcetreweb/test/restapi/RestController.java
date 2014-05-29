/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.restapi;
import com.ngcamango.rehabcetreweb.domain.Patient;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ngcamango
 */
public class RestController {
    private RestTemplate restTemplate;
    
    public void tesCreate(){
        Patient p =null;
        HttpEntity<Patient> requestEntity = new HttpEntity<Patient>(p, getContentType());
// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.exchange("URL", HttpMethod.POST, requestEntity, String.class);
    }
    
    public void testRead(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Patient[]> responseEntity = restTemplate.exchange("URL",HttpMethod.GET,requestEntity, Patient[].class);
        
        Patient [] patients = responseEntity.getBody();
    }
    
    private HttpEntity<?> getHttpEntity(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
}
