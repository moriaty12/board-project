package finance.board.service;

import finance.board.domain.FundMaster;
import finance.board.domain.FundPerfHist;
import finance.board.mapper.FundMasterMapper;
import finance.board.mapper.FundPerfHistMapper;
import finance.board.mapper.dto.KrxEtfItem;
import finance.board.mapper.dto.KrxEtfResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundMasterService {

    private final FundMasterMapper mapper;
    private final FundPerfHistMapper fundPerfHistMapper;
    private final KrxApiClient krxApiClient;

    public int batchInsert(String basDd) {

        System.out.println("=================================");
        System.out.println("KRX 요청일자 : " + basDd);
        System.out.println("=================================");

        KrxEtfResponse response =
                krxApiClient.getEtfDailyTrade(basDd);

        if (response == null || response.getOutBlock1() == null) {
            return 0;
        }

        int count = 0;

        for (KrxEtfItem item : response.getOutBlock1()) {

            if (item.getIsuCd() == null || item.getIsuCd().isBlank()) {
                continue;
            }

            // 1. FUND_MST 적재
            FundMaster fund = new FundMaster();

            fund.setFundCd(item.getIsuCd());
            fund.setFundNm(item.getIsuNm());
            fund.setFundTpCd("ETF");
            fund.setMngCoCd(null);
            fund.setRiskGrdCd(null);
            fund.setListDt(null);
            fund.setCurCd("KRW");
            fund.setLastSrcNm("KRX_API");

            mapper.insertFundMaster(fund);

            // 2. FUND_PERF_HIST 적재
            FundPerfHist hist = new FundPerfHist();

            hist.setFundCd(item.getIsuCd());
            hist.setBaseDt(LocalDate.parse(item.getBasDd(), DateTimeFormatter.BASIC_ISO_DATE));
            hist.setClsPrc(toBigDecimal(item.getTddClsprc()));
            hist.setNav(toBigDecimal(item.getNav()));

            count += fundPerfHistMapper.mergeFundPerfHist(hist);
        }

        return count;
    }

    private BigDecimal toBigDecimal(String value) {
        if (value == null || value.isBlank() || "-".equals(value)) {
            return null;
        }

        return new BigDecimal(value.replace(",", ""));
    }

    public List<FundMaster> list() {
        return mapper.selectAll();
    }

    public int batchInsertRange(String fromDt, String toDt) {

        LocalDate start = LocalDate.parse(fromDt, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate end = LocalDate.parse(toDt, DateTimeFormatter.BASIC_ISO_DATE);

        int totalCnt = 0;

        while (!start.isAfter(end)) {

            String basDd = start.format(DateTimeFormatter.BASIC_ISO_DATE);

            try {
                totalCnt += batchInsert(basDd);
            } catch (Exception e) {
                System.out.println("배치 실패 기준일 : " + basDd);
                e.printStackTrace();
            }

            start = start.plusDays(1);
        }

        return totalCnt;
    }
}