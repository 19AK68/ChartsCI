package com.example.ak.user.chartsci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.DonutChartCI.DonutChartCI;

public class MainActivity extends AppCompatActivity {
    public DonutChartCI donutChartCI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutChartCI = (DonutChartCI) findViewById(R.id.donutChartCI);

        donutChartCI.startAnimateLoading();

    }
}
