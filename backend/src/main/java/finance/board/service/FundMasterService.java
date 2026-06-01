package finance.board.service;

import finance.board.domain.FundMaster;
import finance.board.mapper.FundMasterMapper;
import finance.board.mapper.dto.KrxEtfItem;
import finance.board.mapper.dto.KrxEtfResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundMasterService {

    private final FundMasterMapper mapper;
    private final KrxApiClient krxApiClient;

    public int batchInsert(String basDd) {

        System.out.println("=================================");
        System.out.println("KRX 요청일자 : " + basDd);
        System.out.println("=================================");

        KrxEtfResponse response =
                krxApiClient.getEtfDailyTrade(basDd);

        if(response == null ||
                response.getOutBlock1() == null) {
            return 0;
        }

        int count = 0;

        for (KrxEtfItem item : response.getOutBlock1()) {

            if (item.getIsuCd() == null || item.getIsuCd().isBlank()) {
                continue;
            }

            FundMaster fund = new FundMaster();

            fund.setFundCd(item.getIsuCd());
            fund.setFundNm(item.getIsuNm());
            fund.setFundTpCd("ETF");
            fund.setMngCoCd(null);
            fund.setRiskGrdCd(null);
            fund.setListDt(null);
            fund.setCurCd("KRW");
            fund.setLastSrcNm("KRX_API");

            count += mapper.insertFundMaster(fund);
        }

        return count;
    }

    public List<FundMaster> list() {
        return mapper.selectAll();
    }
}