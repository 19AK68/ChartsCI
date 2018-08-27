package com.example.ak.user.chartsci;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.DonutChartCI.DonutChartCI;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static int CHART_FULL_CIRCLE = 1 ;
    public static int CHART_INCOMPLECTE_CIRCLE = 2 ;
    Context context;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float paramOne =100000.0f;
        float param2 =125000.0f;

//        DonutChartCI donutChartCI = new DonutChartCI(context);
//        donutChartCI.initParamChart(paramOne,param2);

    }






}
