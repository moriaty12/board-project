package finance.board.mapper.dto;

public class OrderBookDto {

    private int price;      // 호가 (가격)
    private int bidQty;     // 매수 잔량
    private int askQty;     // 매도 잔량

    public OrderBookDto() {}

    public OrderBookDto(int price, int bidQty, int askQty) {
        this.price = price;
        this.bidQty = bidQty;
        this.askQty = askQty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBidQty() {
        return bidQty;
    }

    public void setBidQty(int bidQty) {
        this.bidQty = bidQty;
    }

    public int getAskQty() {
        return askQty;
    }

    public void setAskQty(int askQty) {
        this.askQty = askQty;
    }

    @Override
    public String toString() {
        return "OrderBookDto{" +
                "price=" + price +
                ", bidQty=" + bidQty +
                ", askQty=" + askQty +
                '}';
    }
}
