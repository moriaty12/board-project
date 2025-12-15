package finance.board.service;

import finance.board.mapper.dto.InvestQuoteResponse;
import finance.board.mapper.dto.OrderBookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestQuoteService {

    /**
     * 실제 API 연동 전까지는 Mock 데이터 기반으로 시연용 구현
     */
    public InvestQuoteResponse getQuoteData(String ticker) {

        if (ticker.equalsIgnoreCase("005930")) { // 삼성전자
            List<OrderBookDto> orderBook = List.of(
                    new OrderBookDto(75300, 2500, 1200),
                    new OrderBookDto(75200, 3200, 1800),
                    new OrderBookDto(75100, 4000, 2400),
                    new OrderBookDto(75000, 4600, 2900)
            );

            return new InvestQuoteResponse(
                    "005930",
                    "삼성전자",
                    75300,
                    74900,
                    0.53,
                    8123400,
                    orderBook
            );
        }

        if (ticker.equalsIgnoreCase("000660")) { // SK하이닉스
            List<OrderBookDto> orderBook = List.of(
                    new OrderBookDto(145000, 3100, 2100),
                    new OrderBookDto(144500, 4200, 2800),
                    new OrderBookDto(144000, 5100, 3500)
            );

            return new InvestQuoteResponse(
                    "000660",
                    "SK하이닉스",
                    145000,
                    144000,
                    0.69,
                    5321200,
                    orderBook
            );
        }

        // 기본 응답 (없는 종목코드)
        return new InvestQuoteResponse(
                ticker,
                "Unknown",
                0,
                0,
                0.0,
                0,
                List.of()
        );
    }
}
