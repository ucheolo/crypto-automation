package com.example.crypto_automatioon.controller;

import com.example.crypto_automatioon.service.UpbitSlackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UpbitSlackService upbitSlackService;

    @GetMapping("/api/v1/ticker/{market}")
    public void test(@PathVariable String market) throws JsonProcessingException {
        // https://app.slack.com/client/T07BKSAHF7U/C07C8L6PPFS 로 슬랙 접속
        upbitSlackService.execute(market);
    }


}
