import java.util.Scanner;

public class Main {
    static Database database;
    static Scanner scanner;

    public static void main(String[] args) {
        database = new Database();
        scanner = new Scanner(System.in);
        boolean programIsRunning = true;

        System.out.println("Welcome to your personal stock tracker!");
        System.out.print("You currently are not tracking any stocks, so let's start by adding a stock to your tracker. ");
        addStock();

        System.out.println("\nAwesome! You now have access to all the features of this tracker. Pick an option from below to start.");

        int choice;
        boolean isValidInputType;

        while (programIsRunning) {
            printOptions();
            choice = 0;
            isValidInputType = false;

            while (!choiceIsValid(choice) || !isValidInputType) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = scanner.nextInt();
                    isValidInputType = true;
                    scanner.nextLine(); //Gets rid of rogue \n character

                    if(!choiceIsValid(choice)) {
                        System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("You're only allowed to enter an integer representing your choice. Please try again.");
                    scanner.nextLine(); //Gets rid of rogue \n character
                }
            }

            switch(choice) {
                case 1:
                    addStock();
                    break;

                case 2:
                    getStockInfo();
                    break;

                case 3:
                    largestMarketPrice();
                    break;

                case 4:
                    largestMarketCap();
                    break;

                case 5:
                    smallestMarketCap();
                    break;

                case 6:
                    largestYearHigh();
                    break;

                case 7:
                    smallestYearLow();
                    break;

                case 8:
                    programIsRunning = false;
                    break;
            }
        }
        System.out.println("\n\nGoodbye! \n\nPs. also all your data was lost.....sorry :/");

    }

    public static void addStock() {
        System.out.print("\n\nEnter ticker name to add to database: ");
        String ticker = scanner.nextLine();
        boolean stockAdded = database.addStock(ticker);
        while (!stockAdded) {
            System.out.print("Invalid ticker. Please re-enter: ");
            ticker = scanner.nextLine();
            stockAdded = database.addStock(ticker);
        }

        System.out.println("Stock "+ database.stocks.get(ticker.toUpperCase()).ticker +" added successfully.");
    }

    public static void getStockInfo() {
        System.out.print("\nEnter name of ticker in database to get info: ");
        String ticker = scanner.nextLine();

        if (database.stocks.containsKey(ticker.toUpperCase())) {
            System.out.println(database.stocks.get(ticker.toUpperCase()));
        }
        else {
            System.out.println("This ticker doesn't exist in the database. Pick choice 1 to add it.");
        }
    }

    public static void largestMarketPrice() {
        String name = "";
        double largest = 0;
        for (String stockName : database.stocks.keySet()) {
            Stock stock = database.stocks.get(stockName);

            if (stock.marketPrice > largest) {
                largest = stock.marketPrice;
                name = stock.name;
            }
        }
        System.out.printf("\n\nName: %s \nMarket Price: %,.2f%n",name, largest);
    }

    public static void largestMarketCap() {
        String name = "";
        double largest = 0;
        for (String stockName : database.stocks.keySet()) {
            Stock stock = database.stocks.get(stockName);

            if (stock.marketCap > largest) {
                largest = stock.marketCap;
                name = stock.name;
            }
        }
        System.out.printf("\n\nName: %s \nMarket Cap: %,.2f%n",name, largest);
    }

    public static void smallestMarketCap() {
        String name = "";
        double smallest = Double.MAX_VALUE;
        for (String stockName : database.stocks.keySet()) {
            Stock stock = database.stocks.get(stockName);

            if (stock.marketCap < smallest) {
                smallest = stock.marketCap;
                name = stock.name;
            }
        }
        System.out.printf("\n\nName: %s \nMarket Cap: %,.2f%n",name, smallest);
    }

    public static void largestYearHigh() {
        String name = "";
        double largest = 0;
        for (String stockName : database.stocks.keySet()) {
            Stock stock = database.stocks.get(stockName);

            if (stock.yearHigh > largest) {
                largest = stock.yearHigh;
                name = stock.name;
            }
        }
        System.out.printf("\n\nName: %s \n52 Week High: %,.2f%n",name, largest);
    }

    public static void smallestYearLow() {
        String name = "";
        double smallest = Double.MAX_VALUE;
        for (String stockName : database.stocks.keySet()) {
            Stock stock = database.stocks.get(stockName);

            if (stock.yearLow < smallest) {
                smallest = stock.yearLow;
                name = stock.name;
            }
        }
        System.out.printf("\n\nName: %s \n52 Week Low: %,.2f%n",name, smallest);
    }

    public static void printOptions() {
        System.out.println("\n1. Add stock to database");
        System.out.println("2. Get stock info");
        System.out.println("3. Get largest Market Price");
        System.out.println("4. Get largest Market Cap");
        System.out.println("5. Get smallest Market Cap");
        System.out.println("6. Get highest 52 Week High");
        System.out.println("7. Get lowest 52 Week Low");
        System.out.println("8. Quit");
    }

    public static boolean choiceIsValid(int choice) {
        int[] validChoices = {1,2,3,4,5,6,7,8};
        for (int number : validChoices) {
            if (number == choice) {
                return true;
            }
        }
        return false;
    }

}