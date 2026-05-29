package finance.board.domain;

import lombok.Data;

@Data
public class FundMaster {

    private String fundCd;      // 상품코드
    private String fundNm;      // 상품명

    private String fundTpCd;    // ETF/FUND
    private String mngCoCd;     // 운용사코드

    private String riskGrdCd;   // 위험등급

    private String listDt;      // 상장일
    private String curCd;       // 통화

    private String dataCrtUsrId;
    private String dataChgUsrId;
    private String lastSrcNm;

}