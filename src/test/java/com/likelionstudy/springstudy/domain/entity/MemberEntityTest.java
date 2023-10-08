package com.likelionstudy.springstudy.domain.entity;

import com.likelionstudy.springstudy.repository.MemberJpaRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.query.sqm.mutation.internal.cte.CteInsertStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberEntityTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @DisplayName("")
    @Test
    void test(){
        //given
        MemberEntity member = MemberEntity.builder()
                .username("park")
                .nickname("jinjin")
                .build();
        memberJpaRepository.save(member);
        //when
        MemberEntity findMember = memberJpaRepository.findById(1L).get();
        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }

}
