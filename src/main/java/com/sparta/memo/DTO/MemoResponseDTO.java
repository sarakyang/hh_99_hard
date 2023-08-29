package com.sparta.memo.DTO;

import com.sparta.memo.entity.Memo;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemoResponseDTO {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private String password;

    private LocalDate creatAt;
    private LocalDate updatAt;

    public MemoResponseDTO(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
        this.title = memo.getTitle();
        this.password = memo.getPassword();
    }

    public MemoResponseDTO(Long id, String title, String username, String contents, String password,LocalDate creatAt ,LocalDate updatAt) {

        this.id = id;
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
        this.creatAt = creatAt;
        this.updatAt = updatAt;


    }


}