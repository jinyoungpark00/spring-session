package com.likelionstudy.springstudy.controller;

import com.likelionstudy.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelionstudy.springstudy.dto.response.letter.LetterGetResponse;
import com.likelionstudy.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/letter")
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequest request){
        URI letter = URI.create("/api/letter/" + letterService.create(request));
        return ResponseEntity.created(letter).build();
    }

    @GetMapping("/{letterId}")
    public ResponseEntity<LetterGetResponse> getLetter(@PathVariable Long letterId){
        return ResponseEntity.ok(letterService.getById(letterId));
    }
}
