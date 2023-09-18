package com.likelionstudy.springstudy.repository;

import com.likelionstudy.springstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
