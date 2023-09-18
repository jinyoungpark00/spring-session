package com.likelionstudy.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name = "letter")
public class LetterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private String photo_url;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;

    // box 연결 1:1
    @ManyToOne
    @JoinColumn(name = "box_id")
    private BoxEntity box;
}
