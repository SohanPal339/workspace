package sohan.com.lastfivedaysweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import sohan.com.lastfivedaysweather.R;
import sohan.com.lastfivedaysweather.dto.ResponseDetailsSummaryDto;


public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder>  {

    private ArrayList<ResponseDetailsSummaryDto> weatherSummary;
    private Context mContext;
    private LayoutInflater mInflater;

    public WeatherListAdapter(Context context, ArrayList<ResponseDetailsSummaryDto> weatherSummary) {
        this.weatherSummary = weatherSummary;
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.weather_list_item, parent, false);
        return new WeatherListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, int position) {
        ResponseDetailsSummaryDto ResponseDetailsSummaryDto = weatherSummary.get(position);
        holder.bind(weatherSummary.get(position));
    }

    @Override
    public int getItemCount() {
        if(weatherSummary != null && weatherSummary.size() > 0){
            return weatherSummary.size();
        } else {
            return 0;
        }
    }

    public class WeatherListViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextMain, mTextDescription, mTextDateTime;

        public WeatherListViewHolder(View view) {
            super(view);

            mTextMain = (TextView) view.findViewById(R.id.textMain);
            mTextDescription = (TextView) view.findViewById(R.id.textDescription);
            mTextDateTime = (TextView) view.findViewById(R.id.textDateTime);
           
        }

        public void bind(final ResponseDetailsSummaryDto ResponseDetailsSummaryDto) {
            if (ResponseDetailsSummaryDto != null) {

                mTextMain.setText(ResponseDetailsSummaryDto.getWeatherSummary().get(0).getMain().trim());
                mTextDescription.setText(ResponseDetailsSummaryDto.getWeatherSummary().get(0).getDescription().trim());
                mTextDateTime.setText(ResponseDetailsSummaryDto.getDateTime());
            }
        }

    }

}
