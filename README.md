Note:
I created a json file for this java exercise that served as the main database for the movies.
Please add the JAR file reference here before use. The JAR file imported can be downloaded here: https://github.com/stleary/JSON-java

Currently Existing Bugs/errors:
-When asked if the user wants to search again, and the user's choice will be no, the scanner will prompt again before the program terminates.
-Slow filter process

Here are the Assumptions I made in doing this exercise:

1. Knowing that I will be replicating a feature of a movie website or app, I will need some sort of database to neatly store my hard-coded movie data. I went with creating a JSON file to easily populate the movies, and using Java Archives classes to read the json file.
2. I assumed that everything I will do here will be READ only, therefore I no longer added a function where a user can update the value of isFavorite, or any keys or values.
3. With regards with the structure, apart from knowing I should have a local database file, I also needed to have seperate java files for different major functionalities. Here are the short summary of what each of the included java file here does, and also these are in order that is based on program flow:

   Start of Program

   \*Main.java: I wanted this file to contain less commands as possible. Here includes the command that puts the program in a loop where its continuity will be based on whether the user wants to search again or terminate the program.

   \*HandleQueryTypeInput.java: Here includes the first methods the program will initiate to handle different conditions for user inputs. It will start by accepting what type of filter method the user wants to use. And will then call that filter methods from HandleQueryInput.

   \*HandleQueryInput.java: This file includes methods that will now prompt the user to input the desired query based on what filter method the user chose. It will then use this query to and compare it with the data included in the movies.json file to see if the input data matches a value. If it does, the entire key-value pairs of object housing that matching element gets called and then passed to the ConstructResult.java

   \*ConstructResult.java: This file contains the method that structures the datatypes of each value to be printed, and also the last step before showing the formatted results to the terminal.

   End of Program

   \*ArraySearch.java: This file includes the method to search through every single element of an array, then returns a value "true" if there is a matching element. I used this because I have also assumed that directors, writers, genres, and actors will all be having not just one value, and I needed a class containing a method that returns a boolean value that checks an elements existence in those string arrays.

   \*Service.java: This file lets me parse and return json file from the api.

   This exercise uses a freemium api by Rapid API: https://rapidapi.com/apidojo/api/online-movie-database
   The number of calls able to be made is limited. If incase it does not connect to the api anymore due to call limit reached, here's a link directed to a screen record while I was testing the program showing all performance of each filter:

   Link to screen record program demo -> https://drive.google.com/file/d/1Bu59XUr7fEZI6DQrdd_A_kiJAYwB6hDI/view?usp=sharing

Here's a snippet of the contents of the json response object retrieved from the API:

[{"s":"Explore the nominees, red carpet looks, and video from the Primetime Emmys",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BYTk3ZTdjYzctOTM2YS00YTNlLWIyZTItNDYzMTJhYjkzZTY3XkEyXkFqcGdeQXVyMTk2ODc0MjY@._V1_.jpg","width":675,"height":1000},
"id":"/emmys",
"l":"Emmys"},

{"q":"TV series",
"s":"Emilia Clarke, Peter Dinklage",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg","width":1000,"height":1500},
"rank":22,
"y":2011,
"yr":"2011-2019",
"id":"tt0944947",
"l":"Game of Thrones",
"qid":"tvSeries"},

{"q":"video",
"s":"Roy Dotrice",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BNTg1MjEyNWYtNzJkZi00ZTM5LThlNWMtMmNiNmE3N2QxNTllXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_.jpg","width":782,"height":1200},
"rank":9222,
"y":2003,
"id":"tt13380510",
"l":"Game of Thrones",
"qid":"video"},

{"q":"TV series",
"s":"",
"rank":4849,
"id":"tt21073266",
"l":"Untitled Jon Snow/Game of Thrones Spinoff",
"qid":"tvSeries"},

{"q":"TV movie",
"s":"Kevin Alexander, Alfie Allen",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BZDdlMzQzNDQtNTAxMS00NTMyLTgxYTAtYzQ0OGI1YzZhY2Y3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg","width":810,"height":1200},
"rank":25790,
"y":2019,
"id":"tt10090796",
"l":"Game of Thrones: The Last Watch","qid":"tvMovie"},

{"q":"TV movie",
"s":"Naomi Watts, Miranda Richardson",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BODg5NDJhMjYtMTYyYi00NzAwLTliNmYtNGZhMjQ4ZjNkMjgyXkEyXkFqcGdeQXVyNTA3MTU2MjE@._V1_.jpg","width":1334,"height":750},
"rank":25797,
"y":2019,
"id":"tt6857128",
"l":"Unaired Game of Thrones Prequel Pilot",
"qid":"tvMovie"},

{"q":"TV series",
"s":"Rhys Ifans, Matt Smith",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BZjBiOGIyY2YtOTA3OC00YzY1LThkYjktMGRkYTNhNTExY2I2XkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg","width":1013,"height":1500},
"rank":128,"y":2022,
"id":"tt11198330",
"l":"House of the Dragon",
"qid":"tvSeries"},

{"q":"video",
"s":"Pilou Asbæk, Nikolaj Coster-Waldau",
"i":{"imageUrl":"https://m.media-amazon.com/images/M/MV5BMGYzNDJiOTgtN2Y1OC00NmM2LTk3MTMtZmFhNmJlMzQzNGNhXkEyXkFqcGdeQXVyNDgyODgxNjE@._V1_.jpg","width":600,"height":840},
"rank":34269,
"y":2017,
"id":"tt7937220",
"l":"Game of Thrones Conquest & Rebellion: An Animated History of the Seven Kingdoms","qid":"video"}
]
