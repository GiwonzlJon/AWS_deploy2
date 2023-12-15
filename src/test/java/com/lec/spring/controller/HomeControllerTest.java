package com.lec.spring.controller;

import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${server.port}")
    private String port;
    @Test
    void hello(){
        System.out.println("port : " + port);
        ResponseEntity<String> response =  restTemplate.getForEntity("/aws/v2", String.class);

        // "<h1>AWS 배포 v1 </h1>" 와 같아야 통과 (한글자라도 틀리면 테스트 페일)
        assertEquals("<h1>AWS 배포 v2 </h1>\n<h1>AWS 배포 v2 </h1>", response.getBody());
    }
}