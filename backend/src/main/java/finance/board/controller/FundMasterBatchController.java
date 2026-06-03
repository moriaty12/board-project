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

    @GetMapping("/load-range")
    public String loadRange(
            @RequestParam String fromDt,
            @RequestParam String toDt) {

        int cnt = service.batchInsertRange(fromDt, toDt);

        return "시작일=" + fromDt
                + ", 종료일=" + toDt
                + ", 총 적재건수=" + cnt;
    }
    @GetMapping("/calc-return")
    public String calcReturn(
            @RequestParam String fromDt,
            @RequestParam String toDt) {

        int cnt = service.calcReturnRateByRange(fromDt, toDt);

        return "수익률 계산 완료, 시작일=" + fromDt
                + ", 종료일=" + toDt
                + ", 처리건수=" + cnt;
    }
}