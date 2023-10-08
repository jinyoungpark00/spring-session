package com.likelionstudy.springstudy.repository;

import com.likelionstudy.springstudy.domain.entity.MemberEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

// 기본적인 CRUD 정의되어 있음
public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    default MemberEntity findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원을 찾을 수 없습니다."));
    }
}
