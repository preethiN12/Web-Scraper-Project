public class Stock {
    String ticker;
    String name;
    String exchange;
    double yearHigh;
    double yearLow;
    double marketCap;
    double marketPrice;

    public Stock(String ticker, String name, String exchange, double yearHigh, double yearLow, double marketCap, double marketPrice) {
        this.ticker = ticker;
        this.name = name;
        this.exchange = exchange;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
        this.marketCap = marketCap;
        this.marketPrice = marketPrice;
    }

    @Override
    public String toString() {
        return String.format("Ticker: %s \nName: %s \nExchange: %s " +
                "\n52 Week High: $%,.2f \n52 Week Low: $%,.2f \nMarket Cap: $%,.2f " +
                "\nMarket Price: $%,.2f", ticker, name, exchange, yearHigh, yearLow, marketCap, marketPrice);
    }
}
