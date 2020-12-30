# Stock Web Scraper

## Notes ([notion](https://www.notion.so/Stock-Web-Scraper-6a4ffaca5d8842f28f5daa6d41e03747))

### Variables

- Ticker
- Full company name
- Price
  - Store the price over time so you can see the change
  - Maybe a graph??
- Change in price (up or down)
- Previous day's close

### Pseudocode

- Get input from user → ticker of stock they want to search
- Only if the ticker/name is valid
  - Scrape data about selected stock from website
  - Sort & store data
  - Display data

### Features

- Store and track stocks that the user picks
- Alerting user if a stock rises or falls
    - Let user pick what the range is
- Search by ticker/company name
- Sort by ticker alphabetically
- Find out if largest price is opening or closing
- Percentage that the stock increases/decreases by

### Links to data sources
[https://datahub.io/core/s-and-p-500-companies-financials](https://datahub.io/core/s-and-p-500-companies-financials)

[https://english.api.rakuten.net/apidojo/api/yahoo-finance1?endpoint=5c3d9f1be4b0b136b4746bfe](https://english.api.rakuten.net/apidojo/api/yahoo-finance1?endpoint=5c3d9f1be4b0b136b4746bfe)
