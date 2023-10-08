package com.likelionstudy.springstudy.domain.entity;

import com.likelionstudy.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "box")
public class BoxEntity extends BaseTimeEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    private int letterLimit = DEFAULT_LETTER_LIMIT;

    private String code;

    // member 연결 1:1
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    // letter 연결 1:N
    // box에서 letter을 조회하는 경우가 많을 때-> Letter 객체를 List 형태로 가지고 있음 -> 양방향 연관관계

    // 연관관계를 맺을 때 데이터를 가져오는 두 가지 방식
    // 1. 즉시로딩 (Eager)
    // 2. 지연로딩 (Lazy)
    // 지연로딩과 즉시로딩을 혼합해서 쓰게되면 지연로딩할 때 어떤 데이터를 가져올지에 대한 컨트롤이 필요하기 때문에 일단은 지연로딩만 쓰자,,
    @OneToMany(mappedBy = "box") // Letter에서 연결한 변수명과 맞춰주면 됨.
    private final List<LetterEntity> letters = new ArrayList<>();

    @Builder
    public BoxEntity(String name, int letterLimit, String code, MemberEntity member){
        validate(letterLimit);
        this.name = name;
        this.code = code;
        this.member = member;
    }

    private void validate(int letterLimit) {
        validateLetterLimit(letterLimit);
    }

    private void validateLetterLimit(int letterLimit) {
        if (letterLimit > DEFAULT_LETTER_LIMIT || letterLimit < 0){
            throw new IllegalArgumentException("유효하지 않은 LetterLimit 입니다.");
        }
    }


}
