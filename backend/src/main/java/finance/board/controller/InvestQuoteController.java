package finance.board.controller;

import finance.board.mapper.dto.InvestQuoteResponse;
import finance.board.service.InvestQuoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "http://localhost:5173") // React 개발 서버 허용 (CORS)
public class InvestQuoteController {

    private final InvestQuoteService investQuoteService;

    public InvestQuoteController(InvestQuoteService investQuoteService) {
        this.investQuoteService = investQuoteService;
    }

    /**
     * 특정 종목코드의 호가창(시세) 데이터 조회
     * 예: GET /api/quotes/005930
     */
    @GetMapping("/{ticker}")
    public InvestQuoteResponse getQuote(@PathVariable String ticker) {
        return investQuoteService.getQuoteData(ticker);
    }
}
