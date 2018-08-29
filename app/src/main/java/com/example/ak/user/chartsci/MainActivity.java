package com.example.ak.user.chartsci;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.DonutChartCI.DonutChartCI;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float paramOne =175000.0f;
        float param2 =250000.0f;

        int type1ChartCircle = 1;
        int type2ChartCircle = 2;

        float prDrawIIncompleteCircle =0.97f;




        DonutChartCI donutChart = findViewById(R.id.donutIncomplecteCircle);
        donutChart.setPrDrawCircle(prDrawIIncompleteCircle);
        donutChart.setCHART_INCOMPLECTE_CIRCLE(type1ChartCircle);

        TextView prCondifinece = (TextView) findViewById(R.id.tvTotalEquietProc);
        int intProc = (int)Math.round(prDrawIIncompleteCircle*100);
        String proc =  String.valueOf(intProc);

        String procCondifinece =  proc +"%";
        prCondifinece.setText(procCondifinece);


        DonutChartCI donutFullCitcle = findViewById(R.id.donutFullCircle);
        donutFullCitcle.setCHART_FULL_CIRCLE(type2ChartCircle);
        donutFullCitcle.setSumMarketVaule(param2);
        donutFullCitcle.setSumTotalMortgage(paramOne);

        TextView tvTotalEquity = (TextView) findViewById(R.id.tvTotalEquity);
        int intProcTE = (int)Math.round((param2/paramOne-1)*100);
        String prTotalEquity = String.valueOf( intProcTE);
        String procTotalEquiet = "Total Equity:"+ " "+ prTotalEquity +  " %";
        tvTotalEquity.setText(procTotalEquiet);

        TextView mTotalMortgage = (TextView)findViewById(R.id.txtTM);
        int iparamOne = (int)Math.round(paramOne);
        String tvTotalMortgage = "Total Mortgage:" + "\n" + " " + "$"+ String.valueOf(iparamOne);
        mTotalMortgage.setText(tvTotalMortgage);

        TextView mMarketVaule = (TextView)findViewById(R.id.txtMV);
        int iparam2 = (int)Math.round(param2);
        String tvMarketVaule = "Market Vaule:" + "\n" + " " + "$"+ String.valueOf(iparam2);
        mMarketVaule.setText(tvMarketVaule);






    }






}
