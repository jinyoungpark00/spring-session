package com.likelionstudy.springstudy.service;

import com.likelionstudy.springstudy.domain.entity.BoxEntity;
import com.likelionstudy.springstudy.domain.entity.MemberEntity;
import com.likelionstudy.springstudy.dto.request.box.BoxCreateRequest;
import com.likelionstudy.springstudy.dto.response.box.BoxGetResponse;
import com.likelionstudy.springstudy.repository.BoxJpaRepository;
import com.likelionstudy.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {

    private BoxJpaRepository boxJpaRepository;
    private MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(BoxCreateRequest request, Long memberId){
        BoxEntity box = boxJpaRepository.save(BoxEntity.builder()
                .name(request.getName())
                .code(generateCode())
                .member(findByMemberId(memberId))
                .build());

        return box.getCode();
    }

    public BoxGetResponse getByCode(String code){
        return BoxGetResponse.of(boxJpaRepository.findByCodeOrThrow(code));
    }

    private MemberEntity findByMemberId(Long memberId) {
        return memberJpaRepository.findByIdOrThrow(memberId);
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
