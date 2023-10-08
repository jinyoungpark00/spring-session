package com.likelionstudy.springstudy.repository;

import com.likelionstudy.springstudy.domain.entity.LetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {

    default LetterEntity findByIdOrThrow(Long id){
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 편지가 없습니다."));
    }
}
