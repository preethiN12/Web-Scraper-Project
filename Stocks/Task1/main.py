stocks = []

def getstocks(filename):
    file = open(filename, "r")
    for i in file:
        stocks.append(i.strip().split(", "))

def getlargestprice():
    biggest = 0
    biggestindex = 0
    openorclose = 0
    for i in range(len(stocks)):
        for j in range(1, 3):
            if float(stocks[i][j]) > biggest:
                biggest = float(stocks[i][j])
                openorclose = j
                biggestindex = i
    return stocks[biggestindex][0], stocks[biggestindex][openorclose]

getstocks("Stocks.txt")
print(getlargestprice())
