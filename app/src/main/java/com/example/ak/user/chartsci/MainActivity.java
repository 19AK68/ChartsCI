package com.example.ak.user.chartsci;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.DonutChartCI.DonutChartCI;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float paramOne =100000.0f;
        float param2 =200000.0f;

        int type1ChartCircle = 1;
        int type2ChartCircle = 2;

        float prDrawIIncompleteCircle = 0.30f;


        DonutChartCI donutChart = findViewById(R.id.donutIncomplecteCircle);
        donutChart.setPrDrawCircle(prDrawIIncompleteCircle);

        donutChart.setCHART_INCOMPLECTE_CIRCLE(type1ChartCircle);

        DonutChartCI donutFullCitcle = findViewById(R.id.donutFullCircle);
        donutFullCitcle.setCHART_FULL_CIRCLE(type2ChartCircle);
        donutFullCitcle.setSumMarketVaule(paramOne);
        donutFullCitcle.setSumTotalMortgage(param2);

    }






}
