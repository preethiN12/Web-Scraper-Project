# November 26 Update
We attempted to incorporate the Yahoo Finance API call into our project to retrieve stock information.
We downloaded the GSON module into our project to make use of its JSON converting powers. 
The API call returns the stock information as a JSON string and we need to convert that string into 
a Stock object.

The issue we ran into is that we only need parts of that JSON string for our model, but we weren't able 
to find a way to parse only the parts of the JSON string that we need.

## Possible Next Steps
- Fix JSON string -> Stock conversion
- Implement Stock methods
- Create user interface to allow users to get info about stocks

