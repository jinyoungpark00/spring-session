package com.likelionstudy.springstudy.service;

import com.likelionstudy.springstudy.dto.response.member.MemberGetResponse;
import com.likelionstudy.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // 생성자 의존성 주입을 위함
@Transactional(readOnly = true) // 조회할 때만 사용함. 생성, 삭제등의 작업이 필요할 때는 각각의 메서드에 @Transactional을 붙여줌
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

}
