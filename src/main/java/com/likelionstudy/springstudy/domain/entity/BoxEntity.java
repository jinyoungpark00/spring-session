package com.likelionstudy.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name = "box")
public class BoxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    // member 연결 1:1
    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    // letter 연결 1:N
    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters = new ArrayList<>();


}
