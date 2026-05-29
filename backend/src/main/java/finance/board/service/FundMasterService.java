package finance.board.service;

import finance.board.domain.FundMaster;
import finance.board.mapper.FundMasterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FundMasterService {

    private final FundMasterMapper mapper;

    public int batchInsert() {

        FundMaster fund = new FundMaster();

        fund.setFundCd("069500");
        fund.setFundNm("KODEX 200");
        fund.setFundTpCd("ETF");
        fund.setMngCoCd("SAM");
        fund.setRiskGrdCd("2");
        fund.setListDt("2002-10-14");
        fund.setCurCd("KRW");
        fund.setLastSrcNm("KRX_API");

        return mapper.insertFundMaster(fund);
    }

    public List<FundMaster> list() {
        return mapper.selectAll();
    }
}