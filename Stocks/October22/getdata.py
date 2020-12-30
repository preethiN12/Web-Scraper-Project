from urllib.request import urlopen
import json
def loaddata():
    url = "https://pkgstore.datahub.io/core/s-and-p-500-companies-financials/constituents-financials_json/data/ddf1c04b0ad45e44f976c1f32774ed9a/constituents-financials_json.json"

    page = urlopen(url)
    html_bytes = page.read()
    html = html_bytes.decode("utf-8")
    stocks = json.loads(html)
    return(stocks)