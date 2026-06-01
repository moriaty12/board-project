package finance.board.mapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KrxEtfResponse {

    @JsonProperty("OutBlock_1")
    private List<KrxEtfItem> outBlock1;
}