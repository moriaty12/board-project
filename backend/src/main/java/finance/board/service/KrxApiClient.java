package finance.board.service;

import finance.board.mapper.dto.KrxEtfResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class KrxApiClient {

    private final RestClient restClient = RestClient.create();

    @Value("${krx.api.auth-key}")
    private String authKey;

    @Value("${krx.api.etf-url}")
    private String etfUrl;

    public KrxEtfResponse getEtfDailyTrade(String basDd) {
        return restClient.get()
                .uri(etfUrl + "?basDd=" + basDd)
                .header("AUTH_KEY", authKey)
                .retrieve()
                .body(KrxEtfResponse.class);
    }
}