package com.likelionstudy.springstudy.domain.entity;

import com.likelionstudy.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "letter")
public class LetterEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

//    @Column
//    private String photo_url;

    // box 연결 N:1 (N쪽이 연관관계의 주인 : box에 대한 정보를 들고 있음(box_id)) -> 단방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    private BoxEntity box;

    @Builder
    public LetterEntity(String title, String content){
        this.title = title;
        this.content = content;
    }
}
