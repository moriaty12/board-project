package finance.board.mapper.dto;

import java.util.List;

public class InvestQuoteResponse {

    private String ticker;        // 종목코드 (예: 005930)
    private String name;          // 종목명 (예: 삼성전자)
    private int currentPrice;     // 현재가
    private int prevClose;        // 전일 종가
    private double changeRate;    // 등락률
    private long volume;          // 거래량
    private List<OrderBookDto> orderBook;  // 매수/매도 잔량 리스트

    public InvestQuoteResponse() {}

    public InvestQuoteResponse(String ticker, String name, int currentPrice, int prevClose,
                               double changeRate, long volume, List<OrderBookDto> orderBook) {
        this.ticker = ticker;
        this.name = name;
        this.currentPrice = currentPrice;
        this.prevClose = prevClose;
        this.changeRate = changeRate;
        this.volume = volume;
        this.orderBook = orderBook;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(int prevClose) {
        this.prevClose = prevClose;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public List<OrderBookDto> getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(List<OrderBookDto> orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public String toString() {
        return "InvestQuoteResponse{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", prevClose=" + prevClose +
                ", changeRate=" + changeRate +
                ", volume=" + volume +
                ", orderBook=" + orderBook +
                '}';
    }
}
