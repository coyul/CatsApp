## Overview
* A simple app, that fetches and displays a list of cats
* API documentation: https://developers.thecatapi.com/
* Screen
<div align = "center">
    <img src="https://github.com/coyul/CatsApp/assets/26003155/49ebb6ca-b5fc-4ee6-8307-2b7ca397c3c0" width="200">
</div>

## Chosen architecture
* Clean architecture for easy support and making changes
* MVVM pattern for UI for better support and handling activity state

## Chosen libraries
* Coroutines for asynchronous calls as light, fast and easy
* Hilt for DI to have dagger pros (like compile-time checking) without a lot of boilerplate code (and we don't need full dagger functionality for such simple app, we actually could go without DI framework at all)
* Retrofit for the network calls as the easiest
* Glide for picture loading as the easiest

## Room for improvement (not implemented due to strict time limits of 3 hours)
* Compose for UI (among other cons the most important for me will be avoiding coupling and improving readability with a declarative approach compared with xml-s and adapters)
* Unit tests coverage
* Improving UI - support different image sizes (right now they are all cropped to one size), add more valuable information (for instance slider for cat's friendliness, country of origin flag, etc)
* Pagination (right now the app fetches only 20 items)
* More distinct error handling