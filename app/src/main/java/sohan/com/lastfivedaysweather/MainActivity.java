package sohan.com.lastfivedaysweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLastFiveYears = (Button)findViewById(R.id.btnLastFiveYears);

        btnLastFiveYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LastFiveDaysWeatherActivity.class);
                startActivity(intent);
            }
        });
    }
}
