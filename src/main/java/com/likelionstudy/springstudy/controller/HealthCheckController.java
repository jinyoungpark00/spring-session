package com.likelionstudy.springstudy.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api") // consume과 produce -> 들어오고 나가는 데이터를 설정해줄 수 있음
public class HealthCheckController {

    @GetMapping(value = "/health", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("OK");
    }
}
