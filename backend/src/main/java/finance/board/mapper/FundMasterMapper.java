package finance.board.mapper;

import finance.board.domain.FundMaster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundMasterMapper {

    int insertFundMaster(FundMaster fund);

    List<FundMaster> selectAll();

}