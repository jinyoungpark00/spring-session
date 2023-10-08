package com.likelionstudy.springstudy.service;

import com.likelionstudy.springstudy.domain.entity.LetterEntity;
import com.likelionstudy.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelionstudy.springstudy.dto.response.letter.LetterGetResponse;
import com.likelionstudy.springstudy.repository.LetterJpaRepository;
import com.likelionstudy.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private LetterJpaRepository letterJpaRepository;

    @Transactional
    public String create(LetterCreateRequest request){
        LetterEntity letter = letterJpaRepository.save(LetterEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());

        return letter.getId().toString();
    }

    public LetterGetResponse getById(Long id){
        return LetterGetResponse.of(letterJpaRepository.findByIdOrThrow(id));
    }
}
