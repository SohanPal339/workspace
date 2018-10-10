package sohan.com.lastfivedaysweather.dto;

import com.google.gson.annotations.SerializedName;


public class ResponseDetailsWeatherDto{

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
