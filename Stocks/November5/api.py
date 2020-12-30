import requests, json

def tickerString():
    tickers = ""
    filein = open("liststocks.txt", "r")

    for line in filein:
        tickers += line.strip() + ", "

    tickers =  tickers.strip(", ")
    return tickers

def getCompanies():
    url = "https://rapidapi.p.rapidapi.com/market/v2/get-quotes"


    querystring = {"symbols":tickerString(),"region":"US"}

    headers = {
        'x-rapidapi-host': "apidojo-yahoo-finance-v1.p.rapidapi.com",
        'x-rapidapi-key': "2c0a713024msh09d8e7ba381ef28p121405jsn5ed4de636fa8"
        }

    response = requests.request("GET", url, headers=headers, params=querystring)


    content = response.text
    content = json.loads(content)
    content = content["quoteResponse"]
    resultlist = content["result"]

    companies = {}

    for result in resultlist:
        ticker = result["symbol"]
        companies[ticker] = {}
        companies[ticker]["Name"] = result["shortName"]
        companies[ticker]["Price"] = result["regularMarketPrice"]
        companies[ticker]["52 Week High"] = result["fiftyTwoWeekHigh"]
        companies[ticker]["52 Week Low"] = result["fiftyTwoWeekLow"]
        companies[ticker]["Market Cap"] = result["marketCap"]

    return companies
