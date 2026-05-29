package finance.board.controller;


import finance.board.domain.FundMaster;
import finance.board.service.FundMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/batch/fund")
public class FundMasterBatchController {


    private final FundMasterService service;


    @GetMapping("/load")
    public String load(){

        int cnt = service.batchInsert();

        return "FUND_MST INSERT : " + cnt;

    }


    @GetMapping("/list")
    public List<FundMaster> list(){

        return service.list();

    }

}