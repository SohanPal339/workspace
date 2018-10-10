# workspace
Coding assessment for last 5 days weather display



There are some details about assessment which I have done. Details are given below with points.


Used url:-  I am using below url for getting last five days weather.
https://samples.openweathermap.org/data/2.5/forecast?q=M%C3%BCnchen,DE&appid=b6907d289e10d714a6e88b30761fae22


UI Part:-
1.	There are 2 Activity, On 1st Activity there is only one Button, when we click on this button, 2nd Activity will open, where we can see Last 5 days weather details in list.
2.	In weather details, I am showing only three things, 1. Main 2. Description 3. Date time
3.	I am displaying these data main, description and date time from list json array.


Coding Part:-
1.	There are 2 Activity, one is MainActivity and second is LastFiveDaysWeatherActivity.
2.	In MainActivity, there is only one Button to open second LastFiveDaysWeatherActivity.
3.	LastFiveDaysWeatherActivity is using for displaying the weather derails in list.
4.	I have created some packages for separated the code like adapter, constants, dto, io, and parser.
5.	In adapter package, I have added only WeatherListAdapter for displaying data in list.
6.	In constants package, I have added for url, which I have used for getting the last five days weather.
7.	In dto package, I have added only dto class which are used for business logic.
8.	In parser package, I am using ServiceResponceParser for gson.
9.	In io package, I have added separated Asynctask and service invoker for network request.
10.	 A interface GetDataCallBack which I have added in io package.
11.	 I have used material design RecyclerView to display the weather data in list.
12.	 Three xml file inside layout folder, 1 is activity_main for MainActivity, 2nd is last_five_days_weather_list for LastFiveDaysWeatherActivity and 3rd is weather_list_item for WeatherListAdapter.
13.	 I have used gson api and added in libs folder.
14.	 Worked on MVP Pattern
15.	 In gradle file, I have added 2 dependencies, one for RecyclerView and second for gson api
16.	 Note: - completed coding part in 3 hours only, didn’t use retrofit, if you want I can develop this assessment in retrofit also.
