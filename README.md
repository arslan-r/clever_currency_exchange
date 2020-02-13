# clever_currency_exchange
Using image processing and computer vission, this app allows a picture of a foreign price tag to be converted into your homeland currency.


Traveling? Can't wrap your head around the currency exchange rate? Take a picture of the price tag and you will find your answer. Goal is to design an app that's easier to use than manually typing in numbers.


# PROGRESS REPORT
Currently in transition to Google Vision API, as certain technologies aren't supported by android.


# DESIGN PLAN

I got the basic design down. Here is what to do next.
Implement the currency exchange feature by hard coding currency rates. Get that working. Should be ez pz.
  *  Find a resource that will provide you with a list of all currencies and their current rates. 
  * Would be downloaded when user starts up app for the frst time. 

Get the Camera to take photos.
* Save the image temporarily.
* Process image, pull out information.
  * Plug information into currencyFrom right away.

Should be pretty much it. Make it pretty. Throw in an animation. Maybe a plane? Skies are cool. Make it a sky blue and white theme.
* When users first start the app, ask them their home counrty (convert into). What to convert from (where they are traveling).
  * Make sure to not show that screen again.
  * save those preferences, until they change it themselves through the country spinner
  
See if its possible to start the app right away by double pressing volume buttons
See if you can rewire the pixel squeeze to open the app
* might be useful when an individual has gloves on/its cold

  
# Possible issues
* Need to obtain a dataset/constantly updated resource of all countries current exchange rates. 
  * CONS: Costs money to provide such service.
  * Maybe start a server, pull data for free every 30 minutes, link app to server?
   * Users might not use data as they are traveling. Roaming is expensive. Give them option when to update their currency rates.
  
  
# HOW THE APP SHOULD FUNCTION

- User opens app. Snaps a pic. Instantly gets a conversion. No internet required.
- Easy. Breezy. Beautiful.

