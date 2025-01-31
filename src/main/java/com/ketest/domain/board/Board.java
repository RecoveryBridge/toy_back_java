package com.ketest.domain.board;

import com.ketest.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_board")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;             // 게시글 번호 (PK)

    @Column(name = "title")
    private String title;      // 게시글 제목

    @Column(name = "content")
    private String content;     // 게시글 내용


    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

}