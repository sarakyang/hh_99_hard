package com.sparta.memo.entity;

import com.sparta.memo.DTO.MemoRequsetDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequsetDTO requsetDTO) {
        this.username = requsetDTO.getUsername();
        this.contents = requsetDTO.getContents();
    }
}