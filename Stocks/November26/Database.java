import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Database {
    HashMap<String, Stock> stocks;

    public void addStocks() throws IOException, InterruptedException {
        String ticker = "AMD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/v2/get-quotes?symbols="+ticker+"&region=US"))
                .header("x-rapidapi-key", "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        String content = response.body().substring(17,response.body().length() - 1);
        System.out.println(content);
        Gson gson = new Gson();
        Stock stock = gson.fromJson(content, Stock.class);
        System.out.println(stock);

// Possible parsing methodology
//        JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
//        System.out.println(jsonObject.get("result").getAsJsonArray().get(0).getAsJsonObject().get("language"));
    }

}
