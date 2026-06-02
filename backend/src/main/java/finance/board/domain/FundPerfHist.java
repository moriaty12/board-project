package finance.board.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FundPerfHist {

    private String fundCd;
    private LocalDate baseDt;

    private BigDecimal clsPrc;
    private BigDecimal nav;

    private BigDecimal rtn1m;
    private BigDecimal rtn3m;
    private BigDecimal rtn6m;
    private BigDecimal rtn12m;

    public FundPerfHist() {
    }
}
