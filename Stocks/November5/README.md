# November 5th Update

We parsed the response of a Yahoo API call to retrieve the live data of stocks as opposed to the data beforehand that we got from some random website on the internet--which was very bad because the information was ancient and that's not what you want when stocks change by the second.

The information was reorganized into a nested dictionary structure as opposed to the previous dictionary in list structure to allow for the quick retrieval of stock information by accessing the tickers.

We made a curated selection of high-value tickers in a text file and then we passed the ticker information into the API call in order to retrieve relevant information about each stock.

This is a sample of how our data looks like now for a single stock:

```json
{
  "tickerName" : {
    "Name": "company name",
    "Price": "current price of stock",
    "52 Week High": "the highest price of the stock within the year",
    "52 Week Low": "the lowest price of the stock within the year",
    "Market Cap": "the total value of the company's shares of stock"
  }
}
```

## Next Steps:

Our next step is to incorporate the updated API information into our previous function calls in order to support our new data structure.

We will also be converting the python code into Java to reflect the change in our course.
