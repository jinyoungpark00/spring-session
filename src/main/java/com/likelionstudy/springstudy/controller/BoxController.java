package com.likelionstudy.springstudy.controller;

import com.likelionstudy.springstudy.dto.request.box.BoxCreateRequest;
import com.likelionstudy.springstudy.dto.response.box.BoxGetResponse;
import com.likelionstudy.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {

    private final BoxService boxService;

    @PostMapping
    public ResponseEntity<Void> createLetterBox(@RequestBody BoxCreateRequest request, Long memberId){
        URI box = URI.create("/api/box/" + boxService.create(request, memberId));
        return ResponseEntity.created(box).build();
    }

    @GetMapping("/{boxCode}")
    public ResponseEntity<BoxGetResponse> getBox(@PathVariable String boxCode){
        return ResponseEntity.ok(boxService.getByCode(boxCode));
    }

}
