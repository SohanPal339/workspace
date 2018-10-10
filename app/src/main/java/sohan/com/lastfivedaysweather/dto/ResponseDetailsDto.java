package sohan.com.lastfivedaysweather.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDetailsDto {

    @SerializedName("list")
    private ArrayList<ResponseDetailsSummaryDto> ListSummary;

    public ArrayList<ResponseDetailsSummaryDto> getListSummary() {
        return ListSummary;
    }

    public void setListSummary(ArrayList<ResponseDetailsSummaryDto> listSummary) {
        ListSummary = listSummary;
    }

}
