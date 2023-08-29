package com.sparta.memo.entity;

import com.sparta.memo.DTO.MemoRequsetDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;

    private LocalDate craetAt;
    private LocalDate updatAt;

    public Memo(MemoRequsetDTO requsetDTO) {
        this.title = requsetDTO.getTitle();
        this.username = requsetDTO.getUsername();
        this.contents = requsetDTO.getContents();
        this.password = requsetDTO.getPassword();
        this.craetAt = LocalDate.now();
    }

    public void update(MemoRequsetDTO requsetDTO) {
        this.title = requsetDTO.getTitle();
        this.username = requsetDTO.getUsername();
        this.contents = requsetDTO.getContents();
        this.password = requsetDTO.getPassword();
        this.updatAt = LocalDate.now();
    }
}