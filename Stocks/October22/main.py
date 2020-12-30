import getdata
import functions
stocks = getdata.loaddata()
menuchoice = ""

while menuchoice != "Q":
    print('''\n1. Get most expensive stock
2. Get stock info 
3. Get biggest change in price
4. Get market caps
Q. Quit''')

    menuchoice= input("Please pick an option: ")

    if menuchoice == "1":
        print(functions.getlargestprice(stocks))
    elif menuchoice == "2":
        ticker = input("Please enter a ticker: ")
        functions.getstockinfo(stocks, ticker)
    elif menuchoice == "3":
        print(functions.getbiggestchange(stocks))
    elif menuchoice == "4":
        print(functions.getmarketcaps(stocks))
