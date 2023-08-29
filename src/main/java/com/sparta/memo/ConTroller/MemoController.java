package com.sparta.memo.ConTroller;

import com.sparta.memo.DTO.MemoRequsetDTO;
import com.sparta.memo.DTO.MemoResponseDTO;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final JdbcTemplate jdbcTemplate;

    public MemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/memos")
    public MemoResponseDTO createMemo(@RequestBody MemoRequsetDTO requestDto) {
        MemoService memoService = new MemoService(jdbcTemplate);

        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDTO> getMemos() {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequsetDTO requestDto) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}/{password}")
    public Long deleteMemo(@PathVariable Long id , @PathVariable String password ) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.deleteMemo(id,password);
    }

    @GetMapping("/{id}")
    public Memo findByid(@PathVariable Long id) {
        String sql = "SELECT * FROM memo WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Memo memo = new Memo();
                memo.setTitle(resultSet.getString("title"));
                memo.setUsername(resultSet.getString("username"));
                memo.setContents(resultSet.getString("contents"));
                return memo;
            } else {
                return null;
            }
        }, id);
    }
}