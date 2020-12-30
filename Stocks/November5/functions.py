def getlargestprice(stocks):
    largest = 0
    company = ""
    for i in range(len(stocks)):
        currentprice = stocks[i]["Price"]
        if currentprice > largest:
            largest = currentprice
            company = stocks[i]["Name"]
            ticker = stocks[i]["Symbol"]
    return ("The most expensive stock is '" + company + " (" + ticker + ")' which costs $" + str(largest))

def getstockinfo(stocks, ticker):
    for i in range(len(stocks)):
        if ticker == stocks[i]["Symbol"]:
            print(stocks[i]["Symbol"] + ": " + stocks[i]["Name"])
            print("Price: $" + str(stocks[i]["Price"]))
            print("52 Week High: $" + str(stocks[i]["52 Week Low"]))
            print("52 Week Low: $" + str(stocks[i]["52 Week High"]))
            return None
    print("Ticker is not valid")

def getbiggestchange(stocks):
    maxdiff = 0
    for i in range(len(stocks)):
        diff = float(stocks[i]["52 Week Low"]) - float(stocks[i]["52 Week High"])
        if diff > maxdiff:
            maxdiff = diff
            company = stocks[i]["Name"]
            ticker = stocks[i]["Symbol"]
    return ("The company with the largest change in price is '" + company + " (" + ticker + ")' which fluctuated by $" + str(maxdiff))

def getmarketcaps(stocks):
    maxcap = 0
    mincap = stocks[0]["Market Cap"]
    for i in range(len(stocks)):
        cap = stocks[i]["Market Cap"]
        if cap > maxcap:
            maxcap = cap
            companymax = stocks[i]["Name"]
            tickermax = stocks[i]["Symbol"]
        if cap < mincap:
            mincap = cap
            companymin = stocks[i]["Name"]
            tickermin = stocks[i]["Symbol"]
    outputmax = ("The company worth the most is '" + companymax + " (" + tickermax + ")' with a value of $" + str(maxcap))
    outputmin = ("The company worth the least is '" + companymin + " (" + tickermin + ")' with a value of $" + str(mincap))
    return (outputmax + "\n" + outputmin)