package finance.board.mapper.dto;

import lombok.Data;
import java.util.List;

@Data
public class KrxEtfResponse {
    private List<KrxEtfItem> OutBlock_1;
}