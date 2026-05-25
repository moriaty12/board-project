package finance.board.controller;

import finance.board.mapper.BatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {

    private final BatchMapper batchMapper;

    @PostMapping("/api/batch/mock")
    public String insertMock() {

        batchMapper.insertMock();

        return "OK";
    }
}