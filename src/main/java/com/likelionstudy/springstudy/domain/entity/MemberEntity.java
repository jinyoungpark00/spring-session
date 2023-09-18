package com.likelionstudy.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본 생성자가 필요함
@Getter @Setter
@Table(name = "member") //Table 이름 지정
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK를 어떻게 만들건지를 결정 (IDENTITY는 auto-increse 느낌)
    private Long id; // JPA에서 pk는 기본적으로 래퍼 클래스로 만들어 줘야 함 (래퍼 클래스는 NULL 가능)

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false) // DB에 들어갈 때 판단함
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @CreatedDate // 데이터 입력될 때 시간 자동 입력
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate // 데이터 수정될 때 시간 자동 입력
    private LocalDateTime updated_at;

    // box 연결 1:1
    @OneToOne(mappedBy = "member")
    private BoxEntity box;

    @Builder
    public MemberEntity(Long id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    private void validateNickname(){
        if(this.nickname.length() > 20){
            throw new IllegalArgumentException("닉네임은 20자 이하여야 합니다.");
        }
    }
}
