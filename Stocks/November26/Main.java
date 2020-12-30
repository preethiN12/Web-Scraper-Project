import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        try {
            database.addStocks();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}