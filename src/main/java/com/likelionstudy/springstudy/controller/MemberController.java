package com.likelionstudy.springstudy.controller;

import com.likelionstudy.springstudy.dto.response.member.MemberGetResponse;
import com.likelionstudy.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // (@ResponseBody)return값이 객체면 JSON으로 바꿔줌
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    // 의존성 주입
    private final MemberService memberService;

//    public MemberController(MemberService memberService){
//        this.memberService = memberService;
//    }

    // 사용자 정보를 조회하는 API
    // Spring 응답 객체 1. ResponseEntity 2. 커스텀 entity -> 추상화해서 만드는 것이 좋음. (모든 메서드에서 사용할 수 있게)
    // generic <> 여러 자료형 올 수 있음
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("memberId") Long memberId){
        return ResponseEntity.ok(memberService.getById(memberId));
    }
}
