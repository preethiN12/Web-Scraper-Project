import java.util.HashMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Database {
    HashMap<String, Stock> stocks;

    public Database() {
        stocks = new HashMap<>();
    }

    public boolean addStock(String ticker) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/v2/get-quotes?symbols="+ticker+"&region=US"))
                    .header("x-rapidapi-key", "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8")
                    .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String content = response.body().substring(17,response.body().length() - 1);

            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
            JsonObject stockInfo = jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject();

            String symbol = stockInfo.get("symbol").toString();
            String name = stockInfo.get("longName").toString();
            String exchangeName = stockInfo.get("fullExchangeName").toString();
            double fiftyTwoWeekHigh = Double.parseDouble(stockInfo.get("fiftyTwoWeekHigh").toString());
            double fiftyTwoWeekLow = Double.parseDouble(stockInfo.get("fiftyTwoWeekLow").toString());
            double marketCap = Double.parseDouble(stockInfo.get("marketCap").toString());
            double marketPrice = Double.parseDouble(stockInfo.get("regularMarketPrice").toString());

            Stock stockModel = new Stock(symbol,name,exchangeName,fiftyTwoWeekHigh,fiftyTwoWeekLow,marketCap, marketPrice);
            stocks.put(ticker.toUpperCase(),stockModel);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
