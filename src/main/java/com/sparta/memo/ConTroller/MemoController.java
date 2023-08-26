package com.sparta.memo.ConTroller;

import com.sparta.memo.DTO.MemoRequsetDTO;
import com.sparta.memo.DTO.MemoResponseDTO;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDTO createMemo(@RequestBody MemoRequsetDTO requsetDTO) {

        Memo memo = new Memo(requsetDTO);

        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        memoList.put(memo.getId(), memo);

        MemoResponseDTO memoResponseDTO = new MemoResponseDTO(memo);
        return memoResponseDTO;
    }

    @GetMapping("/memos")
    public List<MemoResponseDTO> getMemos() {
        List<MemoResponseDTO> responseDTOSList = memoList.values().stream()
                .map(MemoResponseDTO::new).toList();

        return responseDTOSList;
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequsetDTO requsetDTO) {
        if (memoList.containsKey(id)) {
            Memo memo = memoList.get(id);

            memo.update(requsetDTO);

            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모가 없어요");
        }
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        if (memoList.containsKey(id)) {
            memoList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모가 없어요");
        }
    }
}
