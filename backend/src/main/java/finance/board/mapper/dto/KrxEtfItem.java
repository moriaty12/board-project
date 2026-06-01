package finance.board.mapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KrxEtfItem {

    @JsonProperty("BAS_DD")
    private String basDd;

    @JsonProperty("ISU_CD")
    private String isuCd;

    @JsonProperty("ISU_NM")
    private String isuNm;

    @JsonProperty("TDD_CLSPRC")
    private String tddClsprc;

    @JsonProperty("NAV")
    private String nav;
}