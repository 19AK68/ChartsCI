package com.example.ak.user.chartsci;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.DonutChartCI.DonutChartCI;

import java.util.ArrayList;

/**
 * Created by Andrey Kushnaryov on 23/08/2018.
 */

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float paramOne =115000.0f;
        float param2 =145000.0f;

        int type1ChartCircle = 1;
        int type2ChartCircle = 2;

        float prDrawIIncompleteCircle =0.98f;




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

        TextView procTotalEquity = (TextView) findViewById(R.id.procTotalEquity);
        int intProcTE = (int)Math.round((param2/paramOne-1)*100);
        String prTotalEquity = String.valueOf( intProcTE);
        String procTotalEquiet = prTotalEquity +  "%";
        procTotalEquity.setText(procTotalEquiet);


        TextView mTotalMortgageSum = (TextView)findViewById(R.id.txtTMSumm);
        int iparamOne = (int)Math.round(paramOne);
        String tvTotalMortgageSum =  " " + "$"+ String.valueOf(iparamOne);
        mTotalMortgageSum.setText(tvTotalMortgageSum);


        TextView mMarketVauleSumm = (TextView)findViewById(R.id.txtMVSumm);
        int iparam2 = (int)Math.round(param2);
        String tvMarketVauleSumm =  " " + "$"+ String.valueOf(iparam2);
        mMarketVauleSumm.setText(tvMarketVauleSumm);


        TextView mTotalEquitySumm = (TextView)findViewById(R.id.txtTESumm);
        int iparamTotalEquitySumm = (int)Math.round(param2-paramOne);
        String tvTotalEquitySumm =  " " + "$"+ String.valueOf(iparamTotalEquitySumm);
        mTotalEquitySumm.setText(tvTotalEquitySumm);





    }






}
