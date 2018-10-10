package sohan.com.lastfivedaysweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import sohan.com.lastfivedaysweather.adapter.WeatherListAdapter;
import sohan.com.lastfivedaysweather.constants.Constants;
import sohan.com.lastfivedaysweather.dto.ResponseDetailsDto;
import sohan.com.lastfivedaysweather.dto.ResponseDetailsSummaryDto;
import sohan.com.lastfivedaysweather.io.GetDataCallBack;
import sohan.com.lastfivedaysweather.io.PostDataToNetwork;
import sohan.com.lastfivedaysweather.parser.ServiceResponseParser;


public class LastFiveDaysWeatherActivity extends AppCompatActivity{

    private RecyclerView mRecylerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_five_days_weather_list);
        initView();


        getWeatherList();
    }

    private void initView() {
        mRecylerView = (RecyclerView)findViewById(R.id.weatherListRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(LastFiveDaysWeatherActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(manager);
    }

    private void getWeatherList() {
        PostDataToNetwork pdn = new PostDataToNetwork(LastFiveDaysWeatherActivity.this, getString(R.string.loading), new GetDataCallBack() {
            @Override
            public void processResponse(Object result) {
                if (result != null) {
                    TypeToken<ResponseDetailsDto> typeToken = new TypeToken<ResponseDetailsDto>() {};
                    ResponseDetailsDto response = ServiceResponseParser.getResponse(typeToken, result);
                    if (response.getListSummary() != null) {
                        ArrayList<ResponseDetailsSummaryDto> responseObject = response.getListSummary();
                        if (responseObject != null && responseObject.size()>0) {
                            ListAdapter(responseObject);
                        }
                    }
                } else {
                    Toast.makeText(LastFiveDaysWeatherActivity.this, "data not available", Toast.LENGTH_LONG).show();
                }
            }
        });
        try {
            pdn.setConfig(Constants.URL, Constants.PAGE_URL);
            pdn.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ListAdapter(ArrayList<ResponseDetailsSummaryDto> responseObject) {

        WeatherListAdapter ListAdapter = new WeatherListAdapter(LastFiveDaysWeatherActivity.this, responseObject);
        mRecylerView.setAdapter(ListAdapter);
    }
}
