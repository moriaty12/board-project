package finance.board.mapper;

import finance.board.domain.FundPerfHist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FundPerfHistMapper {
    int mergeFundPerfHist(FundPerfHist item);

    int updateReturnRateByRange(String fromDt, String toDt);
}
