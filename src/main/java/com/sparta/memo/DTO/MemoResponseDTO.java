package com.sparta.memo.DTO;

import com.sparta.memo.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDTO {
    private Long id;
    private String username;
    private String contents;

    public MemoResponseDTO(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();

    }
}