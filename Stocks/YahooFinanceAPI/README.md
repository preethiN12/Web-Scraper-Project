# Using the Live Yahoo Finance API

We will be using [this](https://rapidapi.com/apidojo/api/yahoo-finance1) API, powered by Yahoo Finance, in order to get the latest data on any stock.

# Preparation

In order to make HTTP requests, you would need to install the requests module for python.

```python
pip install requests
```

You would also need an API Key to connect to the API.

***Hint:** API keys are a unique identifier used to identify who's making calls/requests to the API.*

You would need to make an account with Rapid API (The company providing the API service) to get an API key, but since I already made an account, we can use the API key I was given:

```python
'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
```

[Here's](https://rapidapi.com/apidojo/api/yahoo-finance1/pricing) where you'd make an account (I signed up for a basic plan)

# Queries

The API has several options for querying its database. I've gathered information about the relevant ones that we could use for our project.

### get-quotes Market Query

We also have an option of getting info about a list of stocks. (Not sure if there's a limit on the list)

```python
import requests

url = "https://rapidapi.p.rapidapi.com/market/v2/get-quotes"

querystring = {"symbols":"AMZN,IBM,AAPL","region":"US"}

headers = {
    'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
    'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
```

We would need a pre-selected list of tickers to give to the query. Region is optional here.
<details>
  <summary>Here's response of the above request</summary>

```json
    {
      "quoteResponse": {
        "result": [
          {
            "language": "en-US",
            "region": "US",
            "quoteType": "EQUITY",
            "quoteSourceName": "Nasdaq Real Time Price",
            "triggerable": true,
            "quoteSummary": {
              "earnings": {
                "maxAge": 86400,
                "earningsChart": {
                  "quarterly": [
                    {
                      "date": "3Q2019",
                      "actual": 4.23,
                      "estimate": 4.62
                    },
                    {
                      "date": "4Q2019",
                      "actual": 6.47,
                      "estimate": 4.03
                    },
                    {
                      "date": "1Q2020",
                      "actual": 5.01,
                      "estimate": 6.25
                    },
                    {
                      "date": "2Q2020",
                      "actual": 10.3,
                      "estimate": 1.46
                    }
                  ],
                  "currentQuarterEstimate": 7.25,
                  "currentQuarterEstimateDate": "3Q",
                  "currentQuarterEstimateYear": 2020,
                  "earningsDate": [
                    1603929600
                  ]
                },
                "financialsChart": {
                  "yearly": [
                    {
                      "date": 2016,
                      "revenue": 135987000000,
                      "earnings": 2371000000
                    },
                    {
                      "date": 2017,
                      "revenue": 177866000000,
                      "earnings": 3033000000
                    },
                    {
                      "date": 2018,
                      "revenue": 232887000000,
                      "earnings": 10073000000
                    },
                    {
                      "date": 2019,
                      "revenue": 280522000000,
                      "earnings": 11588000000
                    }
                  ],
                  "quarterly": [
                    {
                      "date": "3Q2019",
                      "revenue": 69981000000,
                      "earnings": 2134000000
                    },
                    {
                      "date": "4Q2019",
                      "revenue": 87436000000,
                      "earnings": 3268000000
                    },
                    {
                      "date": "1Q2020",
                      "revenue": 75452000000,
                      "earnings": 2535000000
                    },
                    {
                      "date": "2Q2020",
                      "revenue": 88912000000,
                      "earnings": 5243000000
                    }
                  ]
                },
                "financialCurrency": "USD"
              }
            },
            "currency": "USD",
            "heldPercentInsiders": 15.122,
            "heldPercentInstitutions": 57.689,
            "regularMarketChange": -25.988281,
            "regularMarketChangePercent": -0.815974,
            "regularMarketTime": 1603394147,
            "regularMarketPrice": 3158.9517,
            "regularMarketDayHigh": 3198.75,
            "regularMarketDayRange": "3121.94 - 3198.75",
            "regularMarketDayLow": 3121.94,
            "regularMarketVolume": 3235818,
            "sharesShort": 2748588,
            "sharesShortPrevMonth": 2035049,
            "shortPercentFloat": 0.65,
            "regularMarketPreviousClose": 3184.94,
            "bid": 3169.12,
            "ask": 3169,
            "bidSize": 9,
            "askSize": 30,
            "exchange": "NMS",
            "market": "us_market",
            "messageBoardId": "finmb_18749",
            "fullExchangeName": "NasdaqGS",
            "shortName": "Amazon.com, Inc.",
            "longName": "Amazon.com, Inc.",
            "regularMarketOpen": 3189.87,
            "averageDailyVolume3Month": 4878816,
            "averageDailyVolume10Day": 5743300,
            "beta": 1.353006,
            "fiftyTwoWeekLowChange": 1532.9216,
            "fiftyTwoWeekLowChangePercent": 0.94273883,
            "fiftyTwoWeekRange": "1626.03 - 3552.25",
            "fiftyTwoWeekHighChange": -393.29834,
            "fiftyTwoWeekHighChangePercent": -0.110718094,
            "fiftyTwoWeekLow": 1626.03,
            "fiftyTwoWeekHigh": 3552.25,
            "earningsTimestamp": 1604001600,
            "earningsTimestampStart": 1604001600,
            "earningsTimestampEnd": 1604001600,
            "trailingPE": 121.325485,
            "pegRatio": 2.94,
            "dividendsPerShare": 0,
            "revenue": 321781989000,
            "firstTradeDateMilliseconds": 863703000000,
            "priceHint": 2,
            "totalCash": 71391003000,
            "floatShares": 425265331,
            "ebitda": 39574999040,
            "shortRatio": 0.5,
            "preMarketChange": 4.53003,
            "preMarketChangePercent": 0.142233,
            "preMarketTime": 1603373399,
            "targetPriceHigh": 4500,
            "targetPriceLow": 2646,
            "targetPriceMean": 3724.98,
            "targetPriceMedian": 3700,
            "preMarketPrice": 3189.47,
            "twoHundredDayAverage": 2856.3691,
            "twoHundredDayAverageChange": 302.58252,
            "twoHundredDayAverageChangePercent": 0.10593257,
            "forwardPE": 71.19566,
            "priceToBook": 21.46581,
            "sourceInterval": 15,
            "exchangeDataDelayedBy": 0,
            "exchangeTimezoneName": "America/New_York",
            "exchangeTimezoneShortName": "EDT",
            "pageViews": {
              "midTermTrend": "UP",
              "longTermTrend": "UP",
              "shortTermTrend": "UP"
            },
            "gmtOffSetMilliseconds": -14400000,
            "esgPopulated": false,
            "tradeable": false,
            "priceToSales": 4.917265,
            "marketState": "REGULAR",
            "epsTrailingTwelveMonths": 26.037,
            "epsForward": 44.37,
            "epsCurrentYear": 31.75,
            "epsNextQuarter": 8.87,
            "priceEpsCurrentYear": 99.49454,
            "priceEpsNextQuarter": 356.13885,
            "sharesOutstanding": 500889984,
            "bookValue": 147.162,
            "fiftyDayAverage": 3190.4482,
            "fiftyDayAverageChange": -31.496582,
            "fiftyDayAverageChangePercent": -0.00987215,
            "marketCap": 1582287290368,
            "components": [
              "^NQDMXJPLMAUD",
              "^NQDOG",
              "^NQUSBLM",
              "^NQNA5300LMCADN",
              "^QIV",
              "^NQDXUSMLTCGN",
              "^NQUS500LCGN",
              "^NQDM5000LMGBPN",
              "^NQUSB5370LMEURN",
              "^NQGMOIN",
              "^NQUSB5000LM",
              "^NQUSB5370LMN",
              "^NQGS",
              "^NQDM5300LMAUDN",
              "^NQNALMEURN",
              "^NQUSBLMCAD",
              "^AZA",
              "^NQDMXKRJPYN",
              "^NQDMXKRLMAUDN",
              "^NQNA5000LMAUDN",
              "^NQUSB5300LMN",
              "^NQUSB5300LMAUDN",
              "^NQDMXJPLMAUDN",
              "^NQDMXKRLMAUD",
              "^NQUSBLMJPY",
              "^NQG5300LMGBP",
              "^NDXCHF",
              "^NQUSB5000LMGBPN",
              "^NQUSB5370LMGBP",
              "^NQDM5000LM",
              "^NQDM5000LMGBP",
              "^NQGXGBLMN",
              "^NQUSB5373LMGBPN",
              "^NQDMXKRLCJPY",
              "^NQG5000LMEUR",
              "^WEALTHGN",
              "^NQDXUSLCEUR",
              "^NQG5000LMCAD",
              "^WEALTHGL",
              "^NQDXUSLCG",
              "^NQUSB5373LM",
              "^CPQ",
              "^CPQNTR",
              "^NQNA5000LMAUD",
              "^NQDM5000LMN",
              "^NQDMXKRAUD",
              "^NQNA5300LM",
              "^NQUSB5373LMAUDN",
              "^NQDMXKRLMGBPN",
              "^NQGXGBLMGBPN",
              "^NQNA5000LMCADN",
              "^NQNA5300LMAUDN",
              "^NQGXJPLMJPYN",
              "^NQNALMCADN",
              "^NQUSBLMEUR",
              "^NQG5300LMN",
              "^NQNALMJPY",
              "^NQG5300LMAUD",
              "^DWANQTL",
              "^MSH",
              "^NDX",
              "^NQG5000LMJPY",
              "^NQGXGBLMJPY",
              "^NQUSB5373LMAUD",
              "^NQGXJPLMJPY",
              "^NQUSB5370LMAUD",
              "^NQUSB5300LMEUR",
              "^NQDMXKR",
              "^NQDMXGBLMCADN",
              "^NQUSB5300LMCAD",
              "^NQDM5300LMJPY",
              "^NQDMXKRLCN",
              "^NQGXGBLMEURN",
              "^NQGXJPLMCAD",
              "^NQUSB5000LMGBP",
              "^NQGXJPLMEUR",
              "^XNDXNNRCHF",
              "^NQUSB5373LMEUR",
              "^NQUSB5300LMCADN",
              "^NQDMXJPLMGBPN",
              "^NQG5300LMJPYN",
              "^NQUSB5300LMJPY",
              "^NQDMXJPLMN",
              "^NQUSB5373LMCAD",
              "^NQNA5000LMJPY",
              "^NQUSB5373LMCADN",
              "^NQDMXKRLCJPYN",
              "^NQDMXKRLMCADN",
              "^NQNA5000LMGBPN",
              "^NQDMXKRLCEUR",
              "^NQNA5300LMJPY",
              "^NQDXUSLC",
              "^NQGXGBLMJPYN",
              "^NQG5300LMEURN",
              "^NQUSB5370LMCADN",
              "^NQUSBLMEURN",
              "^INDS",
              "^NQDMXKRJPY",
              "^NQDMXKRLCCAD",
              "^NQDMXKRLCEURN",
              "^NQDM5300LMN",
              "^NQUSMLTCG",
              "^NQGXJPLMGBPN",
              "^QMI",
              "^IXIC",
              "^NQDM5300LMCAD",
              "^NQNALM",
              "^NQUS500LC",
              "^NQDM5300LMCADN",
              "^NQDM5300LMEUR",
              "^NQDMXGBLMJPY",
              "^NQFFUSGN",
              "^NQNALMAUD",
              "^NQDXUSLCN",
              "^NQG5000LMEURN",
              "^NQGXGBLMAUD",
              "^NQUSB5373LMJPY",
              "^NQUSBLMN",
              "^NQDMXJPLMGBP",
              "^NQNA5300LMCAD",
              "^NQUSB5000LMAUD",
              "^NQG5000LMJPYN",
              "^NQDMXKRLMEUR",
              "^MNX1",
              "^NQUSB5000LMEURN",
              "^NQNALMAUDN",
              "^NQUSB5370LMAUDN",
              "^NQDM5000LMCAD",
              "^NQDMXKRLMCAD",
              "^NQDMXGBLM",
              "^NQNA5300LMEUR",
              "^NQNA5300LMGBPN",
              "^NQNA5300LMN",
              "^AMZSY",
              "^NQDMXGBLMJPYN",
              "^NQDOGN",
              "^NQDM5000LMEUR",
              "^NQDM5300LM",
              "^NQDM5000LMJPYN",
              "^NQDMXKRLMJPY",
              "^NQG5000LM",
              "^NQSSRE",
              "^NQUSBLMJPYN",
              "^NQDMXGBLMCAD",
              "^NQUSB5000LMJPYN",
              "^XNDXNNRGBP",
              "^NQUSLG",
              "^NQDMXGBLMEURN",
              "^NQDMXKRGBPN",
              "^NQDMXGBLMEUR",
              "^XNDXNNR",
              "^NQDM5000LMEURN",
              "^NQUSB5300LMEURN",
              "^RMIVG20",
              "^NQDMXKRAUDN",
              "^NQUSB5373LMEURN",
              "^NQDMXKRLMJPYN",
              "^NQUSBLMCADN",
              "^NQDMXGBLMN",
              "^NQG5300LMCADN",
              "^NQNALMGBPN",
              "^NQGXGBLMCADN",
              "^NQUSB5370LM",
              "^NQDMXKRLCCADN",
              "^NQGXJPLMCADN",
              "^NQGXJPLM",
              "^NQUSB5370LMGBPN",
              "^NQG5300LM",
              "^NQUSB5000LMN",
              "^NQG5300LMJPY",
              "^NQUSBLMGBP",
              "^NQUSB5300LMJPYN",
              "^NQDM5300LMEURN",
              "^NQNA5300LMAUD",
              "^NQNALMN",
              "^NQG5000LMCADN",
              "^RCH",
              "^NQUSLGN",
              "^NQDM5300LMJPYN",
              "^NQUSB5373LMN",
              "^NQUSB5370LMJPY",
              "^NQDM5000LMJPY",
              "^NQG5300LMCAD",
              "^NQGXJPLMAUDN",
              "^NQUSB5370LMEUR",
              "^NQUSB5000LMCADN",
              "^NQUSB5370LMCAD",
              "^NQDMXKRLCGBP",
              "^NQDMXKRLM",
              "^NQUSMLTCGN",
              "^NQDMXKRLC",
              "^NQNALMGBP",
              "^NDXEUR",
              "^NDXHKD",
              "^NQUSB5300LMAUD",
              "^NQDMXJPLMJPYN",
              "^NQGXGBLM",
              "^NQNA5000LMCAD",
              "^NQGMOI",
              "^NQDMXKRN",
              "^NQNA5000LMEUR",
              "^QTW",
              "^XQC",
              "^NQDM5000LMCADN",
              "^NQDMXJPLMEURN",
              "^NDXCAD",
              "^NQDXUSMLTCG",
              "^NQFFUSMN",
              "^NQDMXJPLM",
              "^NQG5000LMN",
              "^NQDMXKREUR",
              "^NQGXJPLMGBP",
              "^NQDMXKRLMEURN",
              "^NQUSBLMAUD",
              "^NQG5000LMGBP",
              "^NQGXGBLMGBP",
              "^NQUSB5373LMJPYN",
              "^NQDMXKRCAD",
              "^XQO",
              "^NQG5300LMEUR",
              "^NQDM5300LMGBP",
              "^NQDXUSLCEURN",
              "^NQUSB5000LMJPY",
              "^NQG5000LMGBPN",
              "^NQDMXKRLCAUD",
              "^XCQ",
              "^NQDXUSMEGAN",
              "^NQNALMCAD",
              "^NQNA5000LMGBP",
              "^NQUSB5300LMGBP",
              "^NQNA5300LMEURN",
              "^NQNA5000LM",
              "^NQGXJPLMEURN",
              "^NQNA5300LMGBP",
              "^NQUSB5300LM",
              "^NQDXUSLCGBP",
              "^NQGXJPLMN",
              "^NQNALMEUR",
              "^NDXGBP",
              "^NQNA5300LMJPYN",
              "^NQFFUSG",
              "^NQGXGBLMEUR",
              "^NQDMXKRGBP",
              "^NQUSB5000LMAUDN",
              "^XNDXNNRHKD",
              "^NQFFUSM",
              "^NQDMXGBLMGBPN",
              "^XNDXNNREUR",
              "^NQDMXKRCADN",
              "^NQGXGBLMCAD",
              "^NQDMXGBLMGBP",
              "^NQDMXKRLCAUDN",
              "^XNDXNNRCAD",
              "^NQDXUSLCGBPN",
              "^NQG5000LMAUD",
              "^NQDM5300LMAUD",
              "^NQUSB5000LMCAD",
              "^NQUSB5373LMGBP",
              "^NQUSB5000LMEUR",
              "^NQUSBLMGBPN",
              "^QNET",
              "^NQG5300LMGBPN",
              "^NQDMXKRLMN",
              "^NQGXJPLMAUD",
              "^NQDMXGBLMAUDN",
              "^NQDMXJPLMJPY",
              "^NQDMXKRLCGBPN",
              "^NQNA5000LMJPYN",
              "^NDXX",
              "^NQDXUSLCGN",
              "^NQDM5000LMAUDN",
              "^NQUS500LCG",
              "^NDXE",
              "^NQDMXKREURN",
              "^NQNALMJPYN",
              "^NQG5000LMAUDN",
              "^NQDMXJPLMCADN",
              "^NQNA5000LMEURN",
              "^RCHNTR",
              "^NQSSREN",
              "^NQDMXGBLMAUD",
              "^NQNA5000LMN",
              "^NQUSBLMAUDN",
              "^NQG5300LMAUDN",
              "^DWUSSR",
              "^NQDMXJPLMCAD",
              "^NQUSB5370LMJPYN",
              "^NQDMXJPLMEUR",
              "^NQDXUSMEGA",
              "^NQDMXKRLMGBP",
              "^NQGXGBLMAUDN",
              "^NQUSB5300LMGBPN",
              "^NQUS500LCN",
              "^NQDM5300LMGBPN",
              "^NQDM5000LMAUD"
            ],
            "symbol": "AMZN"
          },
          {
            "language": "en-US",
            "region": "US",
            "quoteType": "EQUITY",
            "quoteSourceName": "Nasdaq Real Time Price",
            "triggerable": true,
            "quoteSummary": {
              "earnings": {
                "maxAge": 86400,
                "earningsChart": {
                  "quarterly": [
                    {
                      "date": "3Q2019",
                      "actual": 2.68,
                      "estimate": 2.67
                    },
                    {
                      "date": "4Q2019",
                      "actual": 4.71,
                      "estimate": 4.68
                    },
                    {
                      "date": "1Q2020",
                      "actual": 1.84,
                      "estimate": 1.79
                    },
                    {
                      "date": "2Q2020",
                      "actual": 2.18,
                      "estimate": 2.07
                    }
                  ],
                  "currentQuarterEstimate": 2.58,
                  "currentQuarterEstimateDate": "3Q",
                  "currentQuarterEstimateYear": 2020,
                  "earningsDate": [
                    1611187200
                  ]
                },
                "financialsChart": {
                  "yearly": [
                    {
                      "date": 2016,
                      "revenue": 79919000000,
                      "earnings": 11872000000
                    },
                    {
                      "date": 2017,
                      "revenue": 79139000000,
                      "earnings": 5753000000
                    },
                    {
                      "date": 2018,
                      "revenue": 79591000000,
                      "earnings": 8728000000
                    },
                    {
                      "date": 2019,
                      "revenue": 77147000000,
                      "earnings": 9431000000
                    }
                  ],
                  "quarterly": [
                    {
                      "date": "4Q2019",
                      "revenue": 21777000000,
                      "earnings": 3670000000
                    },
                    {
                      "date": "1Q2020",
                      "revenue": 17571000000,
                      "earnings": 1175000000
                    },
                    {
                      "date": "2Q2020",
                      "revenue": 18123000000,
                      "earnings": 1361000000
                    },
                    {
                      "date": "3Q2020",
                      "revenue": 17560000000,
                      "earnings": 1698000000
                    }
                  ]
                },
                "financialCurrency": "USD"
              }
            },
            "currency": "USD",
            "heldPercentInsiders": 0.108,
            "heldPercentInstitutions": 58.555,
            "regularMarketChange": 0.4200058,
            "regularMarketChangePercent": 0.365032,
            "regularMarketTime": 1603394155,
            "regularMarketPrice": 115.48,
            "regularMarketDayHigh": 115.56,
            "regularMarketDayRange": "112.98 - 115.56",
            "regularMarketDayLow": 112.98,
            "regularMarketVolume": 6149301,
            "sharesShort": 21800506,
            "sharesShortPrevMonth": 22629603,
            "shortPercentFloat": 2.45,
            "regularMarketPreviousClose": 115.06,
            "bid": 0,
            "ask": 0,
            "bidSize": 8,
            "askSize": 8,
            "exchange": "NYQ",
            "market": "us_market",
            "messageBoardId": "finmb_112350",
            "fullExchangeName": "NYSE",
            "shortName": "International Business Machines",
            "longName": "International Business Machines Corporation",
            "regularMarketOpen": 115,
            "averageDailyVolume3Month": 4686673,
            "averageDailyVolume10Day": 7573237,
            "beta": 1.157198,
            "fiftyTwoWeekLowChange": 24.920006,
            "fiftyTwoWeekLowChangePercent": 0.27517676,
            "fiftyTwoWeekRange": "90.56 - 158.75",
            "fiftyTwoWeekHighChange": -43.269997,
            "fiftyTwoWeekHighChangePercent": -0.2725669,
            "fiftyTwoWeekLow": 90.56,
            "fiftyTwoWeekHigh": 158.75,
            "dividendDate": 1599696000,
            "exDividendDate": 1596758400,
            "earningsTimestamp": 1611262800,
            "earningsTimestampStart": 1611262800,
            "earningsTimestampEnd": 1611262800,
            "trailingAnnualDividendRate": 6.5,
            "trailingPE": 13.090003,
            "pegRatio": 3.99,
            "dividendsPerShare": 6.5,
            "dividendRate": 6.52,
            "trailingAnnualDividendYield": 0.056492265,
            "dividendYield": 5.67,
            "revenue": 75030004000,
            "firstTradeDateMilliseconds": -252322200000,
            "priceHint": 2,
            "totalCash": 15592999900,
            "floatShares": 890009416,
            "ebitda": 16051999744,
            "shortRatio": 5.37,
            "preMarketChange": 0.0800018,
            "preMarketChangePercent": 0.0695426,
            "preMarketTime": 1603373397,
            "targetPriceHigh": 161,
            "targetPriceLow": 117,
            "targetPriceMean": 136.87,
            "targetPriceMedian": 140,
            "preMarketPrice": 115.12,
            "twoHundredDayAverage": 122.80374,
            "twoHundredDayAverageChange": -7.323738,
            "twoHundredDayAverageChangePercent": -0.059637744,
            "forwardPE": 9.481116,
            "priceToBook": 4.8537326,
            "sourceInterval": 15,
            "exchangeDataDelayedBy": 0,
            "exchangeTimezoneName": "America/New_York",
            "exchangeTimezoneShortName": "EDT",
            "pageViews": {
              "midTermTrend": "UP",
              "longTermTrend": "UP",
              "shortTermTrend": "DOWN"
            },
            "gmtOffSetMilliseconds": -14400000,
            "esgPopulated": false,
            "tradeable": false,
            "priceToSales": 1.3707058,
            "marketState": "REGULAR",
            "epsTrailingTwelveMonths": 8.822,
            "epsForward": 12.18,
            "epsCurrentYear": 11.07,
            "epsNextQuarter": 4.45,
            "priceEpsCurrentYear": 10.431798,
            "priceEpsNextQuarter": 25.950563,
            "sharesOutstanding": 890579008,
            "bookValue": 23.792,
            "fiftyDayAverage": 122.680855,
            "fiftyDayAverageChange": -7.2008514,
            "fiftyDayAverageChangePercent": -0.058695804,
            "marketCap": 102844063744,
            "components": [
              "^NQDMXJPLMAUD",
              "^NQUSBLM",
              "^NQSHYL",
              "^NQUSB9533LMAUD",
              "^NQGMOIN",
              "^NQNALMEURN",
              "^NQUSB9000LMJPYN",
              "^NQUSB9530LM",
              "^NQUSBLMCAD",
              "^NQUSB9000LMEURN",
              "^NQDMXKRJPYN",
              "^NQDMXKRLMAUDN",
              "^NQNA9000LMGBPN",
              "^NQDMXJPLMAUDN",
              "^NQDMXKRLMAUD",
              "^NQFFUSHYN",
              "^NQUSBLMJPY",
              "^NQUSHEIN",
              "^NQNA9000LMEUR",
              "^NQNA9000LMCAD",
              "^NQGXGBLMN",
              "^NQUS500LCVN",
              "^NQUSB9533LMEURN",
              "^NQDMXKRLCJPY",
              "^NQUSB9000LMEUR",
              "^NQDXUSLCEUR",
              "^NQUSB9533LMGBP",
              "^CPQ",
              "^CPQNTR",
              "^NQUSB9000LMCAD",
              "^NQUSB9533LMJPYN",
              "^NQDM9000LMJPY",
              "^NQG9000LMCADN",
              "^NQDMXKRAUD",
              "^NQDMXKRLMGBPN",
              "^NQDXUSMLTCVN",
              "^NQGXGBLMGBPN",
              "^NQDM9000LMEURN",
              "^NQGXJPLMJPYN",
              "^NQNALMCADN",
              "^NQUSBLMEUR",
              "^NQG9000LMGBP",
              "^NQDM9000LMJPYN",
              "^NQNALMJPY",
              "^NQUSHEI",
              "^DAA",
              "^MSH",
              "^NQGXGBLMJPY",
              "^QCRD",
              "^NQGXJPLMJPY",
              "^NQUSB9530LMCAD",
              "^NQUSB9530LMGBPN",
              "^NQDMXKR",
              "^NQDMXGBLMCADN",
              "^NQUSB9530LMEUR",
              "^NQUSHEIEURN",
              "^NQUSB9000LMJPY",
              "^NQDMXKRLCN",
              "^NQGXGBLMEURN",
              "^NQGXJPLMCAD",
              "^NQUSB9530LMN",
              "^NQGXJPLMEUR",
              "^NQUSB9530LMGBP",
              "^NQDMXJPLMGBPN",
              "^NQUSLV",
              "^NQDMXJPLMN",
              "^NQGIHEIGBP",
              "^NQDM9000LMAUD",
              "^NQDMXKRLCJPYN",
              "^NQDMXKRLMCADN",
              "^NQDMXKRLCEUR",
              "^NQUSB9000LMN",
              "^NQDXUSLC",
              "^NQGXGBLMJPYN",
              "^IBMSY",
              "^NQG9000LMJPYN",
              "^NQGIHEIGBPN",
              "^NQUSBLMEURN",
              "^NQDMXKRJPY",
              "^NQDMXKRLCCAD",
              "^NQDMXKRLCEURN",
              "^NQG9000LMAUD",
              "^NQUSHEIGBPN",
              "^NQGXJPLMGBPN",
              "^NQUSB9000LMCADN",
              "^NQNALM",
              "^NQUS500LC",
              "^NQDMXGBLMJPY",
              "^NQUSMLTCV",
              "^NQNALMAUD",
              "^NQNA9000LMN",
              "^NQVMVUS",
              "^NQDXUSLCN",
              "^NQGXGBLMAUD",
              "^NQUSB9530LMJPYN",
              "^NQDXUSLCV",
              "^NQUSBLMN",
              "^NQDMXJPLMGBP",
              "^NQDMXKRLMEUR",
              "^NQNALMAUDN",
              "^NQG9000LMEURN",
              "^NQDM9000LMCADN",
              "^NQFFUSHY",
              "^NQDMXKRLMCAD",
              "^NQDMXGBLM",
              "^NQSHYLN",
              "^NQNA9000LMGBP",
              "^NQDMXGBLMJPYN",
              "^NQG9000LMN",
              "^NQDMXKRLMJPY",
              "^NQUSBLMJPYN",
              "^NQDM9000LMN",
              "^NQDMXGBLMCAD",
              "^XMI",
              "^NQDMXGBLMEURN",
              "^NQDMXKRGBPN",
              "^NQDMXGBLMEUR",
              "^NQDMXKRAUDN",
              "^NQDMXKRLMJPYN",
              "^NQUSBLMCADN",
              "^NQDMXGBLMN",
              "^NQUSB9533LMGBPN",
              "^NQNALMGBPN",
              "^NQGXGBLMCADN",
              "^NQDMXKRLCCADN",
              "^NQGXJPLMCADN",
              "^BGDNTR",
              "^NQUSHEIGBP",
              "^NQGXJPLM",
              "^NQNA9000LMAUD",
              "^NQUSBLMGBP",
              "^NQNALMN",
              "^NQUSB9000LMAUD",
              "^NQNA9000LM",
              "^NQFFUSLV",
              "^NQGXJPLMAUDN",
              "^NQUSLVN",
              "^NQGIHEIN",
              "^NQCAPST",
              "^NQUSB9530LMEURN",
              "^NQ96DIVUS",
              "^NQUSB9530LMAUD",
              "^DJI",
              "^NQDMXKRLCGBP",
              "^NQDMXKRLM",
              "^NQUSB9533LMJPY",
              "^NQDM9000LMGBP",
              "^NQDMXKRLC",
              "^NQNALMGBP",
              "^NQDMXJPLMJPYN",
              "^NQG9000LMEUR",
              "^NQGXGBLM",
              "^NQG9000LMCAD",
              "^NQGMOI",
              "^NQDMXKRN",
              "^NQUSMLTCVN",
              "^NQCRDN",
              "^NQUSB9533LM",
              "^NQDMXJPLMEURN",
              "^NQG9000LMJPY",
              "^NQFFUSLVN",
              "^NQNA9000LMJPYN",
              "^NQDMXJPLM",
              "^NQDMXKREUR",
              "^NQUSB9533LMAUDN",
              "^NQGXJPLMGBP",
              "^NQDM9000LMAUDN",
              "^NQDMXKRLMEURN",
              "^NQUSBLMAUD",
              "^NQGXGBLMGBP",
              "^NQDMXKRCAD",
              "^NQNA9000LMEURN",
              "^DJA",
              "^DAAXMLPREIT",
              "^NQDXUSMLTCV",
              "^NQUSB9533LMCAD",
              "^NQUSB9000LMAUDN",
              "^NQUSB9000LMGBP",
              "^NQDXUSLCEURN",
              "^NQUSB9533LMEUR",
              "^NQNA9000LMAUDN",
              "^NQG9000LMAUDN",
              "^NQDMXKRLCAUD",
              "^NQDXUSMEGAN",
              "^NQNALMCAD",
              "^NQUSB9530LMJPY",
              "^XCI",
              "^NQGXJPLMEURN",
              "^NQDM9000LM",
              "^NQDXUSLCGBP",
              "^NQGXJPLMN",
              "^NQNALMEUR",
              "^NQGXGBLMEUR",
              "^NQDMXKRGBP",
              "^NQDM9000LMEUR",
              "^NQDM9000LMCAD",
              "^NQDMXGBLMGBPN",
              "^BGD",
              "^NQCRD",
              "^NQDMXKRCADN",
              "^NQGXGBLMCAD",
              "^NQDMXGBLMGBP",
              "^NQDMXKRLCAUDN",
              "^NQDM9000LMGBPN",
              "^NQDXUSLCGBPN",
              "^NQG9000LM",
              "^NQUSBLMGBPN",
              "^NQDMXKRLMN",
              "^NQUSB9530LMCADN",
              "^NQUSB9533LMCADN",
              "^NQUSB9533LMN",
              "^NQGXJPLMAUD",
              "^NQDMXGBLMAUDN",
              "^NQUSHEIEUR",
              "^NQUSB9000LM",
              "^NQDMXJPLMJPY",
              "^NQDMXKRLCGBPN",
              "^NQVMVUSN",
              "^NQGIHEIEURN",
              "^NQDMXKREURN",
              "^NQNALMJPYN",
              "^NQUSB9000LMGBPN",
              "^NQG9000LMGBPN",
              "^NQDMXJPLMCADN",
              "^NQGIHEI",
              "^NQGIHEIEUR",
              "^NQDMXGBLMAUD",
              "^NQUSB9530LMAUDN",
              "^NQUSBLMAUDN",
              "^NQNA9000LMJPY",
              "^NQDMXJPLMCAD",
              "^NQDMXJPLMEUR",
              "^NQDXUSMEGA",
              "^NQDMXKRLMGBP",
              "^NQDXUSLCVN",
              "^NQGXGBLMAUDN",
              "^NQUS500LCN",
              "^NQNA9000LMCADN",
              "^AXI",
              "^NQUS500LCV"
            ],
            "symbol": "IBM"
          },
          {
            "language": "en-US",
            "region": "US",
            "quoteType": "EQUITY",
            "quoteSourceName": "Nasdaq Real Time Price",
            "triggerable": true,
            "quoteSummary": {
              "earnings": {
                "maxAge": 86400,
                "earningsChart": {
                  "quarterly": [
                    {
                      "date": "3Q2019",
                      "actual": 0.76,
                      "estimate": 0.71
                    },
                    {
                      "date": "4Q2019",
                      "actual": 1.25,
                      "estimate": 1.14
                    },
                    {
                      "date": "1Q2020",
                      "actual": 0.64,
                      "estimate": 0.56
                    },
                    {
                      "date": "2Q2020",
                      "actual": 0.64,
                      "estimate": 0.51
                    }
                  ],
                  "currentQuarterEstimate": 0.71,
                  "currentQuarterEstimateDate": "3Q",
                  "currentQuarterEstimateYear": 2020,
                  "earningsDate": [
                    1603929600
                  ]
                },
                "financialsChart": {
                  "yearly": [
                    {
                      "date": 2016,
                      "revenue": 215639000000,
                      "earnings": 45687000000
                    },
                    {
                      "date": 2017,
                      "revenue": 229234000000,
                      "earnings": 48351000000
                    },
                    {
                      "date": 2018,
                      "revenue": 265595000000,
                      "earnings": 59531000000
                    },
                    {
                      "date": 2019,
                      "revenue": 260174000000,
                      "earnings": 55256000000
                    }
                  ],
                  "quarterly": [
                    {
                      "date": "3Q2019",
                      "revenue": 64040000000,
                      "earnings": 13686000000
                    },
                    {
                      "date": "4Q2019",
                      "revenue": 91819000000,
                      "earnings": 22236000000
                    },
                    {
                      "date": "1Q2020",
                      "revenue": 58313000000,
                      "earnings": 11249000000
                    },
                    {
                      "date": "2Q2020",
                      "revenue": 59685000000,
                      "earnings": 11253000000
                    }
                  ]
                },
                "financialCurrency": "USD"
              }
            },
            "currency": "USD",
            "heldPercentInsiders": 0.066,
            "heldPercentInstitutions": 62.115,
            "regularMarketChange": -1.2050018,
            "regularMarketChangePercent": -1.0310618,
            "regularMarketTime": 1603394158,
            "regularMarketPrice": 115.665,
            "regularMarketDayHigh": 118.04,
            "regularMarketDayRange": "114.59 - 118.04",
            "regularMarketDayLow": 114.59,
            "regularMarketVolume": 83849916,
            "sharesShort": 88087882,
            "sharesShortPrevMonth": 79684337,
            "shortPercentFloat": 0.52,
            "regularMarketPreviousClose": 116.87,
            "bid": 115.79,
            "ask": 115.8,
            "bidSize": 9,
            "askSize": 14,
            "exchange": "NMS",
            "market": "us_market",
            "messageBoardId": "finmb_24937",
            "fullExchangeName": "NasdaqGS",
            "shortName": "Apple Inc.",
            "longName": "Apple Inc.",
            "regularMarketOpen": 117.45,
            "averageDailyVolume3Month": 173860580,
            "averageDailyVolume10Day": 152007450,
            "beta": 1.314396,
            "fiftyTwoWeekLowChange": 62.5125,
            "fiftyTwoWeekLowChangePercent": 1.176097,
            "fiftyTwoWeekRange": "53.1525 - 137.98",
            "fiftyTwoWeekHighChange": -22.314995,
            "fiftyTwoWeekHighChangePercent": -0.16172631,
            "fiftyTwoWeekLow": 53.1525,
            "fiftyTwoWeekHigh": 137.98,
            "dividendDate": 1597276800,
            "exDividendDate": 1596758400,
            "earningsTimestamp": 1604001600,
            "earningsTimestampStart": 1604001600,
            "earningsTimestampEnd": 1604001600,
            "trailingAnnualDividendRate": 0.782,
            "trailingPE": 35.092537,
            "pegRatio": 2.97,
            "dividendsPerShare": 0.78,
            "dividendRate": 0.82,
            "trailingAnnualDividendYield": 0.006691195,
            "dividendYield": 0.7,
            "revenue": 273857004000,
            "firstTradeDateMilliseconds": 345479400000,
            "priceHint": 2,
            "totalCash": 93025001000,
            "floatShares": 17085262439,
            "ebitda": 78671003648,
            "shortRatio": 0.47,
            "preMarketChange": 0.57,
            "preMarketChangePercent": 0.487721,
            "preMarketTime": 1603373399,
            "targetPriceHigh": 150,
            "targetPriceLow": 48.86,
            "targetPriceMean": 121.43,
            "targetPriceMedian": 131,
            "preMarketPrice": 117.44,
            "twoHundredDayAverage": 96.73907,
            "twoHundredDayAverageChange": 18.925934,
            "twoHundredDayAverageChangePercent": 0.195639,
            "forwardPE": 29.887598,
            "priceToBook": 27.421764,
            "sourceInterval": 15,
            "exchangeDataDelayedBy": 0,
            "exchangeTimezoneName": "America/New_York",
            "exchangeTimezoneShortName": "EDT",
            "pageViews": {
              "midTermTrend": "UP",
              "longTermTrend": "UP",
              "shortTermTrend": "DOWN"
            },
            "gmtOffSetMilliseconds": -14400000,
            "esgPopulated": false,
            "tradeable": false,
            "priceToSales": 7.2233343,
            "marketState": "REGULAR",
            "epsTrailingTwelveMonths": 3.296,
            "epsForward": 3.87,
            "epsCurrentYear": 3.24,
            "epsNextQuarter": 1.36,
            "priceEpsCurrentYear": 35.699074,
            "priceEpsNextQuarter": 85.04779,
            "sharesOutstanding": 17102499840,
            "bookValue": 4.218,
            "fiftyDayAverage": 115.62057,
            "fiftyDayAverageChange": 0.044433594,
            "fiftyDayAverageChangePercent": 0.00038430528,
            "marketCap": 1978160644096,
            "components": [
              "^NQDMXJPLMAUD",
              "^NQDOG",
              "^NQUSBLM",
              "^NQSHYL",
              "^QIV",
              "^NQDXUSMLTCGN",
              "^NQUS500LCGN",
              "^NQUSB9572LMCADN",
              "^NQGMOIN",
              "^NQSXYN",
              "^NQGS",
              "^NQNALMEURN",
              "^NQUSB9000LMJPYN",
              "^NQUSB9572LMN",
              "^NQUSBLMCAD",
              "^NQUSB9000LMEURN",
              "^NQDMXKRJPYN",
              "^NQDMXKRLMAUDN",
              "^NQNA9000LMGBPN",
              "^NQUSB9570LMJPY",
              "^NQDMXJPLMAUDN",
              "^NQDMXKRLMAUD",
              "^NQUSBLMJPY",
              "^NDXCHF",
              "^NQNA9000LMEUR",
              "^AIX",
              "^NQNA9000LMCAD",
              "^NQGXGBLMN",
              "^NQDMXKRLCJPY",
              "^NQUSB9000LMEUR",
              "^NQDXUSLCEUR",
              "^NQUSB9572LMAUDN",
              "^NQDXUSLCG",
              "^CAPEXA",
              "^CPQ",
              "^CPQNTR",
              "^NQUSB9000LMCAD",
              "^NQDM9000LMJPY",
              "^NQG9000LMCADN",
              "^NQDMXKRAUD",
              "^NQDMXKRLMGBPN",
              "^NQGXGBLMGBPN",
              "^NQDM9000LMEURN",
              "^NQGXJPLMJPYN",
              "^NQNALMCADN",
              "^NQUSBLMEUR",
              "^NQG9000LMGBP",
              "^NQDM9000LMJPYN",
              "^NQNALMJPY",
              "^DWANQTL",
              "^MSH",
              "^NDX",
              "^NQGXGBLMJPY",
              "^QCRD",
              "^NQUSB9570LMGBPN",
              "^IXCO",
              "^NQGXJPLMJPY",
              "^NQDMXKR",
              "^NQDMXGBLMCADN",
              "^NQUSB9000LMJPY",
              "^NQDMXKRLCN",
              "^NQGXGBLMEURN",
              "^NQGXJPLMCAD",
              "^NQGXJPLMEUR",
              "^XNDXNNRCHF",
              "^DWARJFMU",
              "^NQUSB9572LMEUR",
              "^NQDMXJPLMGBPN",
              "^NQDMXJPLMN",
              "^NQUSB9572LMCAD",
              "^NQSXY",
              "^NQDM9000LMAUD",
              "^NQDMXKRLCJPYN",
              "^NQDMXKRLMCADN",
              "^NQDMXKRLCEUR",
              "^NQUSB9000LMN",
              "^NQDXUSLC",
              "^NQUSB9570LMAUDN",
              "^NQGXGBLMJPYN",
              "^NQUSB9572LMEURN",
              "^NQG9000LMJPYN",
              "^NQUSBLMEURN",
              "^NQDMXKRJPY",
              "^NQDMXKRLCCAD",
              "^NQUSB9570LM",
              "^NQDMXKRLCEURN",
              "^NQUSMLTCG",
              "^NQG9000LMAUD",
              "^NQGXJPLMGBPN",
              "^QMI",
              "^NQUSB9000LMCADN",
              "^IXIC",
              "^NQNALM",
              "^NQUS500LC",
              "^NQDMXGBLMJPY",
              "^NQNALMAUD",
              "^NQNA9000LMN",
              "^NQVMVUS",
              "^NQDXUSLCN",
              "^NQGXGBLMAUD",
              "^NQUSBLMN",
              "^NQDMXJPLMGBP",
              "^NQFGSL",
              "^NQUSB9570LMCADN",
              "^NQDMXKRLMEUR",
              "^MNX1",
              "^NQNALMAUDN",
              "^GMB",
              "^NQG9000LMEURN",
              "^CAPEXAN",
              "^NQDM9000LMCADN",
              "^NQDMXKRLMCAD",
              "^NQDMXGBLM",
              "^NQUSB9570LMAUD",
              "^NQSHYLN",
              "^NQNA9000LMGBP",
              "^NQDMXGBLMJPYN",
              "^NQDOGN",
              "^NQG9000LMN",
              "^NQDMXKRLMJPY",
              "^NQUSBLMJPYN",
              "^NQDM9000LMN",
              "^NQDMXGBLMCAD",
              "^NQUSB9572LMJPY",
              "^XNDXNNRGBP",
              "^NQUSLG",
              "^NQDMXGBLMEURN",
              "^NQDMXKRGBPN",
              "^NQBUY",
              "^NQDMXGBLMEUR",
              "^XNDXNNR",
              "^NQDMXKRAUDN",
              "^NQDMXKRLMJPYN",
              "^NQUSBLMCADN",
              "^NQDMXGBLMN",
              "^NQNALMGBPN",
              "^NQGXGBLMCADN",
              "^NQDMXKRLCCADN",
              "^NQGXJPLMCADN",
              "^NQUSB9572LM",
              "^NQGXJPLM",
              "^NQNA9000LMAUD",
              "^NQUSB9570LMGBP",
              "^NQUSBLMGBP",
              "^NQNALMN",
              "^NQUSB9000LMAUD",
              "^NQUSLGN",
              "^NQNA9000LM",
              "^NQUSB9570LMEURN",
              "^QFON",
              "^NQGXJPLMAUDN",
              "^NQCAPST",
              "^NQ96DIVUS",
              "^DJI",
              "^NQDMXKRLCGBP",
              "^NQDMXKRLM",
              "^NQDM9000LMGBP",
              "^NQUSMLTCGN",
              "^NQDMXKRLC",
              "^NQNALMGBP",
              "^NDXEUR",
              "^NDXHKD",
              "^NQDMXJPLMJPYN",
              "^NQG9000LMEUR",
              "^NQGXGBLM",
              "^NQG9000LMCAD",
              "^NQGMOI",
              "^NQDMXKRN",
              "^NQUSB9570LMN",
              "^XQC",
              "^NQCRDN",
              "^NQUSB9572LMJPYN",
              "^NQDMXJPLMEURN",
              "^NQG9000LMJPY",
              "^NDXCAD",
              "^NQDXUSMLTCG",
              "^NQNA9000LMJPYN",
              "^NQFFUSMN",
              "^NQDMXJPLM",
              "^NQDMXKREUR",
              "^NQGXJPLMGBP",
              "^NQDM9000LMAUDN",
              "^NQDMXKRLMEURN",
              "^NQUSBLMAUD",
              "^NQGXGBLMGBP",
              "^NQDMXKRCAD",
              "^NQNA9000LMEURN",
              "^XQO",
              "^DJA",
              "^NQUSB9000LMAUDN",
              "^NQUSB9000LMGBP",
              "^NQDXUSLCEURN",
              "^GMBNTR",
              "^NQNA9000LMAUDN",
              "^NQG9000LMAUDN",
              "^NQDMXKRLCAUD",
              "^XCQ",
              "^NQDXUSMEGAN",
              "^NQNALMCAD",
              "^AVSPY",
              "^XCI",
              "^NQGXJPLMEURN",
              "^NQDM9000LM",
              "^NQDXUSLCGBP",
              "^NQGXJPLMN",
              "^NQNALMEUR",
              "^NDXGBP",
              "^NQGXGBLMEUR",
              "^NQDMXKRGBP",
              "^NQDM9000LMEUR",
              "^XNDXNNRHKD",
              "^NQFFUSM",
              "^NQUSB9572LMGBPN",
              "^NQDM9000LMCAD",
              "^NQDMXGBLMGBPN",
              "^XNDXNNREUR",
              "^NQCRD",
              "^NQDMXKRCADN",
              "^NQGXGBLMCAD",
              "^NQDMXGBLMGBP",
              "^NQDMXKRLCAUDN",
              "^XNDXNNRCAD",
              "^NQDM9000LMGBPN",
              "^NQDXUSLCGBPN",
              "^NQUSB9570LMJPYN",
              "^NQG9000LM",
              "^NQUSB9572LMAUD",
              "^NQUSBLMGBPN",
              "^NQDMXKRLMN",
              "^NQFGSLN",
              "^NQGXJPLMAUD",
              "^NQDMXGBLMAUDN",
              "^NDXT",
              "^NQUSB9000LM",
              "^NQDMXJPLMJPY",
              "^NQDMXKRLCGBPN",
              "^NQDXUSLCGN",
              "^NQVMVUSN",
              "^NQUS500LCG",
              "^NDXE",
              "^NQDMXKREURN",
              "^NQNALMJPYN",
              "^NQUSB9000LMGBPN",
              "^NQG9000LMGBPN",
              "^NQDMXJPLMCADN",
              "^NQDVRIS",
              "^NQUSB9570LMCAD",
              "^NQUSB9570LMEUR",
              "^NQDMXGBLMAUD",
              "^NQUSBLMAUDN",
              "^NQNA9000LMJPY",
              "^DWUSSR",
              "^NQDMXJPLMCAD",
              "^NQDMXJPLMEUR",
              "^NQDXUSMEGA",
              "^NQDMXKRLMGBP",
              "^NQGXGBLMAUDN",
              "^NQUS500LCN",
              "^NQUSB9572LMGBP",
              "^NQNA9000LMCADN"
            ],
            "symbol": "AAPL"
          }
        ],
        "error": null
      }
    }
```

</details>

The following queries get information about a single stock based on the ticker.  For `querystring` , the `symbol` parameter is required and the `region` parameter is optional and can be removed.

### get-profile Query

```python
import requests

url = "https://rapidapi.p.rapidapi.com/stock/v2/get-profile"

querystring = {"symbol":"AMZN","region":"US"}

headers = {
    'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
    'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
```
<details>
  <summary>Here's the response of the above request:</summary>

```json
    {
      "financialsTemplate": {
        "code": "N",
        "maxAge": 1
      },
      "price": {
        "quoteSourceName": "Nasdaq Real Time Price",
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "averageDailyVolume3Month": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "exchange": "NMS",
        "regularMarketTime": 1603393149,
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "shortName": "Amazon.com, Inc.",
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "longName": "Amazon.com, Inc.",
        "regularMarketChange": {
          "raw": -14.8498535,
          "fmt": "-14.85"
        },
        "currencySymbol": "$",
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "preMarketPrice": {
          "raw": 3189.47,
          "fmt": "3,189.47"
        },
        "preMarketTime": 1603373399,
        "exchangeDataDelayedBy": 0,
        "toCurrency": null,
        "postMarketChange": {},
        "postMarketPrice": {},
        "exchangeName": "NasdaqGS",
        "preMarketChange": {
          "raw": 4.53003,
          "fmt": "4.53"
        },
        "circulatingSupply": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "regularMarketPrice": {
          "raw": 3170.09,
          "fmt": "3,170.09"
        },
        "regularMarketVolume": {
          "raw": 3120990,
          "fmt": "3.12M",
          "longFmt": "3,120,990.00"
        },
        "lastMarket": null,
        "regularMarketSource": "FREE_REALTIME",
        "openInterest": {},
        "marketState": "REGULAR",
        "underlyingSymbol": null,
        "marketCap": {
          "raw": 1587866370048,
          "fmt": "1.59T",
          "longFmt": "1,587,866,370,048.00"
        },
        "quoteType": "EQUITY",
        "preMarketChangePercent": {
          "raw": 0.00142233,
          "fmt": "0.14%"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "symbol": "AMZN",
        "preMarketSource": "FREE_REALTIME",
        "maxAge": 1,
        "fromCurrency": null,
        "regularMarketChangePercent": {
          "raw": -0.0046625226,
          "fmt": "-0.47%"
        }
      },
      "secFilings": {
        "filings": [
          {
            "date": "2020-09-09",
            "epochDate": 1599685697,
            "type": "8-K",
            "title": "Change in Directors or Principal Officers",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000026&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-08-21",
            "epochDate": 1598019657,
            "type": "8-K",
            "title": "Change in Directors or Principal Officers, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001193125-20-226520&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-07-31",
            "epochDate": 1596193864,
            "type": "10-Q",
            "title": "Quarterly Report",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000021&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-07-30",
            "epochDate": 1596154406,
            "type": "8-K",
            "title": "Results of Operations and Financial Condition, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000019&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-06-23",
            "epochDate": 1592946902,
            "type": "8-K",
            "title": "Entry into a Material Definitive Agreement, Creation of a Direct Financial Obligation or an Obligation under an Off-Balance Sheet Arrangement of a Registrant, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001193125-20-176528&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-06-03",
            "epochDate": 1591215715,
            "type": "8-K",
            "title": "Disclosing Other Events, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001193125-20-159531&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-05-29",
            "epochDate": 1590787862,
            "type": "8-K",
            "title": "Disclosing Amendments to Articles of Inc. or Bylaws; Change in Fiscal Year, Submission of Mat",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000015&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-05-01",
            "epochDate": 1588329988,
            "type": "10-Q",
            "title": "Quarterly Report",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000010&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-04-30",
            "epochDate": 1588279428,
            "type": "8-K",
            "title": "Disclosing Results of Operations and Financial Condition, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000008&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-04-16",
            "epochDate": 1587031458,
            "type": "8-K",
            "title": "Disclosing Regulation FD Disclosure, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001193125-20-108427&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-01-31",
            "epochDate": 1580468772,
            "type": "10-K",
            "title": "Annual Report",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000004&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2020-01-30",
            "epochDate": 1580420869,
            "type": "8-K",
            "title": "Disclosing Results of Operations and Financial Condition, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-20-000002&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2019-10-25",
            "epochDate": 1571997935,
            "type": "8-K",
            "title": "Disclosing Results of Operations and Financial Condition, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-19-000087&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2019-10-25",
            "epochDate": 1571997898,
            "type": "10-Q",
            "title": "Quarterly Report",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-19-000089&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2019-07-26",
            "epochDate": 1564135329,
            "type": "10-Q",
            "title": "Quarterly Report",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-19-000071&nav=1&src=Yahoo",
            "maxAge": 1
          },
          {
            "date": "2019-07-25",
            "epochDate": 1564086875,
            "type": "8-K",
            "title": "Disclosing Results of Operations and Financial Condition, Financial Statements and Exhibits",
            "edgarUrl": "https://yahoo.brand.edgar-online.com/DisplayFiling.aspx?TabIndex=2&dcn=0001018724-19-000069&nav=1&src=Yahoo",
            "maxAge": 1
          }
        ],
        "maxAge": 86400
      },
      "quoteType": {
        "exchange": "NMS",
        "shortName": "Amazon.com, Inc.",
        "longName": "Amazon.com, Inc.",
        "exchangeTimezoneName": "America/New_York",
        "exchangeTimezoneShortName": "EDT",
        "isEsgPopulated": false,
        "gmtOffSetMilliseconds": "-14400000",
        "quoteType": "EQUITY",
        "symbol": "AMZN",
        "messageBoardId": "finmb_18749",
        "market": "us_market"
      },
      "calendarEvents": {
        "maxAge": 1,
        "earnings": {
          "earningsDate": [
            {
              "raw": 1603929600,
              "fmt": "2020-10-29"
            }
          ],
          "earningsAverage": {
            "raw": 7.25,
            "fmt": "7.25"
          },
          "earningsLow": {
            "raw": 4.62,
            "fmt": "4.62"
          },
          "earningsHigh": {
            "raw": 11.96,
            "fmt": "11.96"
          },
          "revenueAverage": {
            "raw": 92483100000,
            "fmt": "92.48B",
            "longFmt": "92,483,100,000"
          },
          "revenueLow": {
            "raw": 90073000000,
            "fmt": "90.07B",
            "longFmt": "90,073,000,000"
          },
          "revenueHigh": {
            "raw": 95652400000,
            "fmt": "95.65B",
            "longFmt": "95,652,400,000"
          }
        },
        "exDividendDate": {},
        "dividendDate": {}
      },
      "summaryDetail": {
        "previousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "twoHundredDayAverage": {
          "raw": 2856.3691,
          "fmt": "2,856.37"
        },
        "trailingAnnualDividendYield": {},
        "payoutRatio": {
          "raw": 0,
          "fmt": "0.00%"
        },
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "navPrice": {},
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "totalAssets": {},
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "fiftyDayAverage": {
          "raw": 3190.4482,
          "fmt": "3,190.45"
        },
        "trailingAnnualDividendRate": {},
        "open": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "toCurrency": null,
        "averageVolume10days": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "expireDate": {},
        "yield": {},
        "algorithm": null,
        "dividendRate": {},
        "exDividendDate": {},
        "beta": {
          "raw": 1.353006,
          "fmt": "1.35"
        },
        "circulatingSupply": {},
        "startDate": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "trailingPE": {
          "raw": 121.75327,
          "fmt": "121.75"
        },
        "regularMarketVolume": {
          "raw": 3120990,
          "fmt": "3.12M",
          "longFmt": "3,120,990"
        },
        "lastMarket": null,
        "maxSupply": {},
        "openInterest": {},
        "marketCap": {
          "raw": 1587866370048,
          "fmt": "1.59T",
          "longFmt": "1,587,866,370,048"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "averageVolume": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "priceToSalesTrailing12Months": {
          "raw": 4.934603,
          "fmt": "4.93"
        },
        "dayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "ask": {
          "raw": 3166.09,
          "fmt": "3,166.09"
        },
        "ytdReturn": {},
        "askSize": {
          "raw": 3000,
          "fmt": "3k",
          "longFmt": "3,000"
        },
        "volume": {
          "raw": 3120990,
          "fmt": "3.12M",
          "longFmt": "3,120,990"
        },
        "fiftyTwoWeekHigh": {
          "raw": 3552.25,
          "fmt": "3,552.25"
        },
        "forwardPE": {
          "raw": 71.4467,
          "fmt": "71.45"
        },
        "maxAge": 1,
        "fromCurrency": null,
        "fiveYearAvgDividendYield": {},
        "fiftyTwoWeekLow": {
          "raw": 1626.03,
          "fmt": "1,626.03"
        },
        "bid": {
          "raw": 3165,
          "fmt": "3,165.00"
        },
        "tradeable": false,
        "dividendYield": {},
        "bidSize": {
          "raw": 1100,
          "fmt": "1.1k",
          "longFmt": "1,100"
        },
        "dayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        }
      },
      "symbol": "AMZN",
      "assetProfile": {
        "zip": "98109-5210",
        "sector": "Consumer Cyclical",
        "fullTimeEmployees": 798000,
        "compensationRisk": 9,
        "auditRisk": 1,
        "longBusinessSummary": "Amazon.com, Inc. engages in the retail sale of consumer products and subscriptions in North America and internationally. The company operates through three segments: North America, International, and Amazon Web Services (AWS). It sells merchandise and content purchased for resale from third-party sellers through physical and online stores. The company also manufactures and sells electronic devices, including Kindle, Fire tablets, Fire TVs, Rings, and Echo and other devices; provides Kindle Direct Publishing, an online service that allows independent authors and publishers to make their books available in the Kindle Store; and develops and produces media content. In addition, it offers programs that enable sellers to sell their products on its Websites, as well as its stores; and programs that allow authors, musicians, filmmakers, skill and app developers, and others to publish and sell content. Further, the company provides compute, storage, database, and other AWS services, as well as fulfillment, advertising, publishing, and digital content subscriptions. Additionally, it offers Amazon Prime, a membership program, which provides free shipping of various items; access to streaming of movies and TV episodes; and other services. The company also operates in the food delivery business in Bengaluru, India. It serves consumers, sellers, developers, enterprises, and content creators. The company also has utility-scale solar projects in China, Australia, and the United States. Amazon.com, Inc. was founded in 1994 and is headquartered in Seattle, Washington.",
        "city": "Seattle",
        "phone": "206-266-1000",
        "state": "WA",
        "shareHolderRightsRisk": 2,
        "compensationAsOfEpochDate": 1577750400,
        "governanceEpochDate": 1601942400,
        "boardRisk": 9,
        "country": "United States",
        "companyOfficers": [
          {
            "totalPay": {
              "raw": 1681840,
              "fmt": "1.68M",
              "longFmt": "1,681,840"
            },
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "yearBorn": 1964,
            "name": "Mr. Jeffrey P. Bezos",
            "title": "Founder, Chairman, Pres & CEO",
            "maxAge": 1,
            "fiscalYear": 2019,
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "age": 55
          },
          {
            "totalPay": {
              "raw": 163200,
              "fmt": "163.2k",
              "longFmt": "163,200"
            },
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "yearBorn": 1964,
            "name": "Mr. Brian T. Olsavsky",
            "title": "Sr. VP & CFO",
            "maxAge": 1,
            "fiscalYear": 2019,
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "age": 55
          },
          {
            "totalPay": {
              "raw": 210725,
              "fmt": "210.72k",
              "longFmt": "210,725"
            },
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "yearBorn": 1967,
            "name": "Mr. Jeffrey A. Wilke",
            "title": "Chief Exec. Officer of Worldwide Consumer",
            "maxAge": 1,
            "fiscalYear": 2019,
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "age": 52
          },
          {
            "totalPay": {
              "raw": 348809,
              "fmt": "348.81k",
              "longFmt": "348,809"
            },
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "yearBorn": 1968,
            "name": "Mr. Andrew R. Jassy",
            "title": "Chief Exec. Officer of Amazon Web Services Inc.",
            "maxAge": 1,
            "fiscalYear": 2019,
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "age": 51
          },
          {
            "maxAge": 1,
            "name": "Mr. Dave  Clark",
            "title": "Sr. VP of Worldwide Operations",
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          },
          {
            "maxAge": 1,
            "name": "Ms. Shelley L. Reynolds",
            "age": 54,
            "title": "VP, Worldwide Controller & Principal Accounting Officer",
            "yearBorn": 1965,
            "fiscalYear": 2009,
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          },
          {
            "maxAge": 1,
            "name": "Dr. Werner  Vogels",
            "title": "Chief Technology Officer",
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          },
          {
            "maxAge": 1,
            "name": "Mr. David A. Zapolsky",
            "age": 55,
            "title": "Sr. VP, Gen. Counsel & Sec.",
            "yearBorn": 1964,
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          },
          {
            "maxAge": 1,
            "name": "Ms. Ragia  Samir",
            "title": "Head of Marketing",
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          },
          {
            "maxAge": 1,
            "name": "Ms. Beth  Galetti",
            "title": "Sr. VP of Worldwide HR",
            "exercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "unexercisedValue": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            }
          }
        ],
        "website": "http://www.amazon.com",
        "maxAge": 86400,
        "overallRisk": 6,
        "address1": "410 Terry Avenue North",
        "industry": "Internet Retail"
      },
      "pageViews": {
        "shortTermTrend": "UP",
        "midTermTrend": "UP",
        "longTermTrend": "UP",
        "maxAge": 1
      }
    }
```

</details>

I think it might be the shortest response out of all the rest

### get-summary Query

```python
import requests

url = "https://rapidapi.p.rapidapi.com/stock/v2/get-summary"

querystring = {"symbol":"AMZN","region":"US"}

headers = {
    'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
    'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
```

<details>
  <summary>Here's the response of the above request:</summary>

```json
    {
      "defaultKeyStatistics": {
        "annualHoldingsTurnover": {},
        "enterpriseToRevenue": {
          "raw": 5.02,
          "fmt": "5.02"
        },
        "beta3Year": {},
        "profitMargins": {
          "raw": 0.040960003,
          "fmt": "4.10%"
        },
        "enterpriseToEbitda": {
          "raw": 40.817,
          "fmt": "40.82"
        },
        "52WeekChange": {
          "raw": 0.7885083,
          "fmt": "78.85%"
        },
        "morningStarRiskRating": {},
        "forwardEps": {
          "raw": 44.37,
          "fmt": "44.37"
        },
        "revenueQuarterlyGrowth": {},
        "sharesOutstanding": {
          "raw": 500889984,
          "fmt": "500.89M",
          "longFmt": "500,889,984"
        },
        "fundInceptionDate": {},
        "annualReportExpenseRatio": {},
        "totalAssets": {},
        "bookValue": {
          "raw": 147.162,
          "fmt": "147.16"
        },
        "sharesShort": {
          "raw": 2748588,
          "fmt": "2.75M",
          "longFmt": "2,748,588"
        },
        "sharesPercentSharesOut": {
          "raw": 0.0055,
          "fmt": "0.55%"
        },
        "fundFamily": null,
        "lastFiscalYearEnd": {
          "raw": 1577750400,
          "fmt": "2019-12-31"
        },
        "heldPercentInstitutions": {
          "raw": 0.57689,
          "fmt": "57.69%"
        },
        "netIncomeToCommon": {
          "raw": 13180000256,
          "fmt": "13.18B",
          "longFmt": "13,180,000,256"
        },
        "trailingEps": {
          "raw": 26.037,
          "fmt": "26.04"
        },
        "lastDividendValue": {},
        "SandP52WeekChange": {
          "raw": 0.14127207,
          "fmt": "14.13%"
        },
        "priceToBook": {
          "raw": 21.392546,
          "fmt": "21.39"
        },
        "heldPercentInsiders": {
          "raw": 0.15122,
          "fmt": "15.12%"
        },
        "nextFiscalYearEnd": {
          "raw": 1640908800,
          "fmt": "2021-12-31"
        },
        "yield": {},
        "mostRecentQuarter": {
          "raw": 1593475200,
          "fmt": "2020-06-30"
        },
        "shortRatio": {
          "raw": 0.5,
          "fmt": "0.5"
        },
        "sharesShortPreviousMonthDate": {
          "raw": 1598832000,
          "fmt": "2020-08-31"
        },
        "floatShares": {
          "raw": 425265331,
          "fmt": "425.27M",
          "longFmt": "425,265,331"
        },
        "beta": {
          "raw": 1.353006,
          "fmt": "1.35"
        },
        "enterpriseValue": {
          "raw": 1615313502208,
          "fmt": "1.62T",
          "longFmt": "1,615,313,502,208"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "threeYearAverageReturn": {},
        "lastSplitDate": {
          "raw": 936230400,
          "fmt": "1999-09-02"
        },
        "lastSplitFactor": "2:1",
        "legalType": null,
        "lastDividendDate": {},
        "morningStarOverallRating": {},
        "earningsQuarterlyGrowth": {
          "raw": 0.997,
          "fmt": "99.70%"
        },
        "priceToSalesTrailing12Months": {},
        "dateShortInterest": {
          "raw": 1601424000,
          "fmt": "2020-09-30"
        },
        "pegRatio": {
          "raw": 2.94,
          "fmt": "2.94"
        },
        "ytdReturn": {},
        "forwardPE": {
          "raw": 70.95267,
          "fmt": "70.95"
        },
        "maxAge": 1,
        "lastCapGain": {},
        "shortPercentOfFloat": {
          "raw": 0.0064999997,
          "fmt": "0.65%"
        },
        "sharesShortPriorMonth": {
          "raw": 2035049,
          "fmt": "2.04M",
          "longFmt": "2,035,049"
        },
        "category": null,
        "fiveYearAverageReturn": {}
      },
      "details": {},
      "summaryProfile": {
        "zip": "98109-5210",
        "sector": "Consumer Cyclical",
        "fullTimeEmployees": 798000,
        "longBusinessSummary": "Amazon.com, Inc. engages in the retail sale of consumer products and subscriptions in North America and internationally. The company operates through three segments: North America, International, and Amazon Web Services (AWS). It sells merchandise and content purchased for resale from third-party sellers through physical and online stores. The company also manufactures and sells electronic devices, including Kindle, Fire tablets, Fire TVs, Rings, and Echo and other devices; provides Kindle Direct Publishing, an online service that allows independent authors and publishers to make their books available in the Kindle Store; and develops and produces media content. In addition, it offers programs that enable sellers to sell their products on its Websites, as well as its stores; and programs that allow authors, musicians, filmmakers, skill and app developers, and others to publish and sell content. Further, the company provides compute, storage, database, and other AWS services, as well as fulfillment, advertising, publishing, and digital content subscriptions. Additionally, it offers Amazon Prime, a membership program, which provides free shipping of various items; access to streaming of movies and TV episodes; and other services. The company also operates in the food delivery business in Bengaluru, India. It serves consumers, sellers, developers, enterprises, and content creators. The company also has utility-scale solar projects in China, Australia, and the United States. Amazon.com, Inc. was founded in 1994 and is headquartered in Seattle, Washington.",
        "city": "Seattle",
        "phone": "206-266-1000",
        "state": "WA",
        "country": "United States",
        "companyOfficers": [],
        "website": "http://www.amazon.com",
        "maxAge": 86400,
        "address1": "410 Terry Avenue North",
        "industry": "Internet Retail"
      },
      "recommendationTrend": {
        "trend": [
          {
            "period": "0m",
            "strongBuy": 15,
            "buy": 28,
            "hold": 3,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-1m",
            "strongBuy": 18,
            "buy": 27,
            "hold": 2,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-2m",
            "strongBuy": 17,
            "buy": 28,
            "hold": 4,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-3m",
            "strongBuy": 19,
            "buy": 29,
            "hold": 2,
            "sell": 0,
            "strongSell": 0
          }
        ],
        "maxAge": 86400
      },
      "financialsTemplate": {
        "code": "N",
        "maxAge": 1
      },
      "majorDirectHolders": {
        "holders": [],
        "maxAge": 1
      },
      "earnings": {
        "maxAge": 86400,
        "earningsChart": {
          "quarterly": [
            {
              "date": "3Q2019",
              "actual": {
                "raw": 4.23,
                "fmt": "4.23"
              },
              "estimate": {
                "raw": 4.62,
                "fmt": "4.62"
              }
            },
            {
              "date": "4Q2019",
              "actual": {
                "raw": 6.47,
                "fmt": "6.47"
              },
              "estimate": {
                "raw": 4.03,
                "fmt": "4.03"
              }
            },
            {
              "date": "1Q2020",
              "actual": {
                "raw": 5.01,
                "fmt": "5.01"
              },
              "estimate": {
                "raw": 6.25,
                "fmt": "6.25"
              }
            },
            {
              "date": "2Q2020",
              "actual": {
                "raw": 10.3,
                "fmt": "10.30"
              },
              "estimate": {
                "raw": 1.46,
                "fmt": "1.46"
              }
            }
          ],
          "currentQuarterEstimate": {
            "raw": 7.25,
            "fmt": "7.25"
          },
          "currentQuarterEstimateDate": "3Q",
          "currentQuarterEstimateYear": 2020,
          "earningsDate": [
            {
              "raw": 1603929600,
              "fmt": "2020-10-29"
            }
          ]
        },
        "financialsChart": {
          "yearly": [
            {
              "date": 2016,
              "revenue": {
                "raw": 135987000000,
                "fmt": "135.99B",
                "longFmt": "135,987,000,000"
              },
              "earnings": {
                "raw": 2371000000,
                "fmt": "2.37B",
                "longFmt": "2,371,000,000"
              }
            },
            {
              "date": 2017,
              "revenue": {
                "raw": 177866000000,
                "fmt": "177.87B",
                "longFmt": "177,866,000,000"
              },
              "earnings": {
                "raw": 3033000000,
                "fmt": "3.03B",
                "longFmt": "3,033,000,000"
              }
            },
            {
              "date": 2018,
              "revenue": {
                "raw": 232887000000,
                "fmt": "232.89B",
                "longFmt": "232,887,000,000"
              },
              "earnings": {
                "raw": 10073000000,
                "fmt": "10.07B",
                "longFmt": "10,073,000,000"
              }
            },
            {
              "date": 2019,
              "revenue": {
                "raw": 280522000000,
                "fmt": "280.52B",
                "longFmt": "280,522,000,000"
              },
              "earnings": {
                "raw": 11588000000,
                "fmt": "11.59B",
                "longFmt": "11,588,000,000"
              }
            }
          ],
          "quarterly": [
            {
              "date": "3Q2019",
              "revenue": {
                "raw": 69981000000,
                "fmt": "69.98B",
                "longFmt": "69,981,000,000"
              },
              "earnings": {
                "raw": 2134000000,
                "fmt": "2.13B",
                "longFmt": "2,134,000,000"
              }
            },
            {
              "date": "4Q2019",
              "revenue": {
                "raw": 87436000000,
                "fmt": "87.44B",
                "longFmt": "87,436,000,000"
              },
              "earnings": {
                "raw": 3268000000,
                "fmt": "3.27B",
                "longFmt": "3,268,000,000"
              }
            },
            {
              "date": "1Q2020",
              "revenue": {
                "raw": 75452000000,
                "fmt": "75.45B",
                "longFmt": "75,452,000,000"
              },
              "earnings": {
                "raw": 2535000000,
                "fmt": "2.54B",
                "longFmt": "2,535,000,000"
              }
            },
            {
              "date": "2Q2020",
              "revenue": {
                "raw": 88912000000,
                "fmt": "88.91B",
                "longFmt": "88,912,000,000"
              },
              "earnings": {
                "raw": 5243000000,
                "fmt": "5.24B",
                "longFmt": "5,243,000,000"
              }
            }
          ]
        },
        "financialCurrency": "USD"
      },
      "price": {
        "quoteSourceName": "Nasdaq Real Time Price",
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "averageDailyVolume3Month": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "exchange": "NMS",
        "regularMarketTime": 1603386235,
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "shortName": "Amazon.com, Inc.",
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "longName": "Amazon.com, Inc.",
        "regularMarketChange": {
          "raw": -36.77002,
          "fmt": "-36.77"
        },
        "currencySymbol": "$",
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "preMarketPrice": {
          "raw": 3189.47,
          "fmt": "3,189.47"
        },
        "preMarketTime": 1603373399,
        "exchangeDataDelayedBy": 0,
        "toCurrency": null,
        "postMarketChange": {},
        "postMarketPrice": {},
        "exchangeName": "NasdaqGS",
        "preMarketChange": {
          "raw": 4.53003,
          "fmt": "4.53"
        },
        "circulatingSupply": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "regularMarketPrice": {
          "raw": 3148.17,
          "fmt": "3,148.17"
        },
        "regularMarketVolume": {
          "raw": 2361659,
          "fmt": "2.36M",
          "longFmt": "2,361,659.00"
        },
        "lastMarket": null,
        "regularMarketSource": "FREE_REALTIME",
        "openInterest": {},
        "marketState": "REGULAR",
        "underlyingSymbol": null,
        "marketCap": {
          "raw": 1576886730752,
          "fmt": "1.58T",
          "longFmt": "1,576,886,730,752.00"
        },
        "quoteType": "EQUITY",
        "preMarketChangePercent": {
          "raw": 0.00142233,
          "fmt": "0.14%"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "symbol": "AMZN",
        "preMarketSource": "FREE_REALTIME",
        "maxAge": 1,
        "fromCurrency": null,
        "regularMarketChangePercent": {
          "raw": -0.011544964,
          "fmt": "-1.15%"
        }
      },
      "fundOwnership": {
        "maxAge": 1,
        "ownershipList": [
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Vanguard Total Stock Market Index Fund",
            "pctHeld": {
              "raw": 0.0241,
              "fmt": "2.41%"
            },
            "position": {
              "raw": 12082876,
              "fmt": "12.08M",
              "longFmt": "12,082,876"
            },
            "value": {
              "raw": 33334479966,
              "fmt": "33.33B",
              "longFmt": "33,334,479,966"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Vanguard 500 Index Fund",
            "pctHeld": {
              "raw": 0.0174,
              "fmt": "1.74%"
            },
            "position": {
              "raw": 8692454,
              "fmt": "8.69M",
              "longFmt": "8,692,454"
            },
            "value": {
              "raw": 23980915944,
              "fmt": "23.98B",
              "longFmt": "23,980,915,944"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1601424000,
              "fmt": "2020-09-30"
            },
            "organization": "SPDR S&P 500 ETF Trust",
            "pctHeld": {
              "raw": 0.009,
              "fmt": "0.90%"
            },
            "position": {
              "raw": 4490668,
              "fmt": "4.49M",
              "longFmt": "4,490,668"
            },
            "value": {
              "raw": 14139901051,
              "fmt": "14.14B",
              "longFmt": "14,139,901,051"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1598832000,
              "fmt": "2020-08-31"
            },
            "organization": "Invesco ETF Tr-Invesco QQQ Tr, Series 1 ETF",
            "pctHeld": {
              "raw": 0.0089,
              "fmt": "0.89%"
            },
            "position": {
              "raw": 4460109,
              "fmt": "4.46M",
              "longFmt": "4,460,109"
            },
            "value": {
              "raw": 15391657754,
              "fmt": "15.39B",
              "longFmt": "15,391,657,754"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Growth Fund Of America Inc",
            "pctHeld": {
              "raw": 0.0085,
              "fmt": "0.85%"
            },
            "position": {
              "raw": 4266284,
              "fmt": "4.27M",
              "longFmt": "4,266,284"
            },
            "value": {
              "raw": 11769909624,
              "fmt": "11.77B",
              "longFmt": "11,769,909,624"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1596153600,
              "fmt": "2020-07-31"
            },
            "organization": "Fidelity Contrafund Inc",
            "pctHeld": {
              "raw": 0.0081,
              "fmt": "0.81%"
            },
            "position": {
              "raw": 4033907,
              "fmt": "4.03M",
              "longFmt": "4,033,907"
            },
            "value": {
              "raw": 12766024804,
              "fmt": "12.77B",
              "longFmt": "12,766,024,804"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1598832000,
              "fmt": "2020-08-31"
            },
            "organization": "Fidelity 500 Index Fund",
            "pctHeld": {
              "raw": 0.0075,
              "fmt": "0.75%"
            },
            "position": {
              "raw": 3742057,
              "fmt": "3.74M",
              "longFmt": "3,742,057"
            },
            "value": {
              "raw": 12913689024,
              "fmt": "12.91B",
              "longFmt": "12,913,689,024"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Vanguard Institutional Index Fund-Institutional Index Fund",
            "pctHeld": {
              "raw": 0.0073,
              "fmt": "0.73%"
            },
            "position": {
              "raw": 3676682,
              "fmt": "3.68M",
              "longFmt": "3,676,682"
            },
            "value": {
              "raw": 10143303835,
              "fmt": "10.14B",
              "longFmt": "10,143,303,835"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Vanguard Growth Index Fund",
            "pctHeld": {
              "raw": 0.0067000003,
              "fmt": "0.67%"
            },
            "position": {
              "raw": 3348643,
              "fmt": "3.35M",
              "longFmt": "3,348,643"
            },
            "value": {
              "raw": 9238303281,
              "fmt": "9.24B",
              "longFmt": "9,238,303,281"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1601424000,
              "fmt": "2020-09-30"
            },
            "organization": "Price (T.Rowe) Blue Chip Growth Fund Inc.",
            "pctHeld": {
              "raw": 0.0066000004,
              "fmt": "0.66%"
            },
            "position": {
              "raw": 3321720,
              "fmt": "3.32M",
              "longFmt": "3,321,720"
            },
            "value": {
              "raw": 10459199415,
              "fmt": "10.46B",
              "longFmt": "10,459,199,415"
            }
          }
        ]
      },
      "insiderTransactions": {
        "transactions": [
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1599696000,
              "fmt": "2020-09-10"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1100,
              "fmt": "1.1k",
              "longFmt": "1,100"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1598918400,
              "fmt": "2020-09-01"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 360,
              "fmt": "360",
              "longFmt": "360"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1598572800,
              "fmt": "2020-08-28"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 3518,
              "fmt": "3.52k",
              "longFmt": "3,518"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1598313600,
              "fmt": "2020-08-25"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 7548,
              "fmt": "7.55k",
              "longFmt": "7,548"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 3286.82 - 3323.27 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1598227200,
              "fmt": "2020-08-24"
            },
            "value": {
              "raw": 2478209,
              "fmt": "2.48M",
              "longFmt": "2,478,209"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 750,
              "fmt": "750",
              "longFmt": "750"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 3155.09 - 3190.23 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 3809017,
              "fmt": "3.81M",
              "longFmt": "3,809,017"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1200,
              "fmt": "1.2k",
              "longFmt": "1,200"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 3173.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 3487259,
              "fmt": "3.49M",
              "longFmt": "3,487,259"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1099,
              "fmt": "1.1k",
              "longFmt": "1,099"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 3173.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 926551,
              "fmt": "926.55k",
              "longFmt": "926,551"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 292,
              "fmt": "292",
              "longFmt": "292"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 3173.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 3928323,
              "fmt": "3.93M",
              "longFmt": "3,928,323"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1238,
              "fmt": "1.24k",
              "longFmt": "1,238"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "MCGRATH JUDITH A",
            "transactionText": "Sale at price 3173.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 964628,
              "fmt": "964.63k",
              "longFmt": "964,628"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 304,
              "fmt": "304",
              "longFmt": "304"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 3173.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "value": {
              "raw": 4369386,
              "fmt": "4.37M",
              "longFmt": "4,369,386"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1377,
              "fmt": "1.38k",
              "longFmt": "1,377"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 2941,
              "fmt": "2.94k",
              "longFmt": "2,941"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2791,
              "fmt": "2.79k",
              "longFmt": "2,791"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2791,
              "fmt": "2.79k",
              "longFmt": "2,791"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 292,
              "fmt": "292",
              "longFmt": "292"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1377,
              "fmt": "1.38k",
              "longFmt": "1,377"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "MCGRATH JUDITH A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 304,
              "fmt": "304",
              "longFmt": "304"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1597363200,
              "fmt": "2020-08-14"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1377,
              "fmt": "1.38k",
              "longFmt": "1,377"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596672000,
              "fmt": "2020-08-06"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 550,
              "fmt": "550",
              "longFmt": "550"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Sale at price 3194.36 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596672000,
              "fmt": "2020-08-06"
            },
            "value": {
              "raw": 1916616,
              "fmt": "1.92M",
              "longFmt": "1,916,616"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 600,
              "fmt": "600",
              "longFmt": "600"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 3102.85 - 3183.27 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596499200,
              "fmt": "2020-08-04"
            },
            "value": {
              "raw": 485072931,
              "fmt": "485.07M",
              "longFmt": "485,072,931"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 154394,
              "fmt": "154.39k",
              "longFmt": "154,394"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 3108.33 - 3137.11 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596499200,
              "fmt": "2020-08-04"
            },
            "value": {
              "raw": 916281263,
              "fmt": "916.28M",
              "longFmt": "916,281,263"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 293614,
              "fmt": "293.61k",
              "longFmt": "293,614"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 3138.51 - 3167.15 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596499200,
              "fmt": "2020-08-04"
            },
            "value": {
              "raw": 307619184,
              "fmt": "307.62M",
              "longFmt": "307,619,184"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 97654,
              "fmt": "97.65k",
              "longFmt": "97,654"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 3106.29 - 3137.51 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596412800,
              "fmt": "2020-08-03"
            },
            "value": {
              "raw": 1420090247,
              "fmt": "1.42B",
              "longFmt": "1,420,090,247"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 454338,
              "fmt": "454.34k",
              "longFmt": "454,338"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 3183.39 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1596412800,
              "fmt": "2020-08-03"
            },
            "value": {
              "raw": 22108644,
              "fmt": "22.11M",
              "longFmt": "22,108,644"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 6945,
              "fmt": "6.95k",
              "longFmt": "6,945"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 2602,
              "fmt": "2.6k",
              "longFmt": "2,602"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 2434.48 - 2451.35 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1590105600,
              "fmt": "2020-05-22"
            },
            "value": {
              "raw": 1832372,
              "fmt": "1.83M",
              "longFmt": "1,832,372"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 750,
              "fmt": "750",
              "longFmt": "750"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 2496.22 - 2499.01 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1589932800,
              "fmt": "2020-05-20"
            },
            "value": {
              "raw": 10742038,
              "fmt": "10.74M",
              "longFmt": "10,742,038"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 4300,
              "fmt": "4.3k",
              "longFmt": "4,300"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "NOOYI INDRA K",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 183,
              "fmt": "183",
              "longFmt": "183"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 347,
              "fmt": "347",
              "longFmt": "347"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 2361.61 - 2409.00 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 2859399,
              "fmt": "2.86M",
              "longFmt": "2,859,399"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1200,
              "fmt": "1.2k",
              "longFmt": "1,200"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2791,
              "fmt": "2.79k",
              "longFmt": "2,791"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 2372.34 - 2374.34 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 2608079,
              "fmt": "2.61M",
              "longFmt": "2,608,079"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1099,
              "fmt": "1.1k",
              "longFmt": "1,099"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2791,
              "fmt": "2.79k",
              "longFmt": "2,791"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 2374.34 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 693307,
              "fmt": "693.31k",
              "longFmt": "693,307"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 292,
              "fmt": "292",
              "longFmt": "292"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 292,
              "fmt": "292",
              "longFmt": "292"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 424,
              "fmt": "424",
              "longFmt": "424"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 2362.98 - 2376.05 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 2935467,
              "fmt": "2.94M",
              "longFmt": "2,935,467"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1238,
              "fmt": "1.24k",
              "longFmt": "1,238"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1376,
              "fmt": "1.38k",
              "longFmt": "1,376"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 2374.34 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "value": {
              "raw": 3267092,
              "fmt": "3.27M",
              "longFmt": "3,267,092"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1376,
              "fmt": "1.38k",
              "longFmt": "1,376"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1376,
              "fmt": "1.38k",
              "longFmt": "1,376"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1588723200,
              "fmt": "2020-05-06"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 550,
              "fmt": "550",
              "longFmt": "550"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Sale at price 2329.44 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1588723200,
              "fmt": "2020-05-06"
            },
            "value": {
              "raw": 5124768,
              "fmt": "5.12M",
              "longFmt": "5,124,768"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 2200,
              "fmt": "2.2k",
              "longFmt": "2,200"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1588723200,
              "fmt": "2020-05-06"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 3957,
              "fmt": "3.96k",
              "longFmt": "3,957"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "RUBINSTEIN JONATHAN J",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1588550400,
              "fmt": "2020-05-04"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 437,
              "fmt": "437",
              "longFmt": "437"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 2256.50 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1588550400,
              "fmt": "2020-05-04"
            },
            "value": {
              "raw": 15671392,
              "fmt": "15.67M",
              "longFmt": "15,671,392"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 6945,
              "fmt": "6.95k",
              "longFmt": "6,945"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 2300.00 - 2301.61 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1586908800,
              "fmt": "2020-04-15"
            },
            "value": {
              "raw": 809668,
              "fmt": "809.67k",
              "longFmt": "809,668"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 352,
              "fmt": "352",
              "longFmt": "352"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1585872000,
              "fmt": "2020-04-03"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 52967,
              "fmt": "52.97k",
              "longFmt": "52,967"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1583107200,
              "fmt": "2020-03-02"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 524,
              "fmt": "524",
              "longFmt": "524"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1582502400,
              "fmt": "2020-02-24"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 2049,
              "fmt": "2.05k",
              "longFmt": "2,049"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 2093.64 - 2118.80 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1582243200,
              "fmt": "2020-02-21"
            },
            "value": {
              "raw": 2103212,
              "fmt": "2.1M",
              "longFmt": "2,103,212"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1000,
              "fmt": "1k",
              "longFmt": "1,000"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 2134.47 - 2164.88 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 7471245,
              "fmt": "7.47M",
              "longFmt": "7,471,245"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3475,
              "fmt": "3.48k",
              "longFmt": "3,475"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 2142.60 - 2145.60 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 6814364,
              "fmt": "6.81M",
              "longFmt": "6,814,364"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3178,
              "fmt": "3.18k",
              "longFmt": "3,178"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "Sale at price 2125.35 - 2147.76 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 7652608,
              "fmt": "7.65M",
              "longFmt": "7,652,608"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3573,
              "fmt": "3.57k",
              "longFmt": "3,573"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 2126.00 - 2144.05 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 811354,
              "fmt": "811.35k",
              "longFmt": "811,354"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 380,
              "fmt": "380",
              "longFmt": "380"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 2125.02 - 2147.45 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 3601156,
              "fmt": "3.6M",
              "longFmt": "3,601,156"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1685,
              "fmt": "1.69k",
              "longFmt": "1,685"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 2125.02 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581984000,
              "fmt": "2020-02-18"
            },
            "value": {
              "raw": 3750660,
              "fmt": "3.75M",
              "longFmt": "3,750,660"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WEEKS WENDELL P",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 190,
              "fmt": "190",
              "longFmt": "190"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8073,
              "fmt": "8.07k",
              "longFmt": "8,073"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "GORELICK JAMIE S",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 207,
              "fmt": "207",
              "longFmt": "207"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BREWER ROSALIND G",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 190,
              "fmt": "190",
              "longFmt": "190"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8073,
              "fmt": "8.07k",
              "longFmt": "8,073"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3573,
              "fmt": "3.57k",
              "longFmt": "3,573"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 380,
              "fmt": "380",
              "longFmt": "380"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581638400,
              "fmt": "2020-02-14"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "GORELICK JAMIE S",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1581033600,
              "fmt": "2020-02-07"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 250,
              "fmt": "250",
              "longFmt": "250"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2026.49 - 2056.18 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580947200,
              "fmt": "2020-02-06"
            },
            "value": {
              "raw": 579803224,
              "fmt": "579.8M",
              "longFmt": "579,803,224"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 283632,
              "fmt": "283.63k",
              "longFmt": "283,632"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2016.94 - 2041.54 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580860800,
              "fmt": "2020-02-05"
            },
            "value": {
              "raw": 987950131,
              "fmt": "987.95M",
              "longFmt": "987,950,131"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 486226,
              "fmt": "486.23k",
              "longFmt": "486,226"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2042.42 - 2070.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580860800,
              "fmt": "2020-02-05"
            },
            "value": {
              "raw": 666158144,
              "fmt": "666.16M",
              "longFmt": "666,158,144"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 324686,
              "fmt": "324.69k",
              "longFmt": "324,686"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2004.85 - 2053.62 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580688000,
              "fmt": "2020-02-03"
            },
            "value": {
              "raw": 465004659,
              "fmt": "465M",
              "longFmt": "465,004,659"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 229981,
              "fmt": "229.98k",
              "longFmt": "229,981"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2028.19 - 2048.42 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580688000,
              "fmt": "2020-02-03"
            },
            "value": {
              "raw": 742649707,
              "fmt": "742.65M",
              "longFmt": "742,649,707"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 364684,
              "fmt": "364.68k",
              "longFmt": "364,684"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580688000,
              "fmt": "2020-02-03"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 200,
              "fmt": "200",
              "longFmt": "200"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 2011.77 - 2025.69 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580688000,
              "fmt": "2020-02-03"
            },
            "value": {
              "raw": 14025906,
              "fmt": "14.03M",
              "longFmt": "14,025,906"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 6945,
              "fmt": "6.95k",
              "longFmt": "6,945"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 2003.15 - 2042.47 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1580428800,
              "fmt": "2020-01-31"
            },
            "value": {
              "raw": 629448719,
              "fmt": "629.45M",
              "longFmt": "629,448,719"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 310791,
              "fmt": "310.79k",
              "longFmt": "310,791"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1580428800,
              "fmt": "2020-01-31"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 705,
              "fmt": "705",
              "longFmt": "705"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1577404800,
              "fmt": "2019-12-27"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3700,
              "fmt": "3.7k",
              "longFmt": "3,700"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1862.03 - 1868.64 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1577318400,
              "fmt": "2019-12-26"
            },
            "value": {
              "raw": 373067,
              "fmt": "373.07k",
              "longFmt": "373,067"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 200,
              "fmt": "200",
              "longFmt": "200"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "RYDER THOMAS O",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1575244800,
              "fmt": "2019-12-02"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 281,
              "fmt": "281",
              "longFmt": "281"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1574294400,
              "fmt": "2019-11-21"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 56702,
              "fmt": "56.7k",
              "longFmt": "56,702"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1736.51 - 1760.18 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1574208000,
              "fmt": "2019-11-20"
            },
            "value": {
              "raw": 1748043,
              "fmt": "1.75M",
              "longFmt": "1,748,043"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1000,
              "fmt": "1k",
              "longFmt": "1,000"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 359,
              "fmt": "359",
              "longFmt": "359"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "RUBINSTEIN JONATHAN J",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 359,
              "fmt": "359",
              "longFmt": "359"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "RYDER THOMAS O",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 359,
              "fmt": "359",
              "longFmt": "359"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1733.00 - 1751.48 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 6065867,
              "fmt": "6.07M",
              "longFmt": "6,065,867"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3475,
              "fmt": "3.48k",
              "longFmt": "3,475"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8073,
              "fmt": "8.07k",
              "longFmt": "8,073"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 1745.90 - 1759.86 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 5659554,
              "fmt": "5.66M",
              "longFmt": "5,659,554"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3230,
              "fmt": "3.23k",
              "longFmt": "3,230"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8073,
              "fmt": "8.07k",
              "longFmt": "8,073"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "Sale at price 1745.64 - 1759.97 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 6260717,
              "fmt": "6.26M",
              "longFmt": "6,260,717"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3573,
              "fmt": "3.57k",
              "longFmt": "3,573"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3573,
              "fmt": "3.57k",
              "longFmt": "3,573"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 1745.46 - 1760.82 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 663499,
              "fmt": "663.5k",
              "longFmt": "663,499"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 222,
              "fmt": "222",
              "longFmt": "222"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 1746.20 - 1759.34 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 1540567,
              "fmt": "1.54M",
              "longFmt": "1,540,567"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 880,
              "fmt": "880",
              "longFmt": "880"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "HUTTENLOCHER DANIEL P",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 377,
              "fmt": "377",
              "longFmt": "377"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 1760.05 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "value": {
              "raw": 2226463,
              "fmt": "2.23M",
              "longFmt": "2,226,463"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1265,
              "fmt": "1.26k",
              "longFmt": "1,265"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573776000,
              "fmt": "2019-11-15"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1573603200,
              "fmt": "2019-11-13"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 2441,
              "fmt": "2.44k",
              "longFmt": "2,441"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "MCGRATH JUDITH A",
            "transactionText": "Sale at price 1749.91 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1572220800,
              "fmt": "2019-10-28"
            },
            "value": {
              "raw": 531973,
              "fmt": "531.97k",
              "longFmt": "531,973"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 304,
              "fmt": "304",
              "longFmt": "304"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1846.48 - 1852.01 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1568246400,
              "fmt": "2019-09-12"
            },
            "value": {
              "raw": 5173031,
              "fmt": "5.17M",
              "longFmt": "5,173,031"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2800,
              "fmt": "2.8k",
              "longFmt": "2,800"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1781.94 - 1799.81 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1567468800,
              "fmt": "2019-09-03"
            },
            "value": {
              "raw": 4480255,
              "fmt": "4.48M",
              "longFmt": "4,480,255"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2500,
              "fmt": "2.5k",
              "longFmt": "2,500"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "Sale at price 1778.15 - 1797.60 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1567036800,
              "fmt": "2019-08-29"
            },
            "value": {
              "raw": 12797740,
              "fmt": "12.8M",
              "longFmt": "12,797,740"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 7144,
              "fmt": "7.14k",
              "longFmt": "7,144"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1749.92 - 1766.52 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1566777600,
              "fmt": "2019-08-26"
            },
            "value": {
              "raw": 4397582,
              "fmt": "4.4M",
              "longFmt": "4,397,582"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2500,
              "fmt": "2.5k",
              "longFmt": "2,500"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "RUBINSTEIN JONATHAN J",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1566259200,
              "fmt": "2019-08-20"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 277,
              "fmt": "277",
              "longFmt": "277"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1804.48 - 1813.28 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1566259200,
              "fmt": "2019-08-20"
            },
            "value": {
              "raw": 1809204,
              "fmt": "1.81M",
              "longFmt": "1,809,204"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1000,
              "fmt": "1k",
              "longFmt": "1,000"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1765.07 - 1780.13 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "value": {
              "raw": 6164625,
              "fmt": "6.16M",
              "longFmt": "6,164,625"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3475,
              "fmt": "3.48k",
              "longFmt": "3,475"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8072,
              "fmt": "8.07k",
              "longFmt": "8,072"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 1768.36 - 1787.05 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "value": {
              "raw": 5734363,
              "fmt": "5.73M",
              "longFmt": "5,734,363"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3230,
              "fmt": "3.23k",
              "longFmt": "3,230"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8073,
              "fmt": "8.07k",
              "longFmt": "8,073"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3572,
              "fmt": "3.57k",
              "longFmt": "3,572"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 1768.96 - 1785.25 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "value": {
              "raw": 672889,
              "fmt": "672.89k",
              "longFmt": "672,889"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 1767.30 - 1787.58 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "value": {
              "raw": 1563526,
              "fmt": "1.56M",
              "longFmt": "1,563,526"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 880,
              "fmt": "880",
              "longFmt": "880"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1764,
              "fmt": "1.76k",
              "longFmt": "1,764"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "MCGRATH JUDITH A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 304,
              "fmt": "304",
              "longFmt": "304"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 1783.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "value": {
              "raw": 3146995,
              "fmt": "3.15M",
              "longFmt": "3,146,995"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1565827200,
              "fmt": "2019-08-15"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1765,
              "fmt": "1.76k",
              "longFmt": "1,765"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 1810.86 - 1897.12 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564704000,
              "fmt": "2019-08-02"
            },
            "value": {
              "raw": 677155592,
              "fmt": "677.16M",
              "longFmt": "677,155,592"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 360498,
              "fmt": "360.5k",
              "longFmt": "360,498"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 1814.87 - 1846.02 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564704000,
              "fmt": "2019-08-02"
            },
            "value": {
              "raw": 312930261,
              "fmt": "312.93M",
              "longFmt": "312,930,261"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 171354,
              "fmt": "171.35k",
              "longFmt": "171,354"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564617600,
              "fmt": "2019-08-01"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 268,
              "fmt": "268",
              "longFmt": "268"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 1884.39 - 1931.39 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564531200,
              "fmt": "2019-07-31"
            },
            "value": {
              "raw": 861864290,
              "fmt": "861.86M",
              "longFmt": "861,864,290"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 454503,
              "fmt": "454.5k",
              "longFmt": "454,503"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 1889.45 - 1899.55 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564531200,
              "fmt": "2019-07-31"
            },
            "value": {
              "raw": 395563985,
              "fmt": "395.56M",
              "longFmt": "395,563,985"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 208967,
              "fmt": "208.97k",
              "longFmt": "208,967"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BEZOS JEFFREY P",
            "transactionText": "Sale at price 1891.22 - 1925.81 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1564358400,
              "fmt": "2019-07-29"
            },
            "value": {
              "raw": 579955868,
              "fmt": "579.96M",
              "longFmt": "579,955,868"
            },
            "filerRelation": "Chief Executive Officer",
            "shares": {
              "raw": 304678,
              "fmt": "304.68k",
              "longFmt": "304,678"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 2000.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1562716800,
              "fmt": "2019-07-10"
            },
            "value": {
              "raw": 14616000,
              "fmt": "14.62M",
              "longFmt": "14,616,000"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 7308,
              "fmt": "7.31k",
              "longFmt": "7,308"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 2000.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1562716800,
              "fmt": "2019-07-10"
            },
            "value": {
              "raw": 1526000,
              "fmt": "1.53M",
              "longFmt": "1,526,000"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 763,
              "fmt": "763",
              "longFmt": "763"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1849.28 - 1863.14 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1558310400,
              "fmt": "2019-05-20"
            },
            "value": {
              "raw": 1858248,
              "fmt": "1.86M",
              "longFmt": "1,858,248"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1000,
              "fmt": "1k",
              "longFmt": "1,000"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1830.06 - 1873.25 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 7961967,
              "fmt": "7.96M",
              "longFmt": "7,961,967"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 4275,
              "fmt": "4.28k",
              "longFmt": "4,275"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8072,
              "fmt": "8.07k",
              "longFmt": "8,072"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "Sale at price 1825.41 - 1850.15 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 5922612,
              "fmt": "5.92M",
              "longFmt": "5,922,612"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3228,
              "fmt": "3.23k",
              "longFmt": "3,228"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "JASSY ANDREW R",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 8071,
              "fmt": "8.07k",
              "longFmt": "8,071"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "BLACKBURN JEFFREY M",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 3572,
              "fmt": "3.57k",
              "longFmt": "3,572"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "Sale at price 1827.94 - 1849.04 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 696723,
              "fmt": "696.72k",
              "longFmt": "696,723"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "REYNOLDS SHELLEY L",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 379,
              "fmt": "379",
              "longFmt": "379"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 274,
              "fmt": "274",
              "longFmt": "274"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "Sale at price 1828.11 - 1849.62 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 1614436,
              "fmt": "1.61M",
              "longFmt": "1,614,436"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 880,
              "fmt": "880",
              "longFmt": "880"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "ZAPOLSKY DAVID",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1764,
              "fmt": "1.76k",
              "longFmt": "1,764"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "Sale at price 1828.48 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "value": {
              "raw": 3223610,
              "fmt": "3.22M",
              "longFmt": "3,223,610"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1763,
              "fmt": "1.76k",
              "longFmt": "1,763"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "OLSAVSKY BRIAN T.",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1557878400,
              "fmt": "2019-05-15"
            },
            "filerRelation": "Chief Financial Officer",
            "shares": {
              "raw": 1763,
              "fmt": "1.76k",
              "longFmt": "1,763"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1846.19 - 1851.45 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1557792000,
              "fmt": "2019-05-14"
            },
            "value": {
              "raw": 3511414,
              "fmt": "3.51M",
              "longFmt": "3,511,414"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1900,
              "fmt": "1.9k",
              "longFmt": "1,900"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1919.75 - 1932.69 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1557273600,
              "fmt": "2019-05-08"
            },
            "value": {
              "raw": 4815718,
              "fmt": "4.82M",
              "longFmt": "4,815,718"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2500,
              "fmt": "2.5k",
              "longFmt": "2,500"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1913.94 - 1940.51 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1556668800,
              "fmt": "2019-05-01"
            },
            "value": {
              "raw": 4836059,
              "fmt": "4.84M",
              "longFmt": "4,836,059"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2500,
              "fmt": "2.5k",
              "longFmt": "2,500"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "NOOYI INDRA K",
            "transactionText": "Sale at price 1701.56 - 1825.05 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1554249600,
              "fmt": "2019-04-03"
            },
            "value": {
              "raw": 116941,
              "fmt": "116.94k",
              "longFmt": "116,941"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 68,
              "fmt": "68",
              "longFmt": "68"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1799.47 - 1819.72 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1553126400,
              "fmt": "2019-03-21"
            },
            "value": {
              "raw": 3622283,
              "fmt": "3.62M",
              "longFmt": "3,622,283"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 2000,
              "fmt": "2k",
              "longFmt": "2,000"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1627.95 - 1631.52 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1550793600,
              "fmt": "2019-02-22"
            },
            "value": {
              "raw": 2004776,
              "fmt": "2M",
              "longFmt": "2,004,776"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1230,
              "fmt": "1.23k",
              "longFmt": "1,230"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Sale at price 1605.35 - 1621.66 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1550707200,
              "fmt": "2019-02-21"
            },
            "value": {
              "raw": 2656094,
              "fmt": "2.66M",
              "longFmt": "2,656,094"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 1645,
              "fmt": "1.65k",
              "longFmt": "1,645"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1550534400,
              "fmt": "2019-02-19"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 250,
              "fmt": "250",
              "longFmt": "250"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "STONESIFER PATRICIA Q",
            "transactionText": "Sale at price 1602.00 per share.",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1550534400,
              "fmt": "2019-02-19"
            },
            "value": {
              "raw": 2202750,
              "fmt": "2.2M",
              "longFmt": "2,202,750"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 1375,
              "fmt": "1.38k",
              "longFmt": "1,375"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WEEKS WENDELL P",
            "transactionText": "",
            "moneyText": "",
            "ownership": "D",
            "startDate": {
              "raw": 1550188800,
              "fmt": "2019-02-15"
            },
            "filerRelation": "Director",
            "shares": {
              "raw": 455,
              "fmt": "455",
              "longFmt": "455"
            },
            "filerUrl": "",
            "maxAge": 1
          },
          {
            "filerName": "WILKE JEFFREY A",
            "transactionText": "Stock Gift at price 0.00 per share.",
            "moneyText": "",
            "ownership": "I",
            "startDate": {
              "raw": 1550188800,
              "fmt": "2019-02-15"
            },
            "value": {
              "raw": 0,
              "fmt": null,
              "longFmt": "0"
            },
            "filerRelation": "Officer",
            "shares": {
              "raw": 30808,
              "fmt": "30.81k",
              "longFmt": "30,808"
            },
            "filerUrl": "",
            "maxAge": 1
          }
        ],
        "maxAge": 1
      },
      "insiderHolders": {
        "holders": [
          {
            "maxAge": 1,
            "name": "BEZOS JEFFREY P",
            "relation": "Chief Executive Officer",
            "url": "",
            "transactionDescription": "Stock Gift",
            "latestTransDate": {
              "raw": 1598572800,
              "fmt": "2020-08-28"
            },
            "positionDirect": {
              "raw": 54474800,
              "fmt": "54.47M",
              "longFmt": "54,474,800"
            },
            "positionDirectDate": {
              "raw": 1598572800,
              "fmt": "2020-08-28"
            }
          },
          {
            "maxAge": 1,
            "name": "JASSY ANDREW R",
            "relation": "Officer",
            "url": "",
            "transactionDescription": "Sale",
            "latestTransDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "positionDirect": {
              "raw": 90035,
              "fmt": "90.03k",
              "longFmt": "90,035"
            },
            "positionDirectDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            }
          },
          {
            "maxAge": 1,
            "name": "MCGRATH JUDITH A",
            "relation": "Director",
            "url": "",
            "transactionDescription": "Sale",
            "latestTransDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "positionDirect": {
              "raw": 2324,
              "fmt": "2.32k",
              "longFmt": "2,324"
            },
            "positionDirectDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            }
          },
          {
            "maxAge": 1,
            "name": "NOOYI INDRA K",
            "relation": "Director",
            "url": "",
            "transactionDescription": "Conversion of Exercise of derivative security",
            "latestTransDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            },
            "positionDirect": {
              "raw": 651,
              "fmt": "651",
              "longFmt": "651"
            },
            "positionDirectDate": {
              "raw": 1589500800,
              "fmt": "2020-05-15"
            }
          },
          {
            "maxAge": 1,
            "name": "OLSAVSKY BRIAN T.",
            "relation": "Chief Financial Officer",
            "url": "",
            "transactionDescription": "Sale",
            "latestTransDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "positionDirect": {
              "raw": 1571,
              "fmt": "1.57k",
              "longFmt": "1,571"
            },
            "positionDirectDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            }
          },
          {
            "maxAge": 1,
            "name": "REYNOLDS SHELLEY L",
            "relation": "Officer",
            "url": "",
            "transactionDescription": "Sale",
            "latestTransDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            },
            "positionDirect": {
              "raw": 6122,
              "fmt": "6.12k",
              "longFmt": "6,122"
            },
            "positionDirectDate": {
              "raw": 1597622400,
              "fmt": "2020-08-17"
            }
          },
          {
            "maxAge": 1,
            "name": "RUBINSTEIN JONATHAN J",
            "relation": "Director",
            "url": "",
            "transactionDescription": "Stock Gift",
            "latestTransDate": {
              "raw": 1588550400,
              "fmt": "2020-05-04"
            },
            "positionDirect": {
              "raw": 7538,
              "fmt": "7.54k",
              "longFmt": "7,538"
            },
            "positionDirectDate": {
              "raw": 1588550400,
              "fmt": "2020-05-04"
            }
          },
          {
            "maxAge": 1,
            "name": "STONESIFER PATRICIA Q",
            "relation": "Director",
            "url": "",
            "transactionDescription": "Stock Gift",
            "latestTransDate": {
              "raw": 1596672000,
              "fmt": "2020-08-06"
            },
            "positionDirect": {
              "raw": 2945,
              "fmt": "2.94k",
              "longFmt": "2,945"
            },
            "positionDirectDate": {
              "raw": 1596672000,
              "fmt": "2020-08-06"
            }
          },
          {
            "maxAge": 1,
            "name": "WILKE JEFFREY A",
            "relation": "Officer",
            "url": "",
            "transactionDescription": "Stock Gift",
            "latestTransDate": {
              "raw": 1599696000,
              "fmt": "2020-09-10"
            },
            "positionDirect": {
              "raw": 52017,
              "fmt": "52.02k",
              "longFmt": "52,017"
            },
            "positionDirectDate": {
              "raw": 1599696000,
              "fmt": "2020-09-10"
            }
          },
          {
            "maxAge": 1,
            "name": "ZAPOLSKY DAVID",
            "relation": "Officer",
            "url": "",
            "transactionDescription": "Stock Gift",
            "latestTransDate": {
              "raw": 1598918400,
              "fmt": "2020-09-01"
            },
            "positionDirect": {
              "raw": 3466,
              "fmt": "3.47k",
              "longFmt": "3,466"
            },
            "positionDirectDate": {
              "raw": 1598918400,
              "fmt": "2020-09-01"
            }
          }
        ],
        "maxAge": 1
      },
      "netSharePurchaseActivity": {
        "period": "6m",
        "netPercentInsiderShares": {
          "raw": -0.012999999,
          "fmt": "-1.30%"
        },
        "netInfoCount": {
          "raw": 55,
          "fmt": "55",
          "longFmt": "55"
        },
        "totalInsiderShares": {
          "raw": 75744528,
          "fmt": "75.74M",
          "longFmt": "75,744,528"
        },
        "buyInfoShares": {
          "raw": 54775,
          "fmt": "54.77k",
          "longFmt": "54,775"
        },
        "sellInfoCount": {
          "raw": 25,
          "fmt": "25",
          "longFmt": "25"
        },
        "sellInfoShares": {
          "raw": 1043205,
          "fmt": "1.04M",
          "longFmt": "1,043,205"
        },
        "sellPercentInsiderShares": {
          "raw": 0.0139999995,
          "fmt": "1.40%"
        },
        "maxAge": 1,
        "buyInfoCount": {
          "raw": 30,
          "fmt": "30",
          "longFmt": "30"
        },
        "netInfoShares": {
          "raw": -988430,
          "fmt": "-988.43k",
          "longFmt": "-988,430"
        }
      },
      "majorHoldersBreakdown": {
        "maxAge": 1,
        "insidersPercentHeld": {
          "raw": 0.15122,
          "fmt": "15.12%"
        },
        "institutionsPercentHeld": {
          "raw": 0.57689,
          "fmt": "57.69%"
        },
        "institutionsFloatPercentHeld": {
          "raw": 0.67967004,
          "fmt": "67.97%"
        },
        "institutionsCount": {
          "raw": 4038,
          "fmt": "4.04k",
          "longFmt": "4,038"
        }
      },
      "financialData": {
        "ebitdaMargins": {
          "raw": 0.12299,
          "fmt": "12.30%"
        },
        "profitMargins": {
          "raw": 0.040960003,
          "fmt": "4.10%"
        },
        "grossMargins": {
          "raw": 0.40271,
          "fmt": "40.27%"
        },
        "operatingCashflow": {
          "raw": 51220000768,
          "fmt": "51.22B",
          "longFmt": "51,220,000,768"
        },
        "revenueGrowth": {
          "raw": 0.402,
          "fmt": "40.20%"
        },
        "operatingMargins": {
          "raw": 0.051999997,
          "fmt": "5.20%"
        },
        "ebitda": {
          "raw": 39574999040,
          "fmt": "39.57B",
          "longFmt": "39,574,999,040"
        },
        "targetLowPrice": {
          "raw": 2646,
          "fmt": "2,646.00"
        },
        "recommendationKey": "buy",
        "grossProfits": {
          "raw": 114986000000,
          "fmt": "114.99B",
          "longFmt": "114,986,000,000"
        },
        "freeCashflow": {
          "raw": 33683499008,
          "fmt": "33.68B",
          "longFmt": "33,683,499,008"
        },
        "targetMedianPrice": {
          "raw": 3700,
          "fmt": "3,700.00"
        },
        "currentPrice": {
          "raw": 3148.17,
          "fmt": "3,148.17"
        },
        "earningsGrowth": {
          "raw": 0.973,
          "fmt": "97.30%"
        },
        "currentRatio": {
          "raw": 1.181,
          "fmt": "1.18"
        },
        "returnOnAssets": {
          "raw": 0.04651,
          "fmt": "4.65%"
        },
        "numberOfAnalystOpinions": {
          "raw": 45,
          "fmt": "45",
          "longFmt": "45"
        },
        "targetMeanPrice": {
          "raw": 3724.98,
          "fmt": "3,724.98"
        },
        "debtToEquity": {
          "raw": 123.971,
          "fmt": "123.97"
        },
        "returnOnEquity": {
          "raw": 0.2079,
          "fmt": "20.79%"
        },
        "targetHighPrice": {
          "raw": 4500,
          "fmt": "4,500.00"
        },
        "totalCash": {
          "raw": 71391002624,
          "fmt": "71.39B",
          "longFmt": "71,391,002,624"
        },
        "totalDebt": {
          "raw": 91401003008,
          "fmt": "91.4B",
          "longFmt": "91,401,003,008"
        },
        "totalRevenue": {
          "raw": 321781989376,
          "fmt": "321.78B",
          "longFmt": "321,781,989,376"
        },
        "totalCashPerShare": {
          "raw": 142.528,
          "fmt": "142.53"
        },
        "financialCurrency": "USD",
        "maxAge": 86400,
        "revenuePerShare": {
          "raw": 646.798,
          "fmt": "646.80"
        },
        "quickRatio": {
          "raw": 0.969,
          "fmt": "0.97"
        },
        "recommendationMean": {
          "raw": 1.7,
          "fmt": "1.70"
        }
      },
      "quoteType": {
        "exchange": "NMS",
        "shortName": "Amazon.com, Inc.",
        "longName": "Amazon.com, Inc.",
        "exchangeTimezoneName": "America/New_York",
        "exchangeTimezoneShortName": "EDT",
        "isEsgPopulated": false,
        "gmtOffSetMilliseconds": "-14400000",
        "quoteType": "EQUITY",
        "symbol": "AMZN",
        "messageBoardId": "finmb_18749",
        "market": "us_market"
      },
      "institutionOwnership": {
        "maxAge": 1,
        "ownershipList": [
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Vanguard Group, Inc. (The)",
            "pctHeld": {
              "raw": 0.065799996,
              "fmt": "6.58%"
            },
            "position": {
              "raw": 32974031,
              "fmt": "32.97M",
              "longFmt": "32,974,031"
            },
            "value": {
              "raw": 90969416203,
              "fmt": "90.97B",
              "longFmt": "90,969,416,203"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Blackrock Inc.",
            "pctHeld": {
              "raw": 0.0557,
              "fmt": "5.57%"
            },
            "position": {
              "raw": 27918157,
              "fmt": "27.92M",
              "longFmt": "27,918,157"
            },
            "value": {
              "raw": 77021169894,
              "fmt": "77.02B",
              "longFmt": "77,021,169,894"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "State Street Corporation",
            "pctHeld": {
              "raw": 0.0326,
              "fmt": "3.26%"
            },
            "position": {
              "raw": 16344836,
              "fmt": "16.34M",
              "longFmt": "16,344,836"
            },
            "value": {
              "raw": 45092460453,
              "fmt": "45.09B",
              "longFmt": "45,092,460,453"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "FMR, LLC",
            "pctHeld": {
              "raw": 0.032,
              "fmt": "3.20%"
            },
            "position": {
              "raw": 16051633,
              "fmt": "16.05M",
              "longFmt": "16,051,633"
            },
            "value": {
              "raw": 44283566153,
              "fmt": "44.28B",
              "longFmt": "44,283,566,153"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Price (T.Rowe) Associates Inc",
            "pctHeld": {
              "raw": 0.0315,
              "fmt": "3.15%"
            },
            "position": {
              "raw": 15773241,
              "fmt": "15.77M",
              "longFmt": "15,773,241"
            },
            "value": {
              "raw": 43515532735,
              "fmt": "43.52B",
              "longFmt": "43,515,532,735"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Geode Capital Management, LLC",
            "pctHeld": {
              "raw": 0.0125,
              "fmt": "1.25%"
            },
            "position": {
              "raw": 6265690,
              "fmt": "6.27M",
              "longFmt": "6,265,690"
            },
            "value": {
              "raw": 17285910885,
              "fmt": "17.29B",
              "longFmt": "17,285,910,885"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Northern Trust Corporation",
            "pctHeld": {
              "raw": 0.0099,
              "fmt": "0.99%"
            },
            "position": {
              "raw": 4966476,
              "fmt": "4.97M",
              "longFmt": "4,966,476"
            },
            "value": {
              "raw": 13701613318,
              "fmt": "13.7B",
              "longFmt": "13,701,613,318"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Morgan Stanley",
            "pctHeld": {
              "raw": 0.0092,
              "fmt": "0.92%"
            },
            "position": {
              "raw": 4616523,
              "fmt": "4.62M",
              "longFmt": "4,616,523"
            },
            "value": {
              "raw": 12736155982,
              "fmt": "12.74B",
              "longFmt": "12,736,155,982"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "organization": "Bank Of New York Mellon Corporation",
            "pctHeld": {
              "raw": 0.009,
              "fmt": "0.90%"
            },
            "position": {
              "raw": 4516147,
              "fmt": "4.52M",
              "longFmt": "4,516,147"
            },
            "value": {
              "raw": 12459236666,
              "fmt": "12.46B",
              "longFmt": "12,459,236,666"
            }
          },
          {
            "maxAge": 1,
            "reportDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "organization": "Norges Bank Investment Management",
            "pctHeld": {
              "raw": 0.0087,
              "fmt": "0.87%"
            },
            "position": {
              "raw": 4367787,
              "fmt": "4.37M",
              "longFmt": "4,367,787"
            },
            "value": {
              "raw": 8070971530,
              "fmt": "8.07B",
              "longFmt": "8,070,971,530"
            }
          }
        ]
      },
      "calendarEvents": {
        "maxAge": 1,
        "earnings": {
          "earningsDate": [
            {
              "raw": 1603929600,
              "fmt": "2020-10-29"
            }
          ],
          "earningsAverage": {
            "raw": 7.25,
            "fmt": "7.25"
          },
          "earningsLow": {
            "raw": 4.62,
            "fmt": "4.62"
          },
          "earningsHigh": {
            "raw": 11.96,
            "fmt": "11.96"
          },
          "revenueAverage": {
            "raw": 92483100000,
            "fmt": "92.48B",
            "longFmt": "92,483,100,000"
          },
          "revenueLow": {
            "raw": 90073000000,
            "fmt": "90.07B",
            "longFmt": "90,073,000,000"
          },
          "revenueHigh": {
            "raw": 95652400000,
            "fmt": "95.65B",
            "longFmt": "95,652,400,000"
          }
        },
        "exDividendDate": {},
        "dividendDate": {}
      },
      "summaryDetail": {
        "previousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "twoHundredDayAverage": {
          "raw": 2856.3691,
          "fmt": "2,856.37"
        },
        "trailingAnnualDividendYield": {},
        "payoutRatio": {
          "raw": 0,
          "fmt": "0.00%"
        },
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "navPrice": {},
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "totalAssets": {},
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "fiftyDayAverage": {
          "raw": 3190.4482,
          "fmt": "3,190.45"
        },
        "trailingAnnualDividendRate": {},
        "open": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "toCurrency": null,
        "averageVolume10days": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "expireDate": {},
        "yield": {},
        "algorithm": null,
        "dividendRate": {},
        "exDividendDate": {},
        "beta": {
          "raw": 1.353006,
          "fmt": "1.35"
        },
        "circulatingSupply": {},
        "startDate": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "trailingPE": {
          "raw": 120.91139,
          "fmt": "120.91"
        },
        "regularMarketVolume": {
          "raw": 2361659,
          "fmt": "2.36M",
          "longFmt": "2,361,659"
        },
        "lastMarket": null,
        "maxSupply": {},
        "openInterest": {},
        "marketCap": {
          "raw": 1576886730752,
          "fmt": "1.58T",
          "longFmt": "1,576,886,730,752"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "averageVolume": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "priceToSalesTrailing12Months": {
          "raw": 4.9004817,
          "fmt": "4.90"
        },
        "dayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "ask": {
          "raw": 3139.24,
          "fmt": "3,139.24"
        },
        "ytdReturn": {},
        "askSize": {
          "raw": 3000,
          "fmt": "3k",
          "longFmt": "3,000"
        },
        "volume": {
          "raw": 2361659,
          "fmt": "2.36M",
          "longFmt": "2,361,659"
        },
        "fiftyTwoWeekHigh": {
          "raw": 3552.25,
          "fmt": "3,552.25"
        },
        "forwardPE": {
          "raw": 70.95267,
          "fmt": "70.95"
        },
        "maxAge": 1,
        "fromCurrency": null,
        "fiveYearAvgDividendYield": {},
        "fiftyTwoWeekLow": {
          "raw": 1626.03,
          "fmt": "1,626.03"
        },
        "bid": {
          "raw": 3137.56,
          "fmt": "3,137.56"
        },
        "tradeable": false,
        "dividendYield": {},
        "bidSize": {
          "raw": 1100,
          "fmt": "1.1k",
          "longFmt": "1,100"
        },
        "dayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        }
      },
      "symbol": "AMZN",
      "esgScores": {
        "palmOil": false,
        "peerSocialPerformance": {
          "min": 3.85,
          "avg": 7.61241379310345,
          "max": 12.52
        },
        "controversialWeapons": false,
        "ratingMonth": 10,
        "gambling": false,
        "socialScore": {
          "raw": 12.52,
          "fmt": "12.5"
        },
        "nuclear": false,
        "furLeather": false,
        "alcoholic": false,
        "gmo": false,
        "catholic": false,
        "socialPercentile": null,
        "peerGovernancePerformance": {
          "min": 2.99,
          "avg": 5.948448275862069,
          "max": 10.25
        },
        "peerCount": 62,
        "relatedControversy": [
          "Employee Incidents",
          "Social Supply Chain Incidents",
          "Customer Incidents",
          "Business Ethics Incidents"
        ],
        "governanceScore": {
          "raw": 9.78,
          "fmt": "9.8"
        },
        "environmentPercentile": null,
        "animalTesting": false,
        "peerEsgScorePerformance": {
          "min": 9.56,
          "avg": 16.761612903225807,
          "max": 27.42
        },
        "tobacco": false,
        "totalEsg": {
          "raw": 27.42,
          "fmt": "27.4"
        },
        "highestControversy": 3,
        "esgPerformance": "AVG_PERF",
        "coal": false,
        "peerHighestControversyPerformance": {
          "min": 0,
          "avg": 1.7419354838709677,
          "max": 3
        },
        "pesticides": false,
        "adult": false,
        "ratingYear": 2020,
        "maxAge": 86400,
        "percentile": {
          "raw": 46.66,
          "fmt": "47"
        },
        "peerGroup": "Retailing",
        "smallArms": false,
        "peerEnvironmentPerformance": {
          "min": 0.03,
          "avg": 3.092413793103449,
          "max": 7.06
        },
        "environmentScore": {
          "raw": 5.13,
          "fmt": "5.1"
        },
        "governancePercentile": null,
        "militaryContract": false
      },
      "upgradeDowngradeHistory": {
        "history": [
          {
            "epochGradeDate": 1602850533,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602761580,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602259918,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602068039,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1601557302,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1600771861,
            "firm": "Bernstein",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1596202990,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596199722,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596195986,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596195716,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596193180,
            "firm": "Needham",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596184984,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596127912,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595859868,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595594151,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595580207,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595248547,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1594637221,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1594124960,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593523799,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593178057,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593177953,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591622085,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591621294,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591013273,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588352186,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588348269,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344669,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344475,
            "firm": "Guggenheim",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344239,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344081,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588338598,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588338165,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588334977,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "reit"
          },
          {
            "epochGradeDate": 1588334844,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588333861,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588333153,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588332475,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330464,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330355,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330243,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588327554,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588253465,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587999963,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587992689,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587990385,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587746820,
            "firm": "Stifel",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587646973,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587568433,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1586965916,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1585225808,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1584458683,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1581608820,
            "firm": "Aegis Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580905628,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580491830,
            "firm": "CFRA",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580487947,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580485543,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580484494,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580483930,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "reit"
          },
          {
            "epochGradeDate": 1580479677,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580476098,
            "firm": "Piper Sandler",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580476024,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475870,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475709,
            "firm": "Stifel",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475630,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475135,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580474740,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472258,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472207,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472088,
            "firm": "Wells Fargo",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580467903,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580305170,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580305088,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580128735,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579707810,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579265841,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579183053,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572012335,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572010119,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572009847,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572009518,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572007464,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572007105,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572005722,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003330,
            "firm": "Piper Jaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003267,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003183,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003125,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1571660240,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1569241247,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1567509298,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564148885,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564146031,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564145147,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564142904,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564139707,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563968948,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563789703,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563194075,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1556286403,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556286191,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1556285826,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556285551,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556284381,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556284089,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283804,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283429,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283090,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1552645126,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "Sector Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1549026083,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1549025018,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1548247951,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540568165,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540563922,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540562392,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1540300461,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1538046902,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1537880370,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1536581666,
            "firm": "Wells Fargo",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1536577864,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1536151685,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1535541478,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532705774,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532705036,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1532704752,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1532703191,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532702595,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532699185,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532698825,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532692331,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532691504,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1531745433,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1531499749,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1531489660,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1528978353,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1528121868,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "reit"
          },
          {
            "epochGradeDate": 1525528836,
            "firm": "B. Riley FBR",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1525527134,
            "firm": "Argus",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1524840711,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524835866,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1524834218,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524831340,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524830993,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1524829204,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1524227202,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524138688,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1519228980,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517835243,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517587947,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1517586641,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1517584163,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1517582814,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517580664,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1517579506,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1516995809,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1516711103,
            "firm": "Loop Capital",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1515160436,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1511183102,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509385040,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509132041,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509127449,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509126585,
            "firm": "Loop Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509122381,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509119232,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509107954,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509106277,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509103387,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1508846359,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1507732645,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1500577730,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1500384110,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1493383553,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "reit"
          },
          {
            "epochGradeDate": 1493382113,
            "firm": "Pacific Crest",
            "toGrade": "Sector Weight",
            "fromGrade": "Overweight",
            "action": "down"
          },
          {
            "epochGradeDate": 1493128067,
            "firm": "Raymond James",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1493034709,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1492703695,
            "firm": "Wolfe Research",
            "toGrade": "Peer Perform",
            "fromGrade": "Outperform",
            "action": "down"
          },
          {
            "epochGradeDate": 1491834059,
            "firm": "Needham",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1491315938,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1480354388,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1480335180,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1477994732,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1477294704,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1476692067,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475679074,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475679061,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475231868,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475219367,
            "firm": "Guggenheim",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1475143214,
            "firm": "Maxim Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1474960027,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1470143957,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469799730,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469797781,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469797118,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469788989,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469778745,
            "firm": "CLSA",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469776676,
            "firm": "Pacific Crest",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469776606,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469775942,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469774582,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469427403,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469081816,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1466656112,
            "firm": "Maxim Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1466063607,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1465539261,
            "firm": "William Blair",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1462272184,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461904487,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461904263,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461903707,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461903236,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1460030851,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1459492695,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1459239653,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1458624080,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Strong Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1456900614,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1456731325,
            "firm": "Bernstein",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1455769312,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1454054828,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1453203226,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1452841437,
            "firm": "Susquehanna",
            "toGrade": "Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1452572776,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1451893713,
            "firm": "Monness Crespi Hardt",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1450774272,
            "firm": "Macquarie",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1450162559,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1449648213,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1449559447,
            "firm": "Pacific Crest",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1448942499,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445930684,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445604845,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445596322,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445585575,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445582670,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445580512,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579475,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579277,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579164,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445578828,
            "firm": "Baird",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445578813,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1441952731,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1440658736,
            "firm": "Raymond James",
            "toGrade": "Strong Buy",
            "fromGrade": "Outperform",
            "action": "up"
          },
          {
            "epochGradeDate": 1440570551,
            "firm": "Evercore ISI Group",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1438152957,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1437735600,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437725582,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437720750,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437712416,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437710308,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437710143,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Equal-Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1437549413,
            "firm": "JMP Securities",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1437375485,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437375308,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1437375135,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1436946437,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1436851298,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1435298143,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1435210363,
            "firm": "Evercore ISI Group",
            "toGrade": "",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1434354039,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1433305233,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1430730000,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1429866000,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1429860251,
            "firm": "Janney Capital",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429856558,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1429856435,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429689230,
            "firm": "Monness Crespi Hardt",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429610895,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1429002000,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1425979742,
            "firm": "Wolfe Research",
            "toGrade": "Outperform",
            "fromGrade": "Peer Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1425888988,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1425882793,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1425449151,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1424327255,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422608400,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422349200,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422003020,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1421855313,
            "firm": "BGC Financial",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1421107200,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1417155008,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1416528000,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414569337,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414398600,
            "firm": "Monness, Crespi, Hardt",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414141200,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1414139400,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1413216000,
            "firm": "Wolfe Research",
            "toGrade": "",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1413189000,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1412931600,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406323278,
            "firm": "CRT Capital",
            "toGrade": "Fair Value",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406321095,
            "firm": "Citigroup",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406321093,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406273324,
            "firm": "Raymond James",
            "toGrade": "Market Perform",
            "fromGrade": "Outperform",
            "action": "down"
          },
          {
            "epochGradeDate": 1406254590,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406252455,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406248769,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406247747,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406010002,
            "firm": "Citigroup",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1403764014,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1398873600,
            "firm": "Edward Jones",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1398467992,
            "firm": "Cantor Fitzgerald",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398412800,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Strong Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1398409757,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398395478,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398393545,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398391606,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398386062,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1397635497,
            "firm": "Argus Capital",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1392220800,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1391169372,
            "firm": "FBN Securities",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391155200,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391153689,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391150848,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1390838400,
            "firm": "Pacific Crest",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1389686709,
            "firm": "FBN Securities",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1389342600,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388990834,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388764800,
            "firm": "Topeka",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388505600,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1387262989,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1384417940,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382968950,
            "firm": "Standpoint",
            "toGrade": "Sell",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1382945547,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382687911,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382685973,
            "firm": "Raymond James",
            "toGrade": "Strong Buy",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1382438725,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382080642,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1379574000,
            "firm": "CRT Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1378882402,
            "firm": "Wedbush",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1374829535,
            "firm": "BMO Capital",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1374824865,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1373961231,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1373472676,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1373390911,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1368691091,
            "firm": "Lazard",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1367487786,
            "firm": "Tigress Financial",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1366963317,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1366618113,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1366185916,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1363680464,
            "firm": "JMP Securities",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1363242452,
            "firm": "PiperJaffray",
            "toGrade": "Neutral",
            "fromGrade": "Overweight",
            "action": "down"
          },
          {
            "epochGradeDate": 1361347547,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359552425,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359540668,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359540255,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359533243,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359531886,
            "firm": "Credit Agricole",
            "toGrade": "Outperform",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1359531597,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359531237,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359530684,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359389631,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359366009,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359364847,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359109097,
            "firm": "ISI Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1359101356,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359043430,
            "firm": "ISI Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1358496653,
            "firm": "Pacific Crest",
            "toGrade": "Outperform",
            "fromGrade": "Sector Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1357713892,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1357540365,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Equal-Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1351170540,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1348208580,
            "firm": "Cantor Fitzgerald",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1347365820,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1347000720,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1346395500,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1343378100,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1343372400,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1342506540,
            "firm": "Lazard",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1341991740,
            "firm": "BMO Capital",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1338965820,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1337061720,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335526620,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335522540,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335517380,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335516060,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335515880,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335514680,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335514140,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335511200,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335507660,
            "firm": "Bank oferica",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1333346760,
            "firm": "Bank oferica",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1329373020,
            "firm": "Morgan Stanley",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1329291180,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1325162820,
            "firm": "PiperJaffray",
            "toGrade": "",
            "fromGrade": "",
            "action": "main"
          }
        ],
        "maxAge": 86400
      },
      "pageViews": {
        "shortTermTrend": "UP",
        "midTermTrend": "UP",
        "longTermTrend": "UP",
        "maxAge": 1
      }
    }
```

</details>

### get-analysis Query

```python
import requests

url = "https://rapidapi.p.rapidapi.com/stock/v2/get-analysis"

querystring = {"symbol":"AMZN","region":"US"}

headers = {
    'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
    'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
```

<details>
  <summary>Here's the response of the above request:</summary>

```json
    {
      "recommendationTrend": {
        "trend": [
          {
            "period": "0m",
            "strongBuy": 15,
            "buy": 28,
            "hold": 3,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-1m",
            "strongBuy": 18,
            "buy": 27,
            "hold": 2,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-2m",
            "strongBuy": 17,
            "buy": 28,
            "hold": 4,
            "sell": 1,
            "strongSell": 0
          },
          {
            "period": "-3m",
            "strongBuy": 19,
            "buy": 29,
            "hold": 2,
            "sell": 0,
            "strongSell": 0
          }
        ],
        "maxAge": 86400
      },
      "financialsTemplate": {
        "code": "N",
        "maxAge": 1
      },
      "price": {
        "quoteSourceName": "Nasdaq Real Time Price",
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "averageDailyVolume3Month": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "exchange": "NMS",
        "regularMarketTime": 1603386055,
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "shortName": "Amazon.com, Inc.",
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "longName": "Amazon.com, Inc.",
        "regularMarketChange": {
          "raw": -35.764893,
          "fmt": "-35.76"
        },
        "currencySymbol": "$",
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "preMarketPrice": {
          "raw": 3189.47,
          "fmt": "3,189.47"
        },
        "preMarketTime": 1603373399,
        "exchangeDataDelayedBy": 0,
        "toCurrency": null,
        "postMarketChange": {},
        "postMarketPrice": {},
        "exchangeName": "NasdaqGS",
        "preMarketChange": {
          "raw": 4.53003,
          "fmt": "4.53"
        },
        "circulatingSupply": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "regularMarketPrice": {
          "raw": 3149.175,
          "fmt": "3,149.18"
        },
        "regularMarketVolume": {
          "raw": 2288802,
          "fmt": "2.29M",
          "longFmt": "2,288,802.00"
        },
        "lastMarket": null,
        "regularMarketSource": "FREE_REALTIME",
        "openInterest": {},
        "marketState": "REGULAR",
        "underlyingSymbol": null,
        "marketCap": {
          "raw": 1577390178304,
          "fmt": "1.58T",
          "longFmt": "1,577,390,178,304.00"
        },
        "quoteType": "EQUITY",
        "preMarketChangePercent": {
          "raw": 0.00142233,
          "fmt": "0.14%"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "symbol": "AMZN",
        "preMarketSource": "FREE_REALTIME",
        "maxAge": 1,
        "fromCurrency": null,
        "regularMarketChangePercent": {
          "raw": -0.011229378,
          "fmt": "-1.12%"
        }
      },
      "earningsHistory": {
        "history": [
          {
            "maxAge": 1,
            "epsActual": {
              "raw": 4.23,
              "fmt": "4.23"
            },
            "epsEstimate": {
              "raw": 4.62,
              "fmt": "4.62"
            },
            "epsDifference": {
              "raw": -0.39,
              "fmt": "-0.39"
            },
            "surprisePercent": {
              "raw": -0.084,
              "fmt": "-8.40%"
            },
            "quarter": {
              "raw": 1569801600,
              "fmt": "2019-09-30"
            },
            "period": "-4q"
          },
          {
            "maxAge": 1,
            "epsActual": {
              "raw": 6.47,
              "fmt": "6.47"
            },
            "epsEstimate": {
              "raw": 4.03,
              "fmt": "4.03"
            },
            "epsDifference": {
              "raw": 2.44,
              "fmt": "2.44"
            },
            "surprisePercent": {
              "raw": 0.605,
              "fmt": "60.50%"
            },
            "quarter": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "period": "-3q"
          },
          {
            "maxAge": 1,
            "epsActual": {
              "raw": 5.01,
              "fmt": "5.01"
            },
            "epsEstimate": {
              "raw": 6.25,
              "fmt": "6.25"
            },
            "epsDifference": {
              "raw": -1.24,
              "fmt": "-1.24"
            },
            "surprisePercent": {
              "raw": -0.198,
              "fmt": "-19.80%"
            },
            "quarter": {
              "raw": 1585612800,
              "fmt": "2020-03-31"
            },
            "period": "-2q"
          },
          {
            "maxAge": 1,
            "epsActual": {
              "raw": 10.3,
              "fmt": "10.3"
            },
            "epsEstimate": {
              "raw": 1.46,
              "fmt": "1.46"
            },
            "epsDifference": {
              "raw": 8.84,
              "fmt": "8.84"
            },
            "surprisePercent": {
              "raw": 6.055,
              "fmt": "605.50%"
            },
            "quarter": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "period": "-1q"
          }
        ],
        "maxAge": 86400
      },
      "indexTrend": {
        "maxAge": 1,
        "symbol": "SP5",
        "peRatio": {
          "raw": 17.4995,
          "fmt": "17.50"
        },
        "pegRatio": {
          "raw": 5.29875,
          "fmt": "5.30"
        },
        "estimates": [
          {
            "period": "0q",
            "growth": {
              "raw": -0.16,
              "fmt": "-0.16"
            }
          },
          {
            "period": "+1q",
            "growth": {
              "raw": 0.127,
              "fmt": "0.13"
            }
          },
          {
            "period": "0y",
            "growth": {
              "raw": -0.162,
              "fmt": "-0.16"
            }
          },
          {
            "period": "+1y",
            "growth": {
              "raw": 0.257,
              "fmt": "0.26"
            }
          },
          {
            "period": "+5y",
            "growth": {
              "raw": 0.049554702,
              "fmt": "0.05"
            }
          },
          {
            "period": "-5y",
            "growth": {}
          }
        ]
      },
      "financialData": {
        "ebitdaMargins": {
          "raw": 0.12299,
          "fmt": "12.30%"
        },
        "profitMargins": {
          "raw": 0.040960003,
          "fmt": "4.10%"
        },
        "grossMargins": {
          "raw": 0.40271,
          "fmt": "40.27%"
        },
        "operatingCashflow": {
          "raw": 51220000768,
          "fmt": "51.22B",
          "longFmt": "51,220,000,768"
        },
        "revenueGrowth": {
          "raw": 0.402,
          "fmt": "40.20%"
        },
        "operatingMargins": {
          "raw": 0.051999997,
          "fmt": "5.20%"
        },
        "ebitda": {
          "raw": 39574999040,
          "fmt": "39.57B",
          "longFmt": "39,574,999,040"
        },
        "targetLowPrice": {
          "raw": 2646,
          "fmt": "2,646.00"
        },
        "recommendationKey": "buy",
        "grossProfits": {
          "raw": 114986000000,
          "fmt": "114.99B",
          "longFmt": "114,986,000,000"
        },
        "freeCashflow": {
          "raw": 33683499008,
          "fmt": "33.68B",
          "longFmt": "33,683,499,008"
        },
        "targetMedianPrice": {
          "raw": 3700,
          "fmt": "3,700.00"
        },
        "currentPrice": {
          "raw": 3149.175,
          "fmt": "3,149.18"
        },
        "earningsGrowth": {
          "raw": 0.973,
          "fmt": "97.30%"
        },
        "currentRatio": {
          "raw": 1.181,
          "fmt": "1.18"
        },
        "returnOnAssets": {
          "raw": 0.04651,
          "fmt": "4.65%"
        },
        "numberOfAnalystOpinions": {
          "raw": 45,
          "fmt": "45",
          "longFmt": "45"
        },
        "targetMeanPrice": {
          "raw": 3724.98,
          "fmt": "3,724.98"
        },
        "debtToEquity": {
          "raw": 123.971,
          "fmt": "123.97"
        },
        "returnOnEquity": {
          "raw": 0.2079,
          "fmt": "20.79%"
        },
        "targetHighPrice": {
          "raw": 4500,
          "fmt": "4,500.00"
        },
        "totalCash": {
          "raw": 71391002624,
          "fmt": "71.39B",
          "longFmt": "71,391,002,624"
        },
        "totalDebt": {
          "raw": 91401003008,
          "fmt": "91.4B",
          "longFmt": "91,401,003,008"
        },
        "totalRevenue": {
          "raw": 321781989376,
          "fmt": "321.78B",
          "longFmt": "321,781,989,376"
        },
        "totalCashPerShare": {
          "raw": 142.528,
          "fmt": "142.53"
        },
        "financialCurrency": "USD",
        "maxAge": 86400,
        "revenuePerShare": {
          "raw": 646.798,
          "fmt": "646.80"
        },
        "quickRatio": {
          "raw": 0.969,
          "fmt": "0.97"
        },
        "recommendationMean": {
          "raw": 1.7,
          "fmt": "1.70"
        }
      },
      "earningsTrend": {
        "trend": [
          {
            "maxAge": 1,
            "period": "0q",
            "endDate": "2020-09-30",
            "growth": {
              "raw": 0.714,
              "fmt": "71.40%"
            },
            "earningsEstimate": {
              "avg": {
                "raw": 7.25,
                "fmt": "7.25"
              },
              "low": {
                "raw": 4.62,
                "fmt": "4.62"
              },
              "high": {
                "raw": 11.96,
                "fmt": "11.96"
              },
              "yearAgoEps": {
                "raw": 4.23,
                "fmt": "4.23"
              },
              "numberOfAnalysts": {
                "raw": 40,
                "fmt": "40",
                "longFmt": "40"
              },
              "growth": {
                "raw": 0.714,
                "fmt": "71.40%"
              }
            },
            "revenueEstimate": {
              "avg": {
                "raw": 92483100000,
                "fmt": "92.48B",
                "longFmt": "92,483,100,000"
              },
              "low": {
                "raw": 90073000000,
                "fmt": "90.07B",
                "longFmt": "90,073,000,000"
              },
              "high": {
                "raw": 95652400000,
                "fmt": "95.65B",
                "longFmt": "95,652,400,000"
              },
              "numberOfAnalysts": {
                "raw": 39,
                "fmt": "39",
                "longFmt": "39"
              },
              "yearAgoRevenue": {
                "raw": 69981000000,
                "fmt": "69.98B",
                "longFmt": "69,981,000,000"
              },
              "growth": {
                "raw": 0.322,
                "fmt": "32.20%"
              }
            },
            "epsTrend": {
              "current": {
                "raw": 7.25,
                "fmt": "7.25"
              },
              "7daysAgo": {
                "raw": 7.25,
                "fmt": "7.25"
              },
              "30daysAgo": {
                "raw": 7.21,
                "fmt": "7.21"
              },
              "60daysAgo": {
                "raw": 7.25,
                "fmt": "7.25"
              },
              "90daysAgo": {
                "raw": 4.38,
                "fmt": "4.38"
              }
            },
            "epsRevisions": {
              "upLast7days": {
                "raw": 0,
                "fmt": null,
                "longFmt": "0"
              },
              "upLast30days": {
                "raw": 3,
                "fmt": "3",
                "longFmt": "3"
              },
              "downLast30days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "downLast90days": {}
            }
          },
          {
            "maxAge": 1,
            "period": "+1q",
            "endDate": "2020-12-31",
            "growth": {
              "raw": 0.371,
              "fmt": "37.10%"
            },
            "earningsEstimate": {
              "avg": {
                "raw": 8.87,
                "fmt": "8.87"
              },
              "low": {
                "raw": 4.71,
                "fmt": "4.71"
              },
              "high": {
                "raw": 15.55,
                "fmt": "15.55"
              },
              "yearAgoEps": {
                "raw": 6.47,
                "fmt": "6.47"
              },
              "numberOfAnalysts": {
                "raw": 39,
                "fmt": "39",
                "longFmt": "39"
              },
              "growth": {
                "raw": 0.371,
                "fmt": "37.10%"
              }
            },
            "revenueEstimate": {
              "avg": {
                "raw": 111407000000,
                "fmt": "111.41B",
                "longFmt": "111,407,000,000"
              },
              "low": {
                "raw": 104160000000,
                "fmt": "104.16B",
                "longFmt": "104,160,000,000"
              },
              "high": {
                "raw": 116072000000,
                "fmt": "116.07B",
                "longFmt": "116,072,000,000"
              },
              "numberOfAnalysts": {
                "raw": 39,
                "fmt": "39",
                "longFmt": "39"
              },
              "yearAgoRevenue": {
                "raw": 87437000000,
                "fmt": "87.44B",
                "longFmt": "87,437,000,000"
              },
              "growth": {
                "raw": 0.274,
                "fmt": "27.40%"
              }
            },
            "epsTrend": {
              "current": {
                "raw": 8.87,
                "fmt": "8.87"
              },
              "7daysAgo": {
                "raw": 8.87,
                "fmt": "8.87"
              },
              "30daysAgo": {
                "raw": 8.83,
                "fmt": "8.83"
              },
              "60daysAgo": {
                "raw": 8.89,
                "fmt": "8.89"
              },
              "90daysAgo": {
                "raw": 7.45,
                "fmt": "7.45"
              }
            },
            "epsRevisions": {
              "upLast7days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "upLast30days": {
                "raw": 4,
                "fmt": "4",
                "longFmt": "4"
              },
              "downLast30days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "downLast90days": {}
            }
          },
          {
            "maxAge": 1,
            "period": "0y",
            "endDate": "2020-12-31",
            "growth": {
              "raw": 0.38,
              "fmt": "38.00%"
            },
            "earningsEstimate": {
              "avg": {
                "raw": 31.75,
                "fmt": "31.75"
              },
              "low": {
                "raw": 24.64,
                "fmt": "24.64"
              },
              "high": {
                "raw": 42.87,
                "fmt": "42.87"
              },
              "yearAgoEps": {
                "raw": 23.01,
                "fmt": "23.01"
              },
              "numberOfAnalysts": {
                "raw": 47,
                "fmt": "47",
                "longFmt": "47"
              },
              "growth": {
                "raw": 0.38,
                "fmt": "38.00%"
              }
            },
            "revenueEstimate": {
              "avg": {
                "raw": 368876000000,
                "fmt": "368.88B",
                "longFmt": "368,876,000,000"
              },
              "low": {
                "raw": 359412000000,
                "fmt": "359.41B",
                "longFmt": "359,412,000,000"
              },
              "high": {
                "raw": 380759000000,
                "fmt": "380.76B",
                "longFmt": "380,759,000,000"
              },
              "numberOfAnalysts": {
                "raw": 46,
                "fmt": "46",
                "longFmt": "46"
              },
              "yearAgoRevenue": {
                "raw": 280522000000,
                "fmt": "280.52B",
                "longFmt": "280,522,000,000"
              },
              "growth": {
                "raw": 0.315,
                "fmt": "31.50%"
              }
            },
            "epsTrend": {
              "current": {
                "raw": 31.75,
                "fmt": "31.75"
              },
              "7daysAgo": {
                "raw": 31.75,
                "fmt": "31.75"
              },
              "30daysAgo": {
                "raw": 31.61,
                "fmt": "31.61"
              },
              "60daysAgo": {
                "raw": 31.64,
                "fmt": "31.64"
              },
              "90daysAgo": {
                "raw": 18.79,
                "fmt": "18.79"
              }
            },
            "epsRevisions": {
              "upLast7days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "upLast30days": {
                "raw": 6,
                "fmt": "6",
                "longFmt": "6"
              },
              "downLast30days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "downLast90days": {}
            }
          },
          {
            "maxAge": 1,
            "period": "+1y",
            "endDate": "2021-12-31",
            "growth": {
              "raw": 0.397,
              "fmt": "39.70%"
            },
            "earningsEstimate": {
              "avg": {
                "raw": 44.37,
                "fmt": "44.37"
              },
              "low": {
                "raw": 32.55,
                "fmt": "32.55"
              },
              "high": {
                "raw": 69.58,
                "fmt": "69.58"
              },
              "yearAgoEps": {
                "raw": 31.75,
                "fmt": "31.75"
              },
              "numberOfAnalysts": {
                "raw": 48,
                "fmt": "48",
                "longFmt": "48"
              },
              "growth": {
                "raw": 0.397,
                "fmt": "39.70%"
              }
            },
            "revenueEstimate": {
              "avg": {
                "raw": 436321000000,
                "fmt": "436.32B",
                "longFmt": "436,321,000,000"
              },
              "low": {
                "raw": 383514000000,
                "fmt": "383.51B",
                "longFmt": "383,514,000,000"
              },
              "high": {
                "raw": 477820000000,
                "fmt": "477.82B",
                "longFmt": "477,820,000,000"
              },
              "numberOfAnalysts": {
                "raw": 46,
                "fmt": "46",
                "longFmt": "46"
              },
              "yearAgoRevenue": {
                "raw": 368876000000,
                "fmt": "368.88B",
                "longFmt": "368,876,000,000"
              },
              "growth": {
                "raw": 0.183,
                "fmt": "18.30%"
              }
            },
            "epsTrend": {
              "current": {
                "raw": 44.37,
                "fmt": "44.37"
              },
              "7daysAgo": {
                "raw": 44.37,
                "fmt": "44.37"
              },
              "30daysAgo": {
                "raw": 44.13,
                "fmt": "44.13"
              },
              "60daysAgo": {
                "raw": 44.27,
                "fmt": "44.27"
              },
              "90daysAgo": {
                "raw": 37.6,
                "fmt": "37.6"
              }
            },
            "epsRevisions": {
              "upLast7days": {
                "raw": 0,
                "fmt": null,
                "longFmt": "0"
              },
              "upLast30days": {
                "raw": 5,
                "fmt": "5",
                "longFmt": "5"
              },
              "downLast30days": {
                "raw": 1,
                "fmt": "1",
                "longFmt": "1"
              },
              "downLast90days": {}
            }
          },
          {
            "maxAge": 1,
            "period": "+5y",
            "endDate": null,
            "growth": {
              "raw": 0.36029997,
              "fmt": "36.03%"
            },
            "earningsEstimate": {
              "avg": {},
              "low": {},
              "high": {},
              "yearAgoEps": {},
              "numberOfAnalysts": {},
              "growth": {}
            },
            "revenueEstimate": {
              "avg": {},
              "low": {},
              "high": {},
              "numberOfAnalysts": {},
              "yearAgoRevenue": {},
              "growth": {}
            },
            "epsTrend": {
              "current": {},
              "7daysAgo": {},
              "30daysAgo": {},
              "60daysAgo": {},
              "90daysAgo": {}
            },
            "epsRevisions": {
              "upLast7days": {},
              "upLast30days": {},
              "downLast30days": {},
              "downLast90days": {}
            }
          },
          {
            "maxAge": 1,
            "period": "-5y",
            "endDate": null,
            "growth": {
              "raw": 1.00597,
              "fmt": "100.60%"
            },
            "earningsEstimate": {
              "avg": {},
              "low": {},
              "high": {},
              "yearAgoEps": {},
              "numberOfAnalysts": {},
              "growth": {}
            },
            "revenueEstimate": {
              "avg": {},
              "low": {},
              "high": {},
              "numberOfAnalysts": {},
              "yearAgoRevenue": {},
              "growth": {}
            },
            "epsTrend": {
              "current": {},
              "7daysAgo": {},
              "30daysAgo": {},
              "60daysAgo": {},
              "90daysAgo": {}
            },
            "epsRevisions": {
              "upLast7days": {},
              "upLast30days": {},
              "downLast30days": {},
              "downLast90days": {}
            }
          }
        ],
        "maxAge": 1
      },
      "quoteType": {
        "exchange": "NMS",
        "shortName": "Amazon.com, Inc.",
        "longName": "Amazon.com, Inc.",
        "exchangeTimezoneName": "America/New_York",
        "exchangeTimezoneShortName": "EDT",
        "isEsgPopulated": false,
        "gmtOffSetMilliseconds": "-14400000",
        "quoteType": "EQUITY",
        "symbol": "AMZN",
        "messageBoardId": "finmb_18749",
        "market": "us_market"
      },
      "sectorTrend": {
        "maxAge": 1,
        "symbol": null,
        "peRatio": {},
        "pegRatio": {},
        "estimates": []
      },
      "summaryDetail": {
        "previousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "twoHundredDayAverage": {
          "raw": 2856.3691,
          "fmt": "2,856.37"
        },
        "trailingAnnualDividendYield": {},
        "payoutRatio": {
          "raw": 0,
          "fmt": "0.00%"
        },
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "navPrice": {},
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "totalAssets": {},
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "fiftyDayAverage": {
          "raw": 3190.4482,
          "fmt": "3,190.45"
        },
        "trailingAnnualDividendRate": {},
        "open": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "toCurrency": null,
        "averageVolume10days": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "expireDate": {},
        "yield": {},
        "algorithm": null,
        "dividendRate": {},
        "exDividendDate": {},
        "beta": {
          "raw": 1.353006,
          "fmt": "1.35"
        },
        "circulatingSupply": {},
        "startDate": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "trailingPE": {
          "raw": 120.94999,
          "fmt": "120.95"
        },
        "regularMarketVolume": {
          "raw": 2288802,
          "fmt": "2.29M",
          "longFmt": "2,288,802"
        },
        "lastMarket": null,
        "maxSupply": {},
        "openInterest": {},
        "marketCap": {
          "raw": 1577390178304,
          "fmt": "1.58T",
          "longFmt": "1,577,390,178,304"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "averageVolume": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "priceToSalesTrailing12Months": {
          "raw": 4.902046,
          "fmt": "4.90"
        },
        "dayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "ask": {
          "raw": 3138,
          "fmt": "3,138.00"
        },
        "ytdReturn": {},
        "askSize": {
          "raw": 3000,
          "fmt": "3k",
          "longFmt": "3,000"
        },
        "volume": {
          "raw": 2288802,
          "fmt": "2.29M",
          "longFmt": "2,288,802"
        },
        "fiftyTwoWeekHigh": {
          "raw": 3552.25,
          "fmt": "3,552.25"
        },
        "forwardPE": {
          "raw": 70.97533,
          "fmt": "70.98"
        },
        "maxAge": 1,
        "fromCurrency": null,
        "fiveYearAvgDividendYield": {},
        "fiftyTwoWeekLow": {
          "raw": 1626.03,
          "fmt": "1,626.03"
        },
        "bid": {
          "raw": 3135.67,
          "fmt": "3,135.67"
        },
        "tradeable": false,
        "dividendYield": {},
        "bidSize": {
          "raw": 1100,
          "fmt": "1.1k",
          "longFmt": "1,100"
        },
        "dayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        }
      },
      "symbol": "AMZN",
      "upgradeDowngradeHistory": {
        "history": [
          {
            "epochGradeDate": 1602850533,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602761580,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602259918,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1602068039,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1601557302,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1600771861,
            "firm": "Bernstein",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1596202990,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596199722,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596195986,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596195716,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596193180,
            "firm": "Needham",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596184984,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1596127912,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595859868,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595594151,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595580207,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1595248547,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1594637221,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1594124960,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593523799,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593178057,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1593177953,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591622085,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591621294,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1591013273,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588352186,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588348269,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344669,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344475,
            "firm": "Guggenheim",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344239,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588344081,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588338598,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588338165,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588334977,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "reit"
          },
          {
            "epochGradeDate": 1588334844,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588333861,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588333153,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588332475,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330464,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330355,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588330243,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588327554,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1588253465,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587999963,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587992689,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587990385,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587746820,
            "firm": "Stifel",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587646973,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1587568433,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1586965916,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1585225808,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1584458683,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1581608820,
            "firm": "Aegis Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580905628,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580491830,
            "firm": "CFRA",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580487947,
            "firm": "B of A Securities",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580485543,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580484494,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580483930,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "reit"
          },
          {
            "epochGradeDate": 1580479677,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580476098,
            "firm": "Piper Sandler",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580476024,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475870,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475709,
            "firm": "Stifel",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475630,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580475135,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580474740,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472258,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472207,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580472088,
            "firm": "Wells Fargo",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580467903,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580305170,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580305088,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1580128735,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579707810,
            "firm": "Pivotal Research",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579265841,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1579183053,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572012335,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572010119,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572009847,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572009518,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572007464,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572007105,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572005722,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003330,
            "firm": "Piper Jaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003267,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003183,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1572003125,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1571660240,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1569241247,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1567509298,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564148885,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564146031,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564145147,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564142904,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1564139707,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563968948,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563789703,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1563194075,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1556286403,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556286191,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1556285826,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556285551,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556284381,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556284089,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283804,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283429,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1556283090,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1552645126,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "Sector Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1549026083,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1549025018,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1548247951,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540568165,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540563922,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1540562392,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1540300461,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1538046902,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1537880370,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1536581666,
            "firm": "Wells Fargo",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1536577864,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1536151685,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1535541478,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532705774,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532705036,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1532704752,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1532703191,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532702595,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532699185,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1532698825,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532692331,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1532691504,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1531745433,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1531499749,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1531489660,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1528978353,
            "firm": "DA Davidson",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1528121868,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "reit"
          },
          {
            "epochGradeDate": 1525528836,
            "firm": "B. Riley FBR",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1525527134,
            "firm": "Argus",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1524840711,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524835866,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1524834218,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524831340,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524830993,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1524829204,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1524227202,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1524138688,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1519228980,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517835243,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517587947,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1517586641,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "Market Outperform",
            "action": "main"
          },
          {
            "epochGradeDate": 1517584163,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1517582814,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1517580664,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1517579506,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1516995809,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Overweight",
            "action": "main"
          },
          {
            "epochGradeDate": 1516711103,
            "firm": "Loop Capital",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1515160436,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "main"
          },
          {
            "epochGradeDate": 1511183102,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509385040,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509132041,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509127449,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509126585,
            "firm": "Loop Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509122381,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509119232,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509107954,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509106277,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1509103387,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1508846359,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1507732645,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1500577730,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1500384110,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1493383553,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "Buy",
            "action": "reit"
          },
          {
            "epochGradeDate": 1493382113,
            "firm": "Pacific Crest",
            "toGrade": "Sector Weight",
            "fromGrade": "Overweight",
            "action": "down"
          },
          {
            "epochGradeDate": 1493128067,
            "firm": "Raymond James",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1493034709,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1492703695,
            "firm": "Wolfe Research",
            "toGrade": "Peer Perform",
            "fromGrade": "Outperform",
            "action": "down"
          },
          {
            "epochGradeDate": 1491834059,
            "firm": "Needham",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1491315938,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1480354388,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1480335180,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1477994732,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1477294704,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1476692067,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475679074,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475679061,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475231868,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1475219367,
            "firm": "Guggenheim",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1475143214,
            "firm": "Maxim Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1474960027,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1470143957,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469799730,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469797781,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469797118,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469788989,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469778745,
            "firm": "CLSA",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469776676,
            "firm": "Pacific Crest",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469776606,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469775942,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469774582,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469427403,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1469081816,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1466656112,
            "firm": "Maxim Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1466063607,
            "firm": "KeyBanc",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1465539261,
            "firm": "William Blair",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1462272184,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461904487,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461904263,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461903707,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1461903236,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1460030851,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1459492695,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1459239653,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1458624080,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Strong Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1456900614,
            "firm": "BMO Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1456731325,
            "firm": "Bernstein",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1455769312,
            "firm": "Canaccord Genuity",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1454054828,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1453203226,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1452841437,
            "firm": "Susquehanna",
            "toGrade": "Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1452572776,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1451893713,
            "firm": "Monness Crespi Hardt",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1450774272,
            "firm": "Macquarie",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1450162559,
            "firm": "MKM Partners",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1449648213,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1449559447,
            "firm": "Pacific Crest",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1448942499,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445930684,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445604845,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445596322,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445585575,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445582670,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445580512,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579475,
            "firm": "JMP Securities",
            "toGrade": "Market Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579277,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445579164,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445578828,
            "firm": "Baird",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1445578813,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1441952731,
            "firm": "RBC Capital",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1440658736,
            "firm": "Raymond James",
            "toGrade": "Strong Buy",
            "fromGrade": "Outperform",
            "action": "up"
          },
          {
            "epochGradeDate": 1440570551,
            "firm": "Evercore ISI Group",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1438152957,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1437735600,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437725582,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437720750,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437712416,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437710308,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437710143,
            "firm": "Barclays",
            "toGrade": "Overweight",
            "fromGrade": "Equal-Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1437549413,
            "firm": "JMP Securities",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1437375485,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1437375308,
            "firm": "Wedbush",
            "toGrade": "Outperform",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1437375135,
            "firm": "Cowen & Co.",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1436946437,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1436851298,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1435298143,
            "firm": "Mizuho",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1435210363,
            "firm": "Evercore ISI Group",
            "toGrade": "",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1434354039,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1433305233,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1430730000,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1429866000,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1429860251,
            "firm": "Janney Capital",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429856558,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1429856435,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429689230,
            "firm": "Monness Crespi Hardt",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1429610895,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1429002000,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1425979742,
            "firm": "Wolfe Research",
            "toGrade": "Outperform",
            "fromGrade": "Peer Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1425888988,
            "firm": "Axiom Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1425882793,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1425449151,
            "firm": "Baird",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1424327255,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422608400,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422349200,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1422003020,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1421855313,
            "firm": "BGC Financial",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1421107200,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1417155008,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1416528000,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414569337,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414398600,
            "firm": "Monness, Crespi, Hardt",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1414141200,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1414139400,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1413216000,
            "firm": "Wolfe Research",
            "toGrade": "",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1413189000,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1412931600,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406323278,
            "firm": "CRT Capital",
            "toGrade": "Fair Value",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406321095,
            "firm": "Citigroup",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406321093,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406273324,
            "firm": "Raymond James",
            "toGrade": "Market Perform",
            "fromGrade": "Outperform",
            "action": "down"
          },
          {
            "epochGradeDate": 1406254590,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406252455,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406248769,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406247747,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1406010002,
            "firm": "Citigroup",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1403764014,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1398873600,
            "firm": "Edward Jones",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1398467992,
            "firm": "Cantor Fitzgerald",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398412800,
            "firm": "Raymond James",
            "toGrade": "Outperform",
            "fromGrade": "Strong Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1398409757,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398395478,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398393545,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398391606,
            "firm": "JP Morgan",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1398386062,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1397635497,
            "firm": "Argus Capital",
            "toGrade": "Buy",
            "fromGrade": "Hold",
            "action": "up"
          },
          {
            "epochGradeDate": 1392220800,
            "firm": "UBS",
            "toGrade": "Neutral",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1391169372,
            "firm": "FBN Securities",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391155200,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391153689,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1391150848,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1390838400,
            "firm": "Pacific Crest",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1389686709,
            "firm": "FBN Securities",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1389342600,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388990834,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388764800,
            "firm": "Topeka",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1388505600,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1387262989,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1384417940,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382968950,
            "firm": "Standpoint",
            "toGrade": "Sell",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1382945547,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382687911,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382685973,
            "firm": "Raymond James",
            "toGrade": "Strong Buy",
            "fromGrade": "Market Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1382438725,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1382080642,
            "firm": "UBS",
            "toGrade": "Buy",
            "fromGrade": "Neutral",
            "action": "up"
          },
          {
            "epochGradeDate": 1379574000,
            "firm": "CRT Capital",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1378882402,
            "firm": "Wedbush",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1374829535,
            "firm": "BMO Capital",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1374824865,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1373961231,
            "firm": "SunTrust Robinson Humphrey",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1373472676,
            "firm": "Susquehanna",
            "toGrade": "Positive",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1373390911,
            "firm": "Citigroup",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1368691091,
            "firm": "Lazard",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1367487786,
            "firm": "Tigress Financial",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1366963317,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1366618113,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1366185916,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1363680464,
            "firm": "JMP Securities",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1363242452,
            "firm": "PiperJaffray",
            "toGrade": "Neutral",
            "fromGrade": "Overweight",
            "action": "down"
          },
          {
            "epochGradeDate": 1361347547,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359552425,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359540668,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359540255,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359533243,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359531886,
            "firm": "Credit Agricole",
            "toGrade": "Outperform",
            "fromGrade": "Buy",
            "action": "down"
          },
          {
            "epochGradeDate": 1359531597,
            "firm": "Nomura",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359531237,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359530684,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359389631,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359366009,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359364847,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359109097,
            "firm": "ISI Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1359101356,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1359043430,
            "firm": "ISI Group",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1358496653,
            "firm": "Pacific Crest",
            "toGrade": "Outperform",
            "fromGrade": "Sector Perform",
            "action": "up"
          },
          {
            "epochGradeDate": 1357713892,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1357540365,
            "firm": "Morgan Stanley",
            "toGrade": "Overweight",
            "fromGrade": "Equal-Weight",
            "action": "up"
          },
          {
            "epochGradeDate": 1351170540,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1348208580,
            "firm": "Cantor Fitzgerald",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1347365820,
            "firm": "Barclays",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1347000720,
            "firm": "Bank of America",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1346395500,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1343378100,
            "firm": "Oppenheimer",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1343372400,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1342506540,
            "firm": "Lazard",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1341991740,
            "firm": "BMO Capital",
            "toGrade": "Market Perform",
            "fromGrade": "",
            "action": "init"
          },
          {
            "epochGradeDate": 1338965820,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1337061720,
            "firm": "Credit Suisse",
            "toGrade": "Outperform",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335526620,
            "firm": "Jefferies",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335522540,
            "firm": "BGC Financial",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335517380,
            "firm": "Goldman Sachs",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1335516060,
            "firm": "Stifel Nicolaus",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335515880,
            "firm": "JP Morgan",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335514680,
            "firm": "Deutsche Bank",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335514140,
            "firm": "Canaccord Genuity",
            "toGrade": "Hold",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335511200,
            "firm": "Benchmark",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1335507660,
            "firm": "Bank oferica",
            "toGrade": "Buy",
            "fromGrade": "",
            "action": "up"
          },
          {
            "epochGradeDate": 1333346760,
            "firm": "Bank oferica",
            "toGrade": "Neutral",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1329373020,
            "firm": "Morgan Stanley",
            "toGrade": "Equal-Weight",
            "fromGrade": "",
            "action": "down"
          },
          {
            "epochGradeDate": 1329291180,
            "firm": "PiperJaffray",
            "toGrade": "Overweight",
            "fromGrade": "",
            "action": "main"
          },
          {
            "epochGradeDate": 1325162820,
            "firm": "PiperJaffray",
            "toGrade": "",
            "fromGrade": "",
            "action": "main"
          }
        ],
        "maxAge": 86400
      },
      "pageViews": {
        "shortTermTrend": "UP",
        "midTermTrend": "UP",
        "longTermTrend": "UP",
        "maxAge": 1
      },
      "industryTrend": {
        "maxAge": 1,
        "symbol": null,
        "peRatio": {},
        "pegRatio": {},
        "estimates": []
      }
    }
```

</details>

### get-financials Query

```python
import requests

url = "https://rapidapi.p.rapidapi.com/stock/v2/get-financials"

querystring = {"symbol":"AMZN","region":"US"}

headers = {
    'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
    'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
    }

response = requests.request("GET", url, headers=headers, params=querystring)

print(response.text)
```

<details>
  <summary>Here's the response of the above request:</summary>

```json
    {
      "financialsTemplate": {
        "code": "N",
        "maxAge": 1
      },
      "cashflowStatementHistory": {
        "cashflowStatements": [
          {
            "investments": {
              "raw": -9131000000,
              "fmt": "-9.13B",
              "longFmt": "-9,131,000,000"
            },
            "changeToLiabilities": {
              "raw": 9904000000,
              "fmt": "9.9B",
              "longFmt": "9,904,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -24281000000,
              "fmt": "-24.28B",
              "longFmt": "-24,281,000,000"
            },
            "netBorrowings": {
              "raw": -10066000000,
              "fmt": "-10.07B",
              "longFmt": "-10,066,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -10066000000,
              "fmt": "-10.07B",
              "longFmt": "-10,066,000,000"
            },
            "changeToOperatingActivities": {
              "raw": -1383000000,
              "fmt": "-1.38B",
              "longFmt": "-1,383,000,000"
            },
            "netIncome": {
              "raw": 11588000000,
              "fmt": "11.59B",
              "longFmt": "11,588,000,000"
            },
            "changeInCash": {
              "raw": 4237000000,
              "fmt": "4.24B",
              "longFmt": "4,237,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "effectOfExchangeRate": {
              "raw": 70000000,
              "fmt": "70M",
              "longFmt": "70,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 38514000000,
              "fmt": "38.51B",
              "longFmt": "38,514,000,000"
            },
            "depreciation": {
              "raw": 21789000000,
              "fmt": "21.79B",
              "longFmt": "21,789,000,000"
            },
            "changeToInventory": {
              "raw": -3278000000,
              "fmt": "-3.28B",
              "longFmt": "-3,278,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -7681000000,
              "fmt": "-7.68B",
              "longFmt": "-7,681,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 7575000000,
              "fmt": "7.58B",
              "longFmt": "7,575,000,000"
            },
            "capitalExpenditures": {
              "raw": -16861000000,
              "fmt": "-16.86B",
              "longFmt": "-16,861,000,000"
            }
          },
          {
            "investments": {
              "raw": 1140000000,
              "fmt": "1.14B",
              "longFmt": "1,140,000,000"
            },
            "changeToLiabilities": {
              "raw": 4414000000,
              "fmt": "4.41B",
              "longFmt": "4,414,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -12369000000,
              "fmt": "-12.37B",
              "longFmt": "-12,369,000,000"
            },
            "netBorrowings": {
              "raw": -7686000000,
              "fmt": "-7.69B",
              "longFmt": "-7,686,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -7686000000,
              "fmt": "-7.69B",
              "longFmt": "-7,686,000,000"
            },
            "changeToOperatingActivities": {
              "raw": 472000000,
              "fmt": "472M",
              "longFmt": "472,000,000"
            },
            "netIncome": {
              "raw": 10073000000,
              "fmt": "10.07B",
              "longFmt": "10,073,000,000"
            },
            "changeInCash": {
              "raw": 10317000000,
              "fmt": "10.32B",
              "longFmt": "10,317,000,000"
            },
            "endDate": {
              "raw": 1546214400,
              "fmt": "2018-12-31"
            },
            "effectOfExchangeRate": {
              "raw": -351000000,
              "fmt": "-351M",
              "longFmt": "-351,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 30723000000,
              "fmt": "30.72B",
              "longFmt": "30,723,000,000"
            },
            "depreciation": {
              "raw": 15341000000,
              "fmt": "15.34B",
              "longFmt": "15,341,000,000"
            },
            "otherCashflowsFromInvestingActivities": {
              "raw": 2104000000,
              "fmt": "2.1B",
              "longFmt": "2,104,000,000"
            },
            "changeToInventory": {
              "raw": -1314000000,
              "fmt": "-1.31B",
              "longFmt": "-1,314,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -4615000000,
              "fmt": "-4.62B",
              "longFmt": "-4,615,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 6352000000,
              "fmt": "6.35B",
              "longFmt": "6,352,000,000"
            },
            "capitalExpenditures": {
              "raw": -13427000000,
              "fmt": "-13.43B",
              "longFmt": "-13,427,000,000"
            }
          },
          {
            "investments": {
              "raw": -3054000000,
              "fmt": "-3.05B",
              "longFmt": "-3,054,000,000"
            },
            "changeToLiabilities": {
              "raw": 7838000000,
              "fmt": "7.84B",
              "longFmt": "7,838,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -27084000000,
              "fmt": "-27.08B",
              "longFmt": "-27,084,000,000"
            },
            "netBorrowings": {
              "raw": 9928000000,
              "fmt": "9.93B",
              "longFmt": "9,928,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": 9928000000,
              "fmt": "9.93B",
              "longFmt": "9,928,000,000"
            },
            "changeToOperatingActivities": {
              "raw": 283000000,
              "fmt": "283M",
              "longFmt": "283,000,000"
            },
            "netIncome": {
              "raw": 3033000000,
              "fmt": "3.03B",
              "longFmt": "3,033,000,000"
            },
            "changeInCash": {
              "raw": 1922000000,
              "fmt": "1.92B",
              "longFmt": "1,922,000,000"
            },
            "endDate": {
              "raw": 1514678400,
              "fmt": "2017-12-31"
            },
            "effectOfExchangeRate": {
              "raw": 713000000,
              "fmt": "713M",
              "longFmt": "713,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 18365000000,
              "fmt": "18.36B",
              "longFmt": "18,365,000,000"
            },
            "depreciation": {
              "raw": 11478000000,
              "fmt": "11.48B",
              "longFmt": "11,478,000,000"
            },
            "otherCashflowsFromInvestingActivities": {
              "raw": 1897000000,
              "fmt": "1.9B",
              "longFmt": "1,897,000,000"
            },
            "changeToInventory": {
              "raw": -3583000000,
              "fmt": "-3.58B",
              "longFmt": "-3,583,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -4780000000,
              "fmt": "-4.78B",
              "longFmt": "-4,780,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 4096000000,
              "fmt": "4.1B",
              "longFmt": "4,096,000,000"
            },
            "capitalExpenditures": {
              "raw": -11955000000,
              "fmt": "-11.96B",
              "longFmt": "-11,955,000,000"
            }
          },
          {
            "investments": {
              "raw": -2663000000,
              "fmt": "-2.66B",
              "longFmt": "-2,663,000,000"
            },
            "changeToLiabilities": {
              "raw": 6985000000,
              "fmt": "6.99B",
              "longFmt": "6,985,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -9516000000,
              "fmt": "-9.52B",
              "longFmt": "-9,516,000,000"
            },
            "netBorrowings": {
              "raw": -3716000000,
              "fmt": "-3.72B",
              "longFmt": "-3,716,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -3716000000,
              "fmt": "-3.72B",
              "longFmt": "-3,716,000,000"
            },
            "changeToOperatingActivities": {
              "raw": 1724000000,
              "fmt": "1.72B",
              "longFmt": "1,724,000,000"
            },
            "netIncome": {
              "raw": 2371000000,
              "fmt": "2.37B",
              "longFmt": "2,371,000,000"
            },
            "changeInCash": {
              "raw": 3759000000,
              "fmt": "3.76B",
              "longFmt": "3,759,000,000"
            },
            "endDate": {
              "raw": 1483142400,
              "fmt": "2016-12-31"
            },
            "effectOfExchangeRate": {
              "raw": -212000000,
              "fmt": "-212M",
              "longFmt": "-212,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 17203000000,
              "fmt": "17.2B",
              "longFmt": "17,203,000,000"
            },
            "depreciation": {
              "raw": 8116000000,
              "fmt": "8.12B",
              "longFmt": "8,116,000,000"
            },
            "otherCashflowsFromInvestingActivities": {
              "raw": 1067000000,
              "fmt": "1.07B",
              "longFmt": "1,067,000,000"
            },
            "changeToInventory": {
              "raw": -1426000000,
              "fmt": "-1.43B",
              "longFmt": "-1,426,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -3436000000,
              "fmt": "-3.44B",
              "longFmt": "-3,436,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 2869000000,
              "fmt": "2.87B",
              "longFmt": "2,869,000,000"
            },
            "capitalExpenditures": {
              "raw": -7804000000,
              "fmt": "-7.8B",
              "longFmt": "-7,804,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "balanceSheetHistoryQuarterly": {
        "balanceSheetStatements": [
          {
            "capitalSurplus": {
              "raw": 38017000000,
              "fmt": "38.02B",
              "longFmt": "38,017,000,000"
            },
            "totalLiab": {
              "raw": 184586000000,
              "fmt": "184.59B",
              "longFmt": "184,586,000,000"
            },
            "totalStockholderEquity": {
              "raw": 73728000000,
              "fmt": "73.73B",
              "longFmt": "73,728,000,000"
            },
            "otherCurrentLiab": {
              "raw": 8997000000,
              "fmt": "9B",
              "longFmt": "8,997,000,000"
            },
            "totalAssets": {
              "raw": 258314000000,
              "fmt": "258.31B",
              "longFmt": "258,314,000,000"
            },
            "endDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 354000000,
              "fmt": "354M",
              "longFmt": "354,000,000"
            },
            "retainedEarnings": {
              "raw": 38998000000,
              "fmt": "39B",
              "longFmt": "38,998,000,000"
            },
            "otherLiab": {
              "raw": 14764000000,
              "fmt": "14.76B",
              "longFmt": "14,764,000,000"
            },
            "goodWill": {
              "raw": 14751000000,
              "fmt": "14.75B",
              "longFmt": "14,751,000,000"
            },
            "treasuryStock": {
              "raw": -3292000000,
              "fmt": "-3.29B",
              "longFmt": "-3,292,000,000"
            },
            "otherAssets": {
              "raw": 15101000000,
              "fmt": "15.1B",
              "longFmt": "15,101,000,000"
            },
            "cash": {
              "raw": 37466000000,
              "fmt": "37.47B",
              "longFmt": "37,466,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 93896000000,
              "fmt": "93.9B",
              "longFmt": "93,896,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1154000000,
              "fmt": "1.15B",
              "longFmt": "1,154,000,000"
            },
            "otherStockholderEquity": {
              "raw": -1455000000,
              "fmt": "-1.46B",
              "longFmt": "-1,455,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 115054000000,
              "fmt": "115.05B",
              "longFmt": "115,054,000,000"
            },
            "totalCurrentAssets": {
              "raw": 110908000000,
              "fmt": "110.91B",
              "longFmt": "110,908,000,000"
            },
            "longTermInvestments": {
              "raw": 2500000000,
              "fmt": "2.5B",
              "longFmt": "2,500,000,000"
            },
            "netTangibleAssets": {
              "raw": 58977000000,
              "fmt": "58.98B",
              "longFmt": "58,977,000,000"
            },
            "shortTermInvestments": {
              "raw": 33925000000,
              "fmt": "33.92B",
              "longFmt": "33,925,000,000"
            },
            "netReceivables": {
              "raw": 19564000000,
              "fmt": "19.56B",
              "longFmt": "19,564,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 33128000000,
              "fmt": "33.13B",
              "longFmt": "33,128,000,000"
            },
            "inventory": {
              "raw": 19599000000,
              "fmt": "19.6B",
              "longFmt": "19,599,000,000"
            },
            "accountsPayable": {
              "raw": 51036000000,
              "fmt": "51.04B",
              "longFmt": "51,036,000,000"
            }
          },
          {
            "capitalSurplus": {
              "raw": 35412000000,
              "fmt": "35.41B",
              "longFmt": "35,412,000,000"
            },
            "totalLiab": {
              "raw": 155966000000,
              "fmt": "155.97B",
              "longFmt": "155,966,000,000"
            },
            "totalStockholderEquity": {
              "raw": 65272000000,
              "fmt": "65.27B",
              "longFmt": "65,272,000,000"
            },
            "otherCurrentLiab": {
              "raw": 8864000000,
              "fmt": "8.86B",
              "longFmt": "8,864,000,000"
            },
            "totalAssets": {
              "raw": 221238000000,
              "fmt": "221.24B",
              "longFmt": "221,238,000,000"
            },
            "endDate": {
              "raw": 1585612800,
              "fmt": "2020-03-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 282000000,
              "fmt": "282M",
              "longFmt": "282,000,000"
            },
            "retainedEarnings": {
              "raw": 33755000000,
              "fmt": "33.76B",
              "longFmt": "33,755,000,000"
            },
            "otherLiab": {
              "raw": 12518000000,
              "fmt": "12.52B",
              "longFmt": "12,518,000,000"
            },
            "goodWill": {
              "raw": 14739000000,
              "fmt": "14.74B",
              "longFmt": "14,739,000,000"
            },
            "treasuryStock": {
              "raw": -3900000000,
              "fmt": "-3.9B",
              "longFmt": "-3,900,000,000"
            },
            "otherAssets": {
              "raw": 16456000000,
              "fmt": "16.46B",
              "longFmt": "16,456,000,000"
            },
            "cash": {
              "raw": 27201000000,
              "fmt": "27.2B",
              "longFmt": "27,201,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 79711000000,
              "fmt": "79.71B",
              "longFmt": "79,711,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1311000000,
              "fmt": "1.31B",
              "longFmt": "1,311,000,000"
            },
            "otherStockholderEquity": {
              "raw": -2063000000,
              "fmt": "-2.06B",
              "longFmt": "-2,063,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 104058000000,
              "fmt": "104.06B",
              "longFmt": "104,058,000,000"
            },
            "totalCurrentAssets": {
              "raw": 85985000000,
              "fmt": "85.98B",
              "longFmt": "85,985,000,000"
            },
            "longTermInvestments": {
              "raw": 2028000000,
              "fmt": "2.03B",
              "longFmt": "2,028,000,000"
            },
            "netTangibleAssets": {
              "raw": 50533000000,
              "fmt": "50.53B",
              "longFmt": "50,533,000,000"
            },
            "shortTermInvestments": {
              "raw": 22091000000,
              "fmt": "22.09B",
              "longFmt": "22,091,000,000"
            },
            "netReceivables": {
              "raw": 17836000000,
              "fmt": "17.84B",
              "longFmt": "17,836,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 23437000000,
              "fmt": "23.44B",
              "longFmt": "23,437,000,000"
            },
            "inventory": {
              "raw": 18857000000,
              "fmt": "18.86B",
              "longFmt": "18,857,000,000"
            },
            "accountsPayable": {
              "raw": 40056000000,
              "fmt": "40.06B",
              "longFmt": "40,056,000,000"
            }
          },
          {
            "intangibleAssets": {
              "raw": 4049000000,
              "fmt": "4.05B",
              "longFmt": "4,049,000,000"
            },
            "capitalSurplus": {
              "raw": 33658000000,
              "fmt": "33.66B",
              "longFmt": "33,658,000,000"
            },
            "totalLiab": {
              "raw": 163188000000,
              "fmt": "163.19B",
              "longFmt": "163,188,000,000"
            },
            "totalStockholderEquity": {
              "raw": 62060000000,
              "fmt": "62.06B",
              "longFmt": "62,060,000,000"
            },
            "otherCurrentLiab": {
              "raw": 12202000000,
              "fmt": "12.2B",
              "longFmt": "12,202,000,000"
            },
            "totalAssets": {
              "raw": 225248000000,
              "fmt": "225.25B",
              "longFmt": "225,248,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 276000000,
              "fmt": "276M",
              "longFmt": "276,000,000"
            },
            "retainedEarnings": {
              "raw": 31220000000,
              "fmt": "31.22B",
              "longFmt": "31,220,000,000"
            },
            "otherLiab": {
              "raw": 12171000000,
              "fmt": "12.17B",
              "longFmt": "12,171,000,000"
            },
            "goodWill": {
              "raw": 14754000000,
              "fmt": "14.75B",
              "longFmt": "14,754,000,000"
            },
            "treasuryStock": {
              "raw": -2823000000,
              "fmt": "-2.82B",
              "longFmt": "-2,823,000,000"
            },
            "otherAssets": {
              "raw": 10096000000,
              "fmt": "10.1B",
              "longFmt": "10,096,000,000"
            },
            "cash": {
              "raw": 36092000000,
              "fmt": "36.09B",
              "longFmt": "36,092,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 87812000000,
              "fmt": "87.81B",
              "longFmt": "87,812,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1307000000,
              "fmt": "1.31B",
              "longFmt": "1,307,000,000"
            },
            "otherStockholderEquity": {
              "raw": -986000000,
              "fmt": "-986M",
              "longFmt": "-986,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 97846000000,
              "fmt": "97.85B",
              "longFmt": "97,846,000,000"
            },
            "totalCurrentAssets": {
              "raw": 96334000000,
              "fmt": "96.33B",
              "longFmt": "96,334,000,000"
            },
            "longTermInvestments": {
              "raw": 2169000000,
              "fmt": "2.17B",
              "longFmt": "2,169,000,000"
            },
            "netTangibleAssets": {
              "raw": 43257000000,
              "fmt": "43.26B",
              "longFmt": "43,257,000,000"
            },
            "shortTermInvestments": {
              "raw": 18929000000,
              "fmt": "18.93B",
              "longFmt": "18,929,000,000"
            },
            "netReceivables": {
              "raw": 20540000000,
              "fmt": "20.54B",
              "longFmt": "20,540,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 23414000000,
              "fmt": "23.41B",
              "longFmt": "23,414,000,000"
            },
            "inventory": {
              "raw": 20497000000,
              "fmt": "20.5B",
              "longFmt": "20,497,000,000"
            },
            "accountsPayable": {
              "raw": 47183000000,
              "fmt": "47.18B",
              "longFmt": "47,183,000,000"
            }
          },
          {
            "capitalSurplus": {
              "raw": 31817000000,
              "fmt": "31.82B",
              "longFmt": "31,817,000,000"
            },
            "totalLiab": {
              "raw": 142591000000,
              "fmt": "142.59B",
              "longFmt": "142,591,000,000"
            },
            "totalStockholderEquity": {
              "raw": 56508000000,
              "fmt": "56.51B",
              "longFmt": "56,508,000,000"
            },
            "otherCurrentLiab": {
              "raw": 7381000000,
              "fmt": "7.38B",
              "longFmt": "7,381,000,000"
            },
            "totalAssets": {
              "raw": 199099000000,
              "fmt": "199.1B",
              "longFmt": "199,099,000,000"
            },
            "endDate": {
              "raw": 1569801600,
              "fmt": "2019-09-30"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 257000000,
              "fmt": "257M",
              "longFmt": "257,000,000"
            },
            "retainedEarnings": {
              "raw": 27952000000,
              "fmt": "27.95B",
              "longFmt": "27,952,000,000"
            },
            "otherLiab": {
              "raw": 10925000000,
              "fmt": "10.93B",
              "longFmt": "10,925,000,000"
            },
            "goodWill": {
              "raw": 14734000000,
              "fmt": "14.73B",
              "longFmt": "14,734,000,000"
            },
            "treasuryStock": {
              "raw": -3266000000,
              "fmt": "-3.27B",
              "longFmt": "-3,266,000,000"
            },
            "otherAssets": {
              "raw": 13115000000,
              "fmt": "13.12B",
              "longFmt": "13,115,000,000"
            },
            "cash": {
              "raw": 23255000000,
              "fmt": "23.25B",
              "longFmt": "23,255,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 72136000000,
              "fmt": "72.14B",
              "longFmt": "72,136,000,000"
            },
            "shortLongTermDebt": {
              "raw": 2841000000,
              "fmt": "2.84B",
              "longFmt": "2,841,000,000"
            },
            "otherStockholderEquity": {
              "raw": -1429000000,
              "fmt": "-1.43B",
              "longFmt": "-1,429,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 90776000000,
              "fmt": "90.78B",
              "longFmt": "90,776,000,000"
            },
            "totalCurrentAssets": {
              "raw": 79054000000,
              "fmt": "79.05B",
              "longFmt": "79,054,000,000"
            },
            "longTermInvestments": {
              "raw": 1420000000,
              "fmt": "1.42B",
              "longFmt": "1,420,000,000"
            },
            "netTangibleAssets": {
              "raw": 41774000000,
              "fmt": "41.77B",
              "longFmt": "41,774,000,000"
            },
            "shortTermInvestments": {
              "raw": 20146000000,
              "fmt": "20.15B",
              "longFmt": "20,146,000,000"
            },
            "netReceivables": {
              "raw": 16630000000,
              "fmt": "16.63B",
              "longFmt": "16,630,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 22472000000,
              "fmt": "22.47B",
              "longFmt": "22,472,000,000"
            },
            "inventory": {
              "raw": 18766000000,
              "fmt": "18.77B",
              "longFmt": "18,766,000,000"
            },
            "accountsPayable": {
              "raw": 35794000000,
              "fmt": "35.79B",
              "longFmt": "35,794,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "earnings": {
        "maxAge": 86400,
        "earningsChart": {
          "quarterly": [
            {
              "date": "3Q2019",
              "actual": {
                "raw": 4.23,
                "fmt": "4.23"
              },
              "estimate": {
                "raw": 4.62,
                "fmt": "4.62"
              }
            },
            {
              "date": "4Q2019",
              "actual": {
                "raw": 6.47,
                "fmt": "6.47"
              },
              "estimate": {
                "raw": 4.03,
                "fmt": "4.03"
              }
            },
            {
              "date": "1Q2020",
              "actual": {
                "raw": 5.01,
                "fmt": "5.01"
              },
              "estimate": {
                "raw": 6.25,
                "fmt": "6.25"
              }
            },
            {
              "date": "2Q2020",
              "actual": {
                "raw": 10.3,
                "fmt": "10.30"
              },
              "estimate": {
                "raw": 1.46,
                "fmt": "1.46"
              }
            }
          ],
          "currentQuarterEstimate": {
            "raw": 7.25,
            "fmt": "7.25"
          },
          "currentQuarterEstimateDate": "3Q",
          "currentQuarterEstimateYear": 2020,
          "earningsDate": [
            {
              "raw": 1603929600,
              "fmt": "2020-10-29"
            }
          ]
        },
        "financialsChart": {
          "yearly": [
            {
              "date": 2016,
              "revenue": {
                "raw": 135987000000,
                "fmt": "135.99B",
                "longFmt": "135,987,000,000"
              },
              "earnings": {
                "raw": 2371000000,
                "fmt": "2.37B",
                "longFmt": "2,371,000,000"
              }
            },
            {
              "date": 2017,
              "revenue": {
                "raw": 177866000000,
                "fmt": "177.87B",
                "longFmt": "177,866,000,000"
              },
              "earnings": {
                "raw": 3033000000,
                "fmt": "3.03B",
                "longFmt": "3,033,000,000"
              }
            },
            {
              "date": 2018,
              "revenue": {
                "raw": 232887000000,
                "fmt": "232.89B",
                "longFmt": "232,887,000,000"
              },
              "earnings": {
                "raw": 10073000000,
                "fmt": "10.07B",
                "longFmt": "10,073,000,000"
              }
            },
            {
              "date": 2019,
              "revenue": {
                "raw": 280522000000,
                "fmt": "280.52B",
                "longFmt": "280,522,000,000"
              },
              "earnings": {
                "raw": 11588000000,
                "fmt": "11.59B",
                "longFmt": "11,588,000,000"
              }
            }
          ],
          "quarterly": [
            {
              "date": "3Q2019",
              "revenue": {
                "raw": 69981000000,
                "fmt": "69.98B",
                "longFmt": "69,981,000,000"
              },
              "earnings": {
                "raw": 2134000000,
                "fmt": "2.13B",
                "longFmt": "2,134,000,000"
              }
            },
            {
              "date": "4Q2019",
              "revenue": {
                "raw": 87436000000,
                "fmt": "87.44B",
                "longFmt": "87,436,000,000"
              },
              "earnings": {
                "raw": 3268000000,
                "fmt": "3.27B",
                "longFmt": "3,268,000,000"
              }
            },
            {
              "date": "1Q2020",
              "revenue": {
                "raw": 75452000000,
                "fmt": "75.45B",
                "longFmt": "75,452,000,000"
              },
              "earnings": {
                "raw": 2535000000,
                "fmt": "2.54B",
                "longFmt": "2,535,000,000"
              }
            },
            {
              "date": "2Q2020",
              "revenue": {
                "raw": 88912000000,
                "fmt": "88.91B",
                "longFmt": "88,912,000,000"
              },
              "earnings": {
                "raw": 5243000000,
                "fmt": "5.24B",
                "longFmt": "5,243,000,000"
              }
            }
          ]
        },
        "financialCurrency": "USD"
      },
      "price": {
        "quoteSourceName": "Nasdaq Real Time Price",
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "averageDailyVolume3Month": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "exchange": "NMS",
        "regularMarketTime": 1603386711,
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "shortName": "Amazon.com, Inc.",
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "longName": "Amazon.com, Inc.",
        "regularMarketChange": {
          "raw": -29.369873,
          "fmt": "-29.37"
        },
        "currencySymbol": "$",
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "preMarketPrice": {
          "raw": 3189.47,
          "fmt": "3,189.47"
        },
        "preMarketTime": 1603373399,
        "exchangeDataDelayedBy": 0,
        "toCurrency": null,
        "postMarketChange": {},
        "postMarketPrice": {},
        "exchangeName": "NasdaqGS",
        "preMarketChange": {
          "raw": 4.53003,
          "fmt": "4.53"
        },
        "circulatingSupply": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "regularMarketPrice": {
          "raw": 3155.57,
          "fmt": "3,155.57"
        },
        "regularMarketVolume": {
          "raw": 2417976,
          "fmt": "2.42M",
          "longFmt": "2,417,976.00"
        },
        "lastMarket": null,
        "regularMarketSource": "FREE_REALTIME",
        "openInterest": {},
        "marketState": "REGULAR",
        "underlyingSymbol": null,
        "marketCap": {
          "raw": 1580593446912,
          "fmt": "1.58T",
          "longFmt": "1,580,593,446,912.00"
        },
        "quoteType": "EQUITY",
        "preMarketChangePercent": {
          "raw": 0.00142233,
          "fmt": "0.14%"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "symbol": "AMZN",
        "preMarketSource": "FREE_REALTIME",
        "maxAge": 1,
        "fromCurrency": null,
        "regularMarketChangePercent": {
          "raw": -0.009221484,
          "fmt": "-0.92%"
        }
      },
      "incomeStatementHistoryQuarterly": {
        "incomeStatementHistory": [
          {
            "researchDevelopment": {
              "raw": 8945000000,
              "fmt": "8.95B",
              "longFmt": "8,945,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 6227000000,
              "fmt": "6.23B",
              "longFmt": "6,227,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 5243000000,
              "fmt": "5.24B",
              "longFmt": "5,243,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 21174000000,
              "fmt": "21.17B",
              "longFmt": "21,174,000,000"
            },
            "grossProfit": {
              "raw": 36252000000,
              "fmt": "36.25B",
              "longFmt": "36,252,000,000"
            },
            "ebit": {
              "raw": 5843000000,
              "fmt": "5.84B",
              "longFmt": "5,843,000,000"
            },
            "endDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "operatingIncome": {
              "raw": 5843000000,
              "fmt": "5.84B",
              "longFmt": "5,843,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 290000000,
              "fmt": "290M",
              "longFmt": "290,000,000"
            },
            "interestExpense": {
              "raw": -403000000,
              "fmt": "-403M",
              "longFmt": "-403,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 984000000,
              "fmt": "984M",
              "longFmt": "984,000,000"
            },
            "totalRevenue": {
              "raw": 88912000000,
              "fmt": "88.91B",
              "longFmt": "88,912,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 83069000000,
              "fmt": "83.07B",
              "longFmt": "83,069,000,000"
            },
            "costOfRevenue": {
              "raw": 52660000000,
              "fmt": "52.66B",
              "longFmt": "52,660,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": 384000000,
              "fmt": "384M",
              "longFmt": "384,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 5243000000,
              "fmt": "5.24B",
              "longFmt": "5,243,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 5243000000,
              "fmt": "5.24B",
              "longFmt": "5,243,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 9325000000,
              "fmt": "9.32B",
              "longFmt": "9,325,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 3279000000,
              "fmt": "3.28B",
              "longFmt": "3,279,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 2535000000,
              "fmt": "2.54B",
              "longFmt": "2,535,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 17811000000,
              "fmt": "17.81B",
              "longFmt": "17,811,000,000"
            },
            "grossProfit": {
              "raw": 31195000000,
              "fmt": "31.2B",
              "longFmt": "31,195,000,000"
            },
            "ebit": {
              "raw": 3989000000,
              "fmt": "3.99B",
              "longFmt": "3,989,000,000"
            },
            "endDate": {
              "raw": 1585612800,
              "fmt": "2020-03-31"
            },
            "operatingIncome": {
              "raw": 3989000000,
              "fmt": "3.99B",
              "longFmt": "3,989,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 70000000,
              "fmt": "70M",
              "longFmt": "70,000,000"
            },
            "interestExpense": {
              "raw": -402000000,
              "fmt": "-402M",
              "longFmt": "-402,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 744000000,
              "fmt": "744M",
              "longFmt": "744,000,000"
            },
            "totalRevenue": {
              "raw": 75452000000,
              "fmt": "75.45B",
              "longFmt": "75,452,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 71463000000,
              "fmt": "71.46B",
              "longFmt": "71,463,000,000"
            },
            "costOfRevenue": {
              "raw": 44257000000,
              "fmt": "44.26B",
              "longFmt": "44,257,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -741000000,
              "fmt": "-741M",
              "longFmt": "-741,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 2535000000,
              "fmt": "2.54B",
              "longFmt": "2,535,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 2535000000,
              "fmt": "2.54B",
              "longFmt": "2,535,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 9740000000,
              "fmt": "9.74B",
              "longFmt": "9,740,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 4054000000,
              "fmt": "4.05B",
              "longFmt": "4,054,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 3268000000,
              "fmt": "3.27B",
              "longFmt": "3,268,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 19775000000,
              "fmt": "19.77B",
              "longFmt": "19,775,000,000"
            },
            "grossProfit": {
              "raw": 33459000000,
              "fmt": "33.46B",
              "longFmt": "33,459,000,000"
            },
            "ebit": {
              "raw": 3879000000,
              "fmt": "3.88B",
              "longFmt": "3,879,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "operatingIncome": {
              "raw": 3879000000,
              "fmt": "3.88B",
              "longFmt": "3,879,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 65000000,
              "fmt": "65M",
              "longFmt": "65,000,000"
            },
            "interestExpense": {
              "raw": -455000000,
              "fmt": "-455M",
              "longFmt": "-455,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 786000000,
              "fmt": "786M",
              "longFmt": "786,000,000"
            },
            "totalRevenue": {
              "raw": 87436000000,
              "fmt": "87.44B",
              "longFmt": "87,436,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 83557000000,
              "fmt": "83.56B",
              "longFmt": "83,557,000,000"
            },
            "costOfRevenue": {
              "raw": 53977000000,
              "fmt": "53.98B",
              "longFmt": "53,977,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": 175000000,
              "fmt": "175M",
              "longFmt": "175,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 3268000000,
              "fmt": "3.27B",
              "longFmt": "3,268,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 3268000000,
              "fmt": "3.27B",
              "longFmt": "3,268,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 9200000000,
              "fmt": "9.2B",
              "longFmt": "9,200,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 2628000000,
              "fmt": "2.63B",
              "longFmt": "2,628,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 2134000000,
              "fmt": "2.13B",
              "longFmt": "2,134,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 16267000000,
              "fmt": "16.27B",
              "longFmt": "16,267,000,000"
            },
            "grossProfit": {
              "raw": 28679000000,
              "fmt": "28.68B",
              "longFmt": "28,679,000,000"
            },
            "ebit": {
              "raw": 3020000000,
              "fmt": "3.02B",
              "longFmt": "3,020,000,000"
            },
            "endDate": {
              "raw": 1569801600,
              "fmt": "2019-09-30"
            },
            "operatingIncome": {
              "raw": 3020000000,
              "fmt": "3.02B",
              "longFmt": "3,020,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 192000000,
              "fmt": "192M",
              "longFmt": "192,000,000"
            },
            "interestExpense": {
              "raw": -396000000,
              "fmt": "-396M",
              "longFmt": "-396,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 494000000,
              "fmt": "494M",
              "longFmt": "494,000,000"
            },
            "totalRevenue": {
              "raw": 69981000000,
              "fmt": "69.98B",
              "longFmt": "69,981,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 66961000000,
              "fmt": "66.96B",
              "longFmt": "66,961,000,000"
            },
            "costOfRevenue": {
              "raw": 41302000000,
              "fmt": "41.3B",
              "longFmt": "41,302,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -392000000,
              "fmt": "-392M",
              "longFmt": "-392,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 2134000000,
              "fmt": "2.13B",
              "longFmt": "2,134,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 2134000000,
              "fmt": "2.13B",
              "longFmt": "2,134,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "incomeStatementHistory": {
        "incomeStatementHistory": [
          {
            "researchDevelopment": {
              "raw": 35931000000,
              "fmt": "35.93B",
              "longFmt": "35,931,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 13962000000,
              "fmt": "13.96B",
              "longFmt": "13,962,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 11588000000,
              "fmt": "11.59B",
              "longFmt": "11,588,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 64313000000,
              "fmt": "64.31B",
              "longFmt": "64,313,000,000"
            },
            "grossProfit": {
              "raw": 114986000000,
              "fmt": "114.99B",
              "longFmt": "114,986,000,000"
            },
            "ebit": {
              "raw": 14404000000,
              "fmt": "14.4B",
              "longFmt": "14,404,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "operatingIncome": {
              "raw": 14404000000,
              "fmt": "14.4B",
              "longFmt": "14,404,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 338000000,
              "fmt": "338M",
              "longFmt": "338,000,000"
            },
            "interestExpense": {
              "raw": -1600000000,
              "fmt": "-1.6B",
              "longFmt": "-1,600,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 2374000000,
              "fmt": "2.37B",
              "longFmt": "2,374,000,000"
            },
            "totalRevenue": {
              "raw": 280522000000,
              "fmt": "280.52B",
              "longFmt": "280,522,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 266118000000,
              "fmt": "266.12B",
              "longFmt": "266,118,000,000"
            },
            "costOfRevenue": {
              "raw": 165536000000,
              "fmt": "165.54B",
              "longFmt": "165,536,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -442000000,
              "fmt": "-442M",
              "longFmt": "-442,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 11588000000,
              "fmt": "11.59B",
              "longFmt": "11,588,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 11588000000,
              "fmt": "11.59B",
              "longFmt": "11,588,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 28837000000,
              "fmt": "28.84B",
              "longFmt": "28,837,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 11270000000,
              "fmt": "11.27B",
              "longFmt": "11,270,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 10073000000,
              "fmt": "10.07B",
              "longFmt": "10,073,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 52177000000,
              "fmt": "52.18B",
              "longFmt": "52,177,000,000"
            },
            "grossProfit": {
              "raw": 93731000000,
              "fmt": "93.73B",
              "longFmt": "93,731,000,000"
            },
            "ebit": {
              "raw": 12421000000,
              "fmt": "12.42B",
              "longFmt": "12,421,000,000"
            },
            "endDate": {
              "raw": 1546214400,
              "fmt": "2018-12-31"
            },
            "operatingIncome": {
              "raw": 12421000000,
              "fmt": "12.42B",
              "longFmt": "12,421,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 296000000,
              "fmt": "296M",
              "longFmt": "296,000,000"
            },
            "interestExpense": {
              "raw": -1417000000,
              "fmt": "-1.42B",
              "longFmt": "-1,417,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 1197000000,
              "fmt": "1.2B",
              "longFmt": "1,197,000,000"
            },
            "totalRevenue": {
              "raw": 232887000000,
              "fmt": "232.89B",
              "longFmt": "232,887,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 220466000000,
              "fmt": "220.47B",
              "longFmt": "220,466,000,000"
            },
            "costOfRevenue": {
              "raw": 139156000000,
              "fmt": "139.16B",
              "longFmt": "139,156,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -1151000000,
              "fmt": "-1.15B",
              "longFmt": "-1,151,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 10073000000,
              "fmt": "10.07B",
              "longFmt": "10,073,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 10073000000,
              "fmt": "10.07B",
              "longFmt": "10,073,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 22620000000,
              "fmt": "22.62B",
              "longFmt": "22,620,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 3802000000,
              "fmt": "3.8B",
              "longFmt": "3,802,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 3033000000,
              "fmt": "3.03B",
              "longFmt": "3,033,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 38992000000,
              "fmt": "38.99B",
              "longFmt": "38,992,000,000"
            },
            "grossProfit": {
              "raw": 65932000000,
              "fmt": "65.93B",
              "longFmt": "65,932,000,000"
            },
            "ebit": {
              "raw": 4106000000,
              "fmt": "4.11B",
              "longFmt": "4,106,000,000"
            },
            "endDate": {
              "raw": 1514678400,
              "fmt": "2017-12-31"
            },
            "operatingIncome": {
              "raw": 4106000000,
              "fmt": "4.11B",
              "longFmt": "4,106,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 214000000,
              "fmt": "214M",
              "longFmt": "214,000,000"
            },
            "interestExpense": {
              "raw": -848000000,
              "fmt": "-848M",
              "longFmt": "-848,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 769000000,
              "fmt": "769M",
              "longFmt": "769,000,000"
            },
            "totalRevenue": {
              "raw": 177866000000,
              "fmt": "177.87B",
              "longFmt": "177,866,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 173760000000,
              "fmt": "173.76B",
              "longFmt": "173,760,000,000"
            },
            "costOfRevenue": {
              "raw": 111934000000,
              "fmt": "111.93B",
              "longFmt": "111,934,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -304000000,
              "fmt": "-304M",
              "longFmt": "-304,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 3033000000,
              "fmt": "3.03B",
              "longFmt": "3,033,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 3033000000,
              "fmt": "3.03B",
              "longFmt": "3,033,000,000"
            }
          },
          {
            "researchDevelopment": {
              "raw": 16085000000,
              "fmt": "16.09B",
              "longFmt": "16,085,000,000"
            },
            "effectOfAccountingCharges": {},
            "incomeBeforeTax": {
              "raw": 3796000000,
              "fmt": "3.8B",
              "longFmt": "3,796,000,000"
            },
            "minorityInterest": {},
            "netIncome": {
              "raw": 2371000000,
              "fmt": "2.37B",
              "longFmt": "2,371,000,000"
            },
            "sellingGeneralAdministrative": {
              "raw": 27284000000,
              "fmt": "27.28B",
              "longFmt": "27,284,000,000"
            },
            "grossProfit": {
              "raw": 47722000000,
              "fmt": "47.72B",
              "longFmt": "47,722,000,000"
            },
            "ebit": {
              "raw": 4186000000,
              "fmt": "4.19B",
              "longFmt": "4,186,000,000"
            },
            "endDate": {
              "raw": 1483142400,
              "fmt": "2016-12-31"
            },
            "operatingIncome": {
              "raw": 4186000000,
              "fmt": "4.19B",
              "longFmt": "4,186,000,000"
            },
            "otherOperatingExpenses": {
              "raw": 167000000,
              "fmt": "167M",
              "longFmt": "167,000,000"
            },
            "interestExpense": {
              "raw": -484000000,
              "fmt": "-484M",
              "longFmt": "-484,000,000"
            },
            "extraordinaryItems": {},
            "nonRecurring": {},
            "otherItems": {},
            "incomeTaxExpense": {
              "raw": 1425000000,
              "fmt": "1.43B",
              "longFmt": "1,425,000,000"
            },
            "totalRevenue": {
              "raw": 135987000000,
              "fmt": "135.99B",
              "longFmt": "135,987,000,000"
            },
            "totalOperatingExpenses": {
              "raw": 131801000000,
              "fmt": "131.8B",
              "longFmt": "131,801,000,000"
            },
            "costOfRevenue": {
              "raw": 88265000000,
              "fmt": "88.27B",
              "longFmt": "88,265,000,000"
            },
            "totalOtherIncomeExpenseNet": {
              "raw": -390000000,
              "fmt": "-390M",
              "longFmt": "-390,000,000"
            },
            "maxAge": 1,
            "discontinuedOperations": {},
            "netIncomeFromContinuingOps": {
              "raw": 2371000000,
              "fmt": "2.37B",
              "longFmt": "2,371,000,000"
            },
            "netIncomeApplicableToCommonShares": {
              "raw": 2371000000,
              "fmt": "2.37B",
              "longFmt": "2,371,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "balanceSheetHistory": {
        "balanceSheetStatements": [
          {
            "intangibleAssets": {
              "raw": 4049000000,
              "fmt": "4.05B",
              "longFmt": "4,049,000,000"
            },
            "capitalSurplus": {
              "raw": 33658000000,
              "fmt": "33.66B",
              "longFmt": "33,658,000,000"
            },
            "totalLiab": {
              "raw": 163188000000,
              "fmt": "163.19B",
              "longFmt": "163,188,000,000"
            },
            "totalStockholderEquity": {
              "raw": 62060000000,
              "fmt": "62.06B",
              "longFmt": "62,060,000,000"
            },
            "otherCurrentLiab": {
              "raw": 12202000000,
              "fmt": "12.2B",
              "longFmt": "12,202,000,000"
            },
            "totalAssets": {
              "raw": 225248000000,
              "fmt": "225.25B",
              "longFmt": "225,248,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 276000000,
              "fmt": "276M",
              "longFmt": "276,000,000"
            },
            "retainedEarnings": {
              "raw": 31220000000,
              "fmt": "31.22B",
              "longFmt": "31,220,000,000"
            },
            "otherLiab": {
              "raw": 12171000000,
              "fmt": "12.17B",
              "longFmt": "12,171,000,000"
            },
            "goodWill": {
              "raw": 14754000000,
              "fmt": "14.75B",
              "longFmt": "14,754,000,000"
            },
            "treasuryStock": {
              "raw": -2823000000,
              "fmt": "-2.82B",
              "longFmt": "-2,823,000,000"
            },
            "otherAssets": {
              "raw": 10096000000,
              "fmt": "10.1B",
              "longFmt": "10,096,000,000"
            },
            "cash": {
              "raw": 36092000000,
              "fmt": "36.09B",
              "longFmt": "36,092,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 87812000000,
              "fmt": "87.81B",
              "longFmt": "87,812,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1307000000,
              "fmt": "1.31B",
              "longFmt": "1,307,000,000"
            },
            "otherStockholderEquity": {
              "raw": -986000000,
              "fmt": "-986M",
              "longFmt": "-986,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 97846000000,
              "fmt": "97.85B",
              "longFmt": "97,846,000,000"
            },
            "totalCurrentAssets": {
              "raw": 96334000000,
              "fmt": "96.33B",
              "longFmt": "96,334,000,000"
            },
            "longTermInvestments": {
              "raw": 2169000000,
              "fmt": "2.17B",
              "longFmt": "2,169,000,000"
            },
            "netTangibleAssets": {
              "raw": 43257000000,
              "fmt": "43.26B",
              "longFmt": "43,257,000,000"
            },
            "shortTermInvestments": {
              "raw": 18929000000,
              "fmt": "18.93B",
              "longFmt": "18,929,000,000"
            },
            "netReceivables": {
              "raw": 20540000000,
              "fmt": "20.54B",
              "longFmt": "20,540,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 23414000000,
              "fmt": "23.41B",
              "longFmt": "23,414,000,000"
            },
            "inventory": {
              "raw": 20497000000,
              "fmt": "20.5B",
              "longFmt": "20,497,000,000"
            },
            "accountsPayable": {
              "raw": 47183000000,
              "fmt": "47.18B",
              "longFmt": "47,183,000,000"
            }
          },
          {
            "intangibleAssets": {
              "raw": 4110000000,
              "fmt": "4.11B",
              "longFmt": "4,110,000,000"
            },
            "capitalSurplus": {
              "raw": 26791000000,
              "fmt": "26.79B",
              "longFmt": "26,791,000,000"
            },
            "totalLiab": {
              "raw": 119099000000,
              "fmt": "119.1B",
              "longFmt": "119,099,000,000"
            },
            "totalStockholderEquity": {
              "raw": 43549000000,
              "fmt": "43.55B",
              "longFmt": "43,549,000,000"
            },
            "otherCurrentLiab": {
              "raw": 9959000000,
              "fmt": "9.96B",
              "longFmt": "9,959,000,000"
            },
            "totalAssets": {
              "raw": 162648000000,
              "fmt": "162.65B",
              "longFmt": "162,648,000,000"
            },
            "endDate": {
              "raw": 1546214400,
              "fmt": "2018-12-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 418000000,
              "fmt": "418M",
              "longFmt": "418,000,000"
            },
            "retainedEarnings": {
              "raw": 19625000000,
              "fmt": "19.62B",
              "longFmt": "19,625,000,000"
            },
            "otherLiab": {
              "raw": 17563000000,
              "fmt": "17.56B",
              "longFmt": "17,563,000,000"
            },
            "goodWill": {
              "raw": 14548000000,
              "fmt": "14.55B",
              "longFmt": "14,548,000,000"
            },
            "treasuryStock": {
              "raw": -2872000000,
              "fmt": "-2.87B",
              "longFmt": "-2,872,000,000"
            },
            "otherAssets": {
              "raw": 6370000000,
              "fmt": "6.37B",
              "longFmt": "6,370,000,000"
            },
            "cash": {
              "raw": 31750000000,
              "fmt": "31.75B",
              "longFmt": "31,750,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 68391000000,
              "fmt": "68.39B",
              "longFmt": "68,391,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1371000000,
              "fmt": "1.37B",
              "longFmt": "1,371,000,000"
            },
            "otherStockholderEquity": {
              "raw": -1035000000,
              "fmt": "-1.03B",
              "longFmt": "-1,035,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 61797000000,
              "fmt": "61.8B",
              "longFmt": "61,797,000,000"
            },
            "totalCurrentAssets": {
              "raw": 75101000000,
              "fmt": "75.1B",
              "longFmt": "75,101,000,000"
            },
            "longTermInvestments": {
              "raw": 722000000,
              "fmt": "722M",
              "longFmt": "722,000,000"
            },
            "netTangibleAssets": {
              "raw": 24891000000,
              "fmt": "24.89B",
              "longFmt": "24,891,000,000"
            },
            "shortTermInvestments": {
              "raw": 9500000000,
              "fmt": "9.5B",
              "longFmt": "9,500,000,000"
            },
            "netReceivables": {
              "raw": 16259000000,
              "fmt": "16.26B",
              "longFmt": "16,259,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 23495000000,
              "fmt": "23.5B",
              "longFmt": "23,495,000,000"
            },
            "inventory": {
              "raw": 17174000000,
              "fmt": "17.17B",
              "longFmt": "17,174,000,000"
            },
            "accountsPayable": {
              "raw": 38192000000,
              "fmt": "38.19B",
              "longFmt": "38,192,000,000"
            }
          },
          {
            "intangibleAssets": {
              "raw": 3371000000,
              "fmt": "3.37B",
              "longFmt": "3,371,000,000"
            },
            "capitalSurplus": {
              "raw": 21389000000,
              "fmt": "21.39B",
              "longFmt": "21,389,000,000"
            },
            "totalLiab": {
              "raw": 103601000000,
              "fmt": "103.6B",
              "longFmt": "103,601,000,000"
            },
            "totalStockholderEquity": {
              "raw": 27709000000,
              "fmt": "27.71B",
              "longFmt": "27,709,000,000"
            },
            "otherCurrentLiab": {
              "raw": 8565000000,
              "fmt": "8.56B",
              "longFmt": "8,565,000,000"
            },
            "totalAssets": {
              "raw": 131310000000,
              "fmt": "131.31B",
              "longFmt": "131,310,000,000"
            },
            "endDate": {
              "raw": 1514678400,
              "fmt": "2017-12-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "otherCurrentAssets": {
              "raw": 1329000000,
              "fmt": "1.33B",
              "longFmt": "1,329,000,000"
            },
            "retainedEarnings": {
              "raw": 8636000000,
              "fmt": "8.64B",
              "longFmt": "8,636,000,000"
            },
            "otherLiab": {
              "raw": 7792000000,
              "fmt": "7.79B",
              "longFmt": "7,792,000,000"
            },
            "goodWill": {
              "raw": 13350000000,
              "fmt": "13.35B",
              "longFmt": "13,350,000,000"
            },
            "treasuryStock": {
              "raw": -2321000000,
              "fmt": "-2.32B",
              "longFmt": "-2,321,000,000"
            },
            "otherAssets": {
              "raw": 5085000000,
              "fmt": "5.08B",
              "longFmt": "5,085,000,000"
            },
            "cash": {
              "raw": 20522000000,
              "fmt": "20.52B",
              "longFmt": "20,522,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 57883000000,
              "fmt": "57.88B",
              "longFmt": "57,883,000,000"
            },
            "shortLongTermDebt": {
              "raw": 100000000,
              "fmt": "100M",
              "longFmt": "100,000,000"
            },
            "otherStockholderEquity": {
              "raw": -484000000,
              "fmt": "-484M",
              "longFmt": "-484,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 48866000000,
              "fmt": "48.87B",
              "longFmt": "48,866,000,000"
            },
            "totalCurrentAssets": {
              "raw": 60197000000,
              "fmt": "60.2B",
              "longFmt": "60,197,000,000"
            },
            "longTermInvestments": {
              "raw": 441000000,
              "fmt": "441M",
              "longFmt": "441,000,000"
            },
            "netTangibleAssets": {
              "raw": 10988000000,
              "fmt": "10.99B",
              "longFmt": "10,988,000,000"
            },
            "shortTermInvestments": {
              "raw": 10464000000,
              "fmt": "10.46B",
              "longFmt": "10,464,000,000"
            },
            "netReceivables": {
              "raw": 11835000000,
              "fmt": "11.84B",
              "longFmt": "11,835,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 24743000000,
              "fmt": "24.74B",
              "longFmt": "24,743,000,000"
            },
            "inventory": {
              "raw": 16047000000,
              "fmt": "16.05B",
              "longFmt": "16,047,000,000"
            },
            "accountsPayable": {
              "raw": 34616000000,
              "fmt": "34.62B",
              "longFmt": "34,616,000,000"
            }
          },
          {
            "intangibleAssets": {
              "raw": 854000000,
              "fmt": "854M",
              "longFmt": "854,000,000"
            },
            "capitalSurplus": {
              "raw": 17186000000,
              "fmt": "17.19B",
              "longFmt": "17,186,000,000"
            },
            "totalLiab": {
              "raw": 64117000000,
              "fmt": "64.12B",
              "longFmt": "64,117,000,000"
            },
            "totalStockholderEquity": {
              "raw": 19285000000,
              "fmt": "19.29B",
              "longFmt": "19,285,000,000"
            },
            "otherCurrentLiab": {
              "raw": 7168000000,
              "fmt": "7.17B",
              "longFmt": "7,168,000,000"
            },
            "totalAssets": {
              "raw": 83402000000,
              "fmt": "83.4B",
              "longFmt": "83,402,000,000"
            },
            "endDate": {
              "raw": 1483142400,
              "fmt": "2016-12-31"
            },
            "commonStock": {
              "raw": 5000000,
              "fmt": "5M",
              "longFmt": "5,000,000"
            },
            "retainedEarnings": {
              "raw": 4916000000,
              "fmt": "4.92B",
              "longFmt": "4,916,000,000"
            },
            "otherLiab": {
              "raw": 5088000000,
              "fmt": "5.09B",
              "longFmt": "5,088,000,000"
            },
            "goodWill": {
              "raw": 3784000000,
              "fmt": "3.78B",
              "longFmt": "3,784,000,000"
            },
            "treasuryStock": {
              "raw": -2822000000,
              "fmt": "-2.82B",
              "longFmt": "-2,822,000,000"
            },
            "otherAssets": {
              "raw": 3646000000,
              "fmt": "3.65B",
              "longFmt": "3,646,000,000"
            },
            "cash": {
              "raw": 19334000000,
              "fmt": "19.33B",
              "longFmt": "19,334,000,000"
            },
            "totalCurrentLiabilities": {
              "raw": 43816000000,
              "fmt": "43.82B",
              "longFmt": "43,816,000,000"
            },
            "shortLongTermDebt": {
              "raw": 1056000000,
              "fmt": "1.06B",
              "longFmt": "1,056,000,000"
            },
            "otherStockholderEquity": {
              "raw": -985000000,
              "fmt": "-985M",
              "longFmt": "-985,000,000"
            },
            "propertyPlantEquipment": {
              "raw": 29114000000,
              "fmt": "29.11B",
              "longFmt": "29,114,000,000"
            },
            "totalCurrentAssets": {
              "raw": 45781000000,
              "fmt": "45.78B",
              "longFmt": "45,781,000,000"
            },
            "longTermInvestments": {
              "raw": 223000000,
              "fmt": "223M",
              "longFmt": "223,000,000"
            },
            "netTangibleAssets": {
              "raw": 14647000000,
              "fmt": "14.65B",
              "longFmt": "14,647,000,000"
            },
            "shortTermInvestments": {
              "raw": 6647000000,
              "fmt": "6.65B",
              "longFmt": "6,647,000,000"
            },
            "netReceivables": {
              "raw": 8339000000,
              "fmt": "8.34B",
              "longFmt": "8,339,000,000"
            },
            "maxAge": 1,
            "longTermDebt": {
              "raw": 7694000000,
              "fmt": "7.69B",
              "longFmt": "7,694,000,000"
            },
            "inventory": {
              "raw": 11461000000,
              "fmt": "11.46B",
              "longFmt": "11,461,000,000"
            },
            "accountsPayable": {
              "raw": 25309000000,
              "fmt": "25.31B",
              "longFmt": "25,309,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "cashflowStatementHistoryQuarterly": {
        "cashflowStatements": [
          {
            "investments": {
              "raw": -11071000000,
              "fmt": "-11.07B",
              "longFmt": "-11,071,000,000"
            },
            "changeToLiabilities": {
              "raw": 8863000000,
              "fmt": "8.86B",
              "longFmt": "8,863,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -17804000000,
              "fmt": "-17.8B",
              "longFmt": "-17,804,000,000"
            },
            "netBorrowings": {
              "raw": 7408000000,
              "fmt": "7.41B",
              "longFmt": "7,408,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": 7408000000,
              "fmt": "7.41B",
              "longFmt": "7,408,000,000"
            },
            "changeToOperatingActivities": {
              "raw": 1699000000,
              "fmt": "1.7B",
              "longFmt": "1,699,000,000"
            },
            "netIncome": {
              "raw": 5243000000,
              "fmt": "5.24B",
              "longFmt": "5,243,000,000"
            },
            "changeInCash": {
              "raw": 10337000000,
              "fmt": "10.34B",
              "longFmt": "10,337,000,000"
            },
            "endDate": {
              "raw": 1593475200,
              "fmt": "2020-06-30"
            },
            "effectOfExchangeRate": {
              "raw": 127000000,
              "fmt": "127M",
              "longFmt": "127,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 20606000000,
              "fmt": "20.61B",
              "longFmt": "20,606,000,000"
            },
            "depreciation": {
              "raw": 5748000000,
              "fmt": "5.75B",
              "longFmt": "5,748,000,000"
            },
            "changeToInventory": {
              "raw": -672000000,
              "fmt": "-672M",
              "longFmt": "-672,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -2854000000,
              "fmt": "-2.85B",
              "longFmt": "-2,854,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 2579000000,
              "fmt": "2.58B",
              "longFmt": "2,579,000,000"
            },
            "capitalExpenditures": {
              "raw": -7459000000,
              "fmt": "-7.46B",
              "longFmt": "-7,459,000,000"
            }
          },
          {
            "investments": {
              "raw": -3375000000,
              "fmt": "-3.38B",
              "longFmt": "-3,375,000,000"
            },
            "changeToLiabilities": {
              "raw": -7437000000,
              "fmt": "-7.44B",
              "longFmt": "-7,437,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -8894000000,
              "fmt": "-8.89B",
              "longFmt": "-8,894,000,000"
            },
            "netBorrowings": {
              "raw": -2591000000,
              "fmt": "-2.59B",
              "longFmt": "-2,591,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -2591000000,
              "fmt": "-2.59B",
              "longFmt": "-2,591,000,000"
            },
            "changeToOperatingActivities": {
              "raw": -2761000000,
              "fmt": "-2.76B",
              "longFmt": "-2,761,000,000"
            },
            "netIncome": {
              "raw": 2535000000,
              "fmt": "2.54B",
              "longFmt": "2,535,000,000"
            },
            "changeInCash": {
              "raw": -8905000000,
              "fmt": "-8.9B",
              "longFmt": "-8,905,000,000"
            },
            "endDate": {
              "raw": 1585612800,
              "fmt": "2020-03-31"
            },
            "effectOfExchangeRate": {
              "raw": -484000000,
              "fmt": "-484M",
              "longFmt": "-484,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 3064000000,
              "fmt": "3.06B",
              "longFmt": "3,064,000,000"
            },
            "depreciation": {
              "raw": 5362000000,
              "fmt": "5.36B",
              "longFmt": "5,362,000,000"
            },
            "changeToInventory": {
              "raw": 1392000000,
              "fmt": "1.39B",
              "longFmt": "1,392,000,000"
            },
            "changeToAccountReceivables": {
              "raw": 1262000000,
              "fmt": "1.26B",
              "longFmt": "1,262,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 2711000000,
              "fmt": "2.71B",
              "longFmt": "2,711,000,000"
            },
            "capitalExpenditures": {
              "raw": -6795000000,
              "fmt": "-6.79B",
              "longFmt": "-6,795,000,000"
            }
          },
          {
            "investments": {
              "raw": 1181000000,
              "fmt": "1.18B",
              "longFmt": "1,181,000,000"
            },
            "changeToLiabilities": {
              "raw": 11169000000,
              "fmt": "11.17B",
              "longFmt": "11,169,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -3536000000,
              "fmt": "-3.54B",
              "longFmt": "-3,536,000,000"
            },
            "netBorrowings": {
              "raw": -3571000000,
              "fmt": "-3.57B",
              "longFmt": "-3,571,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -3571000000,
              "fmt": "-3.57B",
              "longFmt": "-3,571,000,000"
            },
            "changeToOperatingActivities": {
              "raw": 2894000000,
              "fmt": "2.89B",
              "longFmt": "2,894,000,000"
            },
            "netIncome": {
              "raw": 3268000000,
              "fmt": "3.27B",
              "longFmt": "3,268,000,000"
            },
            "changeInCash": {
              "raw": 12856000000,
              "fmt": "12.86B",
              "longFmt": "12,856,000,000"
            },
            "endDate": {
              "raw": 1577750400,
              "fmt": "2019-12-31"
            },
            "effectOfExchangeRate": {
              "raw": 304000000,
              "fmt": "304M",
              "longFmt": "304,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 19659000000,
              "fmt": "19.66B",
              "longFmt": "19,659,000,000"
            },
            "depreciation": {
              "raw": 6170000000,
              "fmt": "6.17B",
              "longFmt": "6,170,000,000"
            },
            "changeToInventory": {
              "raw": -1516000000,
              "fmt": "-1.52B",
              "longFmt": "-1,516,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -3905000000,
              "fmt": "-3.9B",
              "longFmt": "-3,905,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 1579000000,
              "fmt": "1.58B",
              "longFmt": "1,579,000,000"
            },
            "capitalExpenditures": {
              "raw": -5312000000,
              "fmt": "-5.31B",
              "longFmt": "-5,312,000,000"
            }
          },
          {
            "investments": {
              "raw": -1291000000,
              "fmt": "-1.29B",
              "longFmt": "-1,291,000,000"
            },
            "changeToLiabilities": {
              "raw": 173000000,
              "fmt": "173M",
              "longFmt": "173,000,000"
            },
            "totalCashflowsFromInvestingActivities": {
              "raw": -5074000000,
              "fmt": "-5.07B",
              "longFmt": "-5,074,000,000"
            },
            "netBorrowings": {
              "raw": -1960000000,
              "fmt": "-1.96B",
              "longFmt": "-1,960,000,000"
            },
            "totalCashFromFinancingActivities": {
              "raw": -1960000000,
              "fmt": "-1.96B",
              "longFmt": "-1,960,000,000"
            },
            "changeToOperatingActivities": {
              "raw": -722000000,
              "fmt": "-722M",
              "longFmt": "-722,000,000"
            },
            "netIncome": {
              "raw": 2134000000,
              "fmt": "2.13B",
              "longFmt": "2,134,000,000"
            },
            "changeInCash": {
              "raw": 589000000,
              "fmt": "589M",
              "longFmt": "589,000,000"
            },
            "endDate": {
              "raw": 1569801600,
              "fmt": "2019-09-30"
            },
            "effectOfExchangeRate": {
              "raw": -269000000,
              "fmt": "-269M",
              "longFmt": "-269,000,000"
            },
            "totalCashFromOperatingActivities": {
              "raw": 7892000000,
              "fmt": "7.89B",
              "longFmt": "7,892,000,000"
            },
            "depreciation": {
              "raw": 5563000000,
              "fmt": "5.56B",
              "longFmt": "5,563,000,000"
            },
            "changeToInventory": {
              "raw": -381000000,
              "fmt": "-381M",
              "longFmt": "-381,000,000"
            },
            "changeToAccountReceivables": {
              "raw": -1181000000,
              "fmt": "-1.18B",
              "longFmt": "-1,181,000,000"
            },
            "maxAge": 1,
            "changeToNetincome": {
              "raw": 2306000000,
              "fmt": "2.31B",
              "longFmt": "2,306,000,000"
            },
            "capitalExpenditures": {
              "raw": -4697000000,
              "fmt": "-4.7B",
              "longFmt": "-4,697,000,000"
            }
          }
        ],
        "maxAge": 86400
      },
      "quoteType": {
        "exchange": "NMS",
        "shortName": "Amazon.com, Inc.",
        "longName": "Amazon.com, Inc.",
        "exchangeTimezoneName": "America/New_York",
        "exchangeTimezoneShortName": "EDT",
        "isEsgPopulated": false,
        "gmtOffSetMilliseconds": "-14400000",
        "quoteType": "EQUITY",
        "symbol": "AMZN",
        "messageBoardId": "finmb_18749",
        "market": "us_market"
      },
      "summaryDetail": {
        "previousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "regularMarketOpen": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "twoHundredDayAverage": {
          "raw": 2856.3691,
          "fmt": "2,856.37"
        },
        "trailingAnnualDividendYield": {},
        "payoutRatio": {
          "raw": 0,
          "fmt": "0.00%"
        },
        "volume24Hr": {},
        "regularMarketDayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        },
        "navPrice": {},
        "averageDailyVolume10Day": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "totalAssets": {},
        "regularMarketPreviousClose": {
          "raw": 3184.94,
          "fmt": "3,184.94"
        },
        "fiftyDayAverage": {
          "raw": 3190.4482,
          "fmt": "3,190.45"
        },
        "trailingAnnualDividendRate": {},
        "open": {
          "raw": 3189.87,
          "fmt": "3,189.87"
        },
        "toCurrency": null,
        "averageVolume10days": {
          "raw": 5743300,
          "fmt": "5.74M",
          "longFmt": "5,743,300"
        },
        "expireDate": {},
        "yield": {},
        "algorithm": null,
        "dividendRate": {},
        "exDividendDate": {},
        "beta": {
          "raw": 1.353006,
          "fmt": "1.35"
        },
        "circulatingSupply": {},
        "startDate": {},
        "regularMarketDayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "priceHint": {
          "raw": 2,
          "fmt": "2",
          "longFmt": "2"
        },
        "currency": "USD",
        "trailingPE": {
          "raw": 121.1956,
          "fmt": "121.20"
        },
        "regularMarketVolume": {
          "raw": 2417976,
          "fmt": "2.42M",
          "longFmt": "2,417,976"
        },
        "lastMarket": null,
        "maxSupply": {},
        "openInterest": {},
        "marketCap": {
          "raw": 1580593446912,
          "fmt": "1.58T",
          "longFmt": "1,580,593,446,912"
        },
        "volumeAllCurrencies": {},
        "strikePrice": {},
        "averageVolume": {
          "raw": 4878816,
          "fmt": "4.88M",
          "longFmt": "4,878,816"
        },
        "priceToSalesTrailing12Months": {
          "raw": 4.912001,
          "fmt": "4.91"
        },
        "dayLow": {
          "raw": 3121.94,
          "fmt": "3,121.94"
        },
        "ask": {
          "raw": 3148.79,
          "fmt": "3,148.79"
        },
        "ytdReturn": {},
        "askSize": {
          "raw": 3000,
          "fmt": "3k",
          "longFmt": "3,000"
        },
        "volume": {
          "raw": 2417976,
          "fmt": "2.42M",
          "longFmt": "2,417,976"
        },
        "fiftyTwoWeekHigh": {
          "raw": 3552.25,
          "fmt": "3,552.25"
        },
        "forwardPE": {
          "raw": 71.11945,
          "fmt": "71.12"
        },
        "maxAge": 1,
        "fromCurrency": null,
        "fiveYearAvgDividendYield": {},
        "fiftyTwoWeekLow": {
          "raw": 1626.03,
          "fmt": "1,626.03"
        },
        "bid": {
          "raw": 3146.91,
          "fmt": "3,146.91"
        },
        "tradeable": false,
        "dividendYield": {},
        "bidSize": {
          "raw": 1100,
          "fmt": "1.1k",
          "longFmt": "1,100"
        },
        "dayHigh": {
          "raw": 3198.75,
          "fmt": "3,198.75"
        }
      },
      "symbol": "AMZN",
      "pageViews": {
        "shortTermTrend": "UP",
        "midTermTrend": "UP",
        "longTermTrend": "UP",
        "maxAge": 1
      },
      "timeSeries": {
        "trailingInterestExpense": [
          {
            "dataId": 20057,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 1656000000,
              "fmt": "1.66B"
            }
          }
        ],
        "annualNetIncome": [
          {
            "dataId": 20091,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 2371000000,
              "fmt": "2.37B"
            }
          },
          {
            "dataId": 20091,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3033000000,
              "fmt": "3.03B"
            }
          },
          {
            "dataId": 20091,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 10073000000,
              "fmt": "10.07B"
            }
          },
          {
            "dataId": 20091,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 11588000000,
              "fmt": "11.59B"
            }
          }
        ],
        "annualPretaxIncome": [
          {
            "dataId": 20136,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3892000000,
              "fmt": "3.89B"
            }
          },
          {
            "dataId": 20136,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3806000000,
              "fmt": "3.81B"
            }
          },
          {
            "dataId": 20136,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 11261000000,
              "fmt": "11.26B"
            }
          },
          {
            "dataId": 20136,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 13976000000,
              "fmt": "13.98B"
            }
          }
        ],
        "annualInterestExpense": [
          {
            "dataId": 20057,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 484000000,
              "fmt": "484.00M"
            }
          },
          {
            "dataId": 20057,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 848000000,
              "fmt": "848.00M"
            }
          },
          {
            "dataId": 20057,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 1417000000,
              "fmt": "1.42B"
            }
          },
          {
            "dataId": 20057,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 1600000000,
              "fmt": "1.60B"
            }
          }
        ],
        "trailingCostOfRevenue": [
          {
            "dataId": 20013,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 239893000000,
              "fmt": "239.89B"
            }
          }
        ],
        "trailingResearchAndDevelopment": [
          {
            "dataId": 20151,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 38653000000,
              "fmt": "38.65B"
            }
          }
        ],
        "trailingTotalRevenue": [
          {
            "dataId": 20100,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 321782000000,
              "fmt": "321.78B"
            }
          }
        ],
        "annualEbitda": [
          {
            "dataId": 20190,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 12492000000,
              "fmt": "12.49B"
            }
          },
          {
            "dataId": 20190,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 16132000000,
              "fmt": "16.13B"
            }
          },
          {
            "dataId": 20190,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 28019000000,
              "fmt": "28.02B"
            }
          },
          {
            "dataId": 20190,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 37365000000,
              "fmt": "37.37B"
            }
          }
        ],
        "annualNetIncomeContinuousOperations": [
          {
            "dataId": 20094,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 2371000000,
              "fmt": "2.37B"
            }
          },
          {
            "dataId": 20094,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3033000000,
              "fmt": "3.03B"
            }
          },
          {
            "dataId": 20094,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 10073000000,
              "fmt": "10.07B"
            }
          },
          {
            "dataId": 20094,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 11588000000,
              "fmt": "11.59B"
            }
          }
        ],
        "annualBasicEPS": [
          {
            "dataId": 29004,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 5.01,
              "fmt": "5.01"
            }
          },
          {
            "dataId": 29004,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 6.32,
              "fmt": "6.32"
            }
          },
          {
            "dataId": 29004,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 20.68,
              "fmt": "20.68"
            }
          },
          {
            "dataId": 29004,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 23.46,
              "fmt": "23.46"
            }
          }
        ],
        "annualOperatingExpense": [
          {
            "dataId": 20108,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 25917000000,
              "fmt": "25.92B"
            }
          },
          {
            "dataId": 20108,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 36577000000,
              "fmt": "36.58B"
            }
          },
          {
            "dataId": 20108,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 47283000000,
              "fmt": "47.28B"
            }
          },
          {
            "dataId": 20108,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 60213000000,
              "fmt": "60.21B"
            }
          }
        ],
        "annualCostOfRevenue": [
          {
            "dataId": 20013,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 105884000000,
              "fmt": "105.88B"
            }
          },
          {
            "dataId": 20013,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 137183000000,
              "fmt": "137.18B"
            }
          },
          {
            "dataId": 20013,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 173183000000,
              "fmt": "173.18B"
            }
          },
          {
            "dataId": 20013,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 205768000000,
              "fmt": "205.77B"
            }
          }
        ],
        "trailingSellingGeneralAndAdministration": [
          {
            "dataId": 20159,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 25887000000,
              "fmt": "25.89B"
            }
          }
        ],
        "trailingOperatingExpense": [
          {
            "dataId": 20108,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 65020000000,
              "fmt": "65.02B"
            }
          }
        ],
        "annualDilutedEPS": [
          {
            "dataId": 29009,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 4.9,
              "fmt": "4.90"
            }
          },
          {
            "dataId": 29009,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 6.15,
              "fmt": "6.15"
            }
          },
          {
            "dataId": 29009,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 20.14,
              "fmt": "20.14"
            }
          },
          {
            "dataId": 29009,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 23.01,
              "fmt": "23.01"
            }
          }
        ],
        "annualOtherIncomeExpense": [
          {
            "dataId": 20117,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 90000000,
              "fmt": "90.00M"
            }
          },
          {
            "dataId": 20117,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 346000000,
              "fmt": "346.00M"
            }
          },
          {
            "dataId": 20117,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": -183000000,
              "fmt": "-183.00M"
            }
          },
          {
            "dataId": 20117,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 203000000,
              "fmt": "203.00M"
            }
          }
        ],
        "trailingNetIncomeContinuousOperations": [
          {
            "dataId": 20094,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 13180000000,
              "fmt": "13.18B"
            }
          }
        ],
        "annualTotalRevenue": [
          {
            "dataId": 20100,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 135987000000,
              "fmt": "135.99B"
            }
          },
          {
            "dataId": 20100,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 177866000000,
              "fmt": "177.87B"
            }
          },
          {
            "dataId": 20100,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 232887000000,
              "fmt": "232.89B"
            }
          },
          {
            "dataId": 20100,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 280522000000,
              "fmt": "280.52B"
            }
          }
        ],
        "trailingOtherIncomeExpense": [
          {
            "dataId": 20117,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 305000000,
              "fmt": "305.00M"
            }
          }
        ],
        "trailingGrossProfit": [
          {
            "dataId": 20046,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 81889000000,
              "fmt": "81.89B"
            }
          }
        ],
        "annualNetIncomeCommonStockholders": [
          {
            "dataId": 20093,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 2371000000,
              "fmt": "2.37B"
            }
          },
          {
            "dataId": 20093,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3033000000,
              "fmt": "3.03B"
            }
          },
          {
            "dataId": 20093,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 10073000000,
              "fmt": "10.07B"
            }
          },
          {
            "dataId": 20093,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 11588000000,
              "fmt": "11.59B"
            }
          }
        ],
        "annualOperatingIncome": [
          {
            "dataId": 20109,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 4186000000,
              "fmt": "4.19B"
            }
          },
          {
            "dataId": 20109,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 4106000000,
              "fmt": "4.11B"
            }
          },
          {
            "dataId": 20109,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 12421000000,
              "fmt": "12.42B"
            }
          },
          {
            "dataId": 20109,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 14541000000,
              "fmt": "14.54B"
            }
          }
        ],
        "annualBasicAverageShares": [
          {
            "dataId": 29010,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 474000000,
              "fmt": "474.00M"
            }
          },
          {
            "dataId": 29010,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 480000000,
              "fmt": "480.00M"
            }
          },
          {
            "dataId": 29010,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 487000000,
              "fmt": "487.00M"
            }
          },
          {
            "dataId": 29010,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 494000000,
              "fmt": "494.00M"
            }
          }
        ],
        "trailingOperatingIncome": [
          {
            "dataId": 20109,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 16869000000,
              "fmt": "16.87B"
            }
          }
        ],
        "trailingNetIncomeCommonStockholders": [
          {
            "dataId": 20093,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 13180000000,
              "fmt": "13.18B"
            }
          }
        ],
        "annualResearchAndDevelopment": [
          {
            "dataId": 20151,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 16085000000,
              "fmt": "16.09B"
            }
          },
          {
            "dataId": 20151,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 22620000000,
              "fmt": "22.62B"
            }
          },
          {
            "dataId": 20151,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 28837000000,
              "fmt": "28.84B"
            }
          },
          {
            "dataId": 20151,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 35931000000,
              "fmt": "35.93B"
            }
          }
        ],
        "annualGrossProfit": [
          {
            "dataId": 20046,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 30103000000,
              "fmt": "30.10B"
            }
          },
          {
            "dataId": 20046,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 40683000000,
              "fmt": "40.68B"
            }
          },
          {
            "dataId": 20046,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 59704000000,
              "fmt": "59.70B"
            }
          },
          {
            "dataId": 20046,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 74754000000,
              "fmt": "74.75B"
            }
          }
        ],
        "annualSellingGeneralAndAdministration": [
          {
            "dataId": 20159,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 9665000000,
              "fmt": "9.66B"
            }
          },
          {
            "dataId": 20159,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 13743000000,
              "fmt": "13.74B"
            }
          },
          {
            "dataId": 20159,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 18150000000,
              "fmt": "18.15B"
            }
          },
          {
            "dataId": 20159,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 24081000000,
              "fmt": "24.08B"
            }
          }
        ],
        "trailingNetIncome": [
          {
            "dataId": 20091,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 13180000000,
              "fmt": "13.18B"
            }
          }
        ],
        "trailingTaxProvision": [
          {
            "dataId": 20145,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 3009000000,
              "fmt": "3.01B"
            }
          }
        ],
        "trailingPretaxIncome": [
          {
            "dataId": 20136,
            "asOfDate": "2020-06-30",
            "periodType": "TTM",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 16289000000,
              "fmt": "16.29B"
            }
          }
        ],
        "annualTaxProvision": [
          {
            "dataId": 20145,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 1425000000,
              "fmt": "1.43B"
            }
          },
          {
            "dataId": 20145,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 769000000,
              "fmt": "769.00M"
            }
          },
          {
            "dataId": 20145,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 1197000000,
              "fmt": "1.20B"
            }
          },
          {
            "dataId": 20145,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 2374000000,
              "fmt": "2.37B"
            }
          }
        ],
        "annualDilutedAverageShares": [
          {
            "dataId": 29011,
            "asOfDate": "2016-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 484000000,
              "fmt": "484.00M"
            }
          },
          {
            "dataId": 29011,
            "asOfDate": "2017-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 493000000,
              "fmt": "493.00M"
            }
          },
          {
            "dataId": 29011,
            "asOfDate": "2018-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 500000000,
              "fmt": "500.00M"
            }
          },
          {
            "dataId": 29011,
            "asOfDate": "2019-12-31",
            "periodType": "12M",
            "currencyCode": "USD",
            "reportedValue": {
              "raw": 504000000,
              "fmt": "504.00M"
            }
          }
        ],
        "trailingBasicAverageShares": [],
        "trailingBasicEPS": [],
        "trailingDilutedAverageShares": [],
        "trailingDilutedEPS": [],
        "timestamp": [
          1483142400,
          1514678400,
          1546214400,
          1577750400
        ]
      },
      "meta": {
        "symbol": "AMZN",
        "start": 493590046,
        "end": 1603386713,
        "timeUnit": "annual"
      },
      "loading": false,
      "errorList": []
    }
```

</details>
