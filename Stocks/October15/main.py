from urllib.request import urlopen
import json

def getlargestprice(stocks):
    largest = 0
    company = ""
    for i in range(len(stocks)):
        currentprice = stocks[i]["Price"]
        if currentprice > largest:
            largest = currentprice
            company = stocks[i]["Name"]
    return ("The most expensive stock is '" + company + "' which costs $" + str(largest))

def getstockinfo(stocks, ticker):
    for i in range(len(stocks)):
        if ticker == stocks[i]["Symbol"]:
            print(stocks[i]["Symbol"] + ": " + stocks[i]["Name"])
            print("Price: $" + str(stocks[i]["Price"]))
            print("52 Week High: $" + str(stocks[i]["52 Week Low"]))
            print("52 Week Low: $" + str(stocks[i]["52 Week High"]))
            return None
    print("Ticker is not valid")



url = "https://pkgstore.datahub.io/core/s-and-p-500-companies-financials/constituents-financials_json/data/ddf1c04b0ad45e44f976c1f32774ed9a/constituents-financials_json.json"

page = urlopen(url)
html_bytes = page.read()
html = html_bytes.decode("utf-8")
stocks = json.loads(html)
print(getlargestprice(stocks))
ticker = input("Enter Ticker: ")
getstockinfo(stocks, ticker)
