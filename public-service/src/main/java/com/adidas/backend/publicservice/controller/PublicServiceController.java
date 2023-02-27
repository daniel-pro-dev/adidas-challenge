package com.adidas.backend.publicservice.controller;


import com.adidas.backend.adiclubservice.dto.AdiClubMemberInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.adidas.backend.publicservice.engine.Producer;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping(value = "/kafka")
public class PublicServiceController {


    @Autowired
    Producer producer;
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping(value = "/subscribe")
    public String sendMessageToKafkaTopic(@RequestParam("email") String email) {
        String received = "";
        if (producer.subscribeMessage(email)) {
            ResponseEntity<AdiClubMemberInfoDto> response = restTemplate
                    .getForEntity("http://localhost:8080/memberInfo?emailAddress=" + email, AdiClubMemberInfoDto.class);

            received = response.toString();
        }
        return received;
    }

}
