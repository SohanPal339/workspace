package sohan.com.lastfivedaysweather.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDetailsSummaryDto{

    @SerializedName("weather")
    private ArrayList<ResponseDetailsWeatherDto> WeatherSummary;

    @SerializedName("dt_txt")
    private String dateTime;

    public ArrayList<ResponseDetailsWeatherDto> getWeatherSummary() {
        return WeatherSummary;
    }

    public void setWeatherSummary(ArrayList<ResponseDetailsWeatherDto> weatherSummary) {
        WeatherSummary = weatherSummary;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
