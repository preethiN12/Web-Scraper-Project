public class Stock {
    String ticker;
    String name;
    String exchange;
    double yearHigh;
    double yearLow;
    double marketCap;

    public Stock(String ticker, String name, String exchange, double yearHigh, double yearLow, double marketCap) {
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", exchange='" + exchange + '\'' +
                ", yearHigh=" + yearHigh +
                ", yearLow=" + yearLow +
                ", marketCap=" + marketCap +
                '}';
    }
}
