package finance.board.controller;

import finance.board.domain.FundMaster;
import finance.board.service.FundMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/batch/fund")
public class FundMasterBatchController {

    private final FundMasterService service;

    @GetMapping("/load")
    public String load(@RequestParam(required = false) String basDd) {

        if (basDd == null || basDd.isBlank()) {
            basDd = LocalDate.now()
                    .format(DateTimeFormatter.BASIC_ISO_DATE);
        }

        int cnt = service.batchInsert(basDd);

        return "기준일=" + basDd + ", 적재건수=" + cnt;
    }

    @GetMapping("/list")
    public List<FundMaster> list() {
        return service.list();
    }
}