package com.likelionstudy.springstudy.domain.entity;

import com.likelionstudy.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본 생성자가 필요함
@Getter // Setter 사용은 주의 -> 변경 가능성 때문 + 같은 기능이지만 다른 이름의 메서드가 필요할 때 ex) updateNickname ... 의 경우 이러한 메서드를 만드는 것이 더 좋음
@Table(name = "member") // Table 이름 지정 (안하면 클래스를 snackcase로 변환하여 저장됨)
public class MemberEntity extends BaseTimeEntity {

    @Id // 식별자를 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK를 어떻게 만들건지를 결정 (IDENTITY는 auto-increse 느낌)
    private Long id; // JPA에서 pk는 기본적으로 래퍼 클래스로 만들어 줘야 함 (래퍼 클래스는 NULL 가능)

    @Column(nullable = false, unique = true)
    private String username;

//    @Column(nullable = false) // DB에 들어갈 때 판단함
//    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    // box 연결 1:1
    @OneToOne(mappedBy = "member")
    private BoxEntity box;

    // 생성자 -> 기본적으로는 new를 통해서 실행
    // 1. 빌더 패턴 @Builder 사용 -> MemberEntity.builder().name("").build() 의 형태로 생성자 실행.
    // 2. 팩토리 메소드 패턴 -> static method를 사용함 (메모리 효율적임), 상황에 따라 메서드 이름을 다르게 설정해줄 수 있음.
    //    public static MemberEntity createMember(String name, String nickname){
    //        return new MemberEntity(name, nickname);
    //    }
    @Builder
    public MemberEntity(String username,String nickname) {
        this.username = username;
        this.nickname = nickname;
    }

    private void validateNickname(){
        if(this.nickname.length() > 20){
            throw new IllegalArgumentException("닉네임은 20자 이하여야 합니다.");
        }
    }
}
