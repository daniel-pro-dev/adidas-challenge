package com.adidas.backend.prioritysaleservice.controller;

import com.adidas.backend.adiclubservice.dto.AdiClubMemberInfoDto;
import com.adidas.backend.publicservice.engine.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
public class MemberRestController {

    @Value("${adi.club.service}")
    private String ADICLUB_URL_SERVICE;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/memberInfo")
    public HttpStatus getMemberInfo(@RequestParam String emailAddress) throws IOException {

        Consumer consumer = new Consumer();

        consumer.consume(emailAddress);

        ResponseEntity<AdiClubMemberInfoDto> response = null;

        if (consumer.consume(emailAddress)) {

            String url = ADICLUB_URL_SERVICE + emailAddress;

            response = restTemplate
                    .getForEntity(url, AdiClubMemberInfoDto.class);

        }
        return response.getStatusCode();
    }
}

