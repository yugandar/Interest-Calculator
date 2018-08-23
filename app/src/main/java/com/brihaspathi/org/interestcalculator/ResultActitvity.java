package com.brihaspathi.org.interestcalculator;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.text.DecimalFormat;


public class ResultActitvity extends AppCompatActivity {
    TextView tvResult;
    TextView tvResultName;
    TextView tvResultDays;
    TextView tvResultMonths;
    TextView tvResultYears;
    TextView tvDayInterest;
    TextView tvMonthInterest;
    TextView tvYearInterest;
    TextView tvTotal;

    double rate;
    double principal;
    String name;
    String startDate;
    String endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_actitvity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initView();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            readBundle(bundle);
        }
        else {
            finish();
        }
    }

    private void readBundle(Bundle bundle) {

        name = bundle.getString("name");
        startDate = bundle.getString("startDate");
        endDate = bundle.getString("endDate");
        principal = bundle.getDouble("principal");
        rate = bundle.getDouble("rate");


        onDisplay();
    }

    private void onDisplay() {

        AppDate appStartDate = new AppDate(AppDate.CUSTOM_DATE, startDate);
        AppDate appEndDate = new AppDate(AppDate.CUSTOM_DATE, endDate);

        int currentYear, currentMonth, currentDay;
        int previousMonth, previousYear, previousDays;

        //starting dates
        previousYear = Integer.parseInt(appStartDate.getYear());
        previousMonth = Integer.parseInt(appStartDate.getMonth());
        previousDays = Integer.parseInt(appStartDate.getCalenderDay());

        //end dates
        currentYear = Integer.parseInt(appEndDate.getYear());
        currentMonth = Integer.parseInt(appEndDate.getMonth());
        currentDay = Integer.parseInt(appEndDate.getCalenderDay());

//        Double totalDays = (currentYear - previousYear);
//        Double totalYears = (totalDays / 365);
//        Double totalMonths = (totalDays / 30);

        int days = 0;
        int months = 0;
        int countYears = 0;

        //Count Number of days
        if (currentDay >= previousDays)
        {
            days = (currentDay - previousDays);
        }
        else if (currentDay < previousDays)
        {
            days = ((currentDay) + (30 - previousDays));
        }
        // else{
        //      days = 0;
        //  }

        //Count Number of Months
        if ((currentMonth >= previousMonth) && (currentDay >= previousDays))
        {
            months = (currentMonth - previousMonth);
        }
        else if ((currentMonth > previousMonth) && (currentDay < previousDays))
        {
            months = ((currentMonth - previousMonth) - (1));

        }
        else if ((currentMonth == previousMonth) && (currentDay < previousDays))
        {
            months = ((12-1));

        }
        else if ((currentMonth < previousMonth) && (currentDay >= previousDays))
        {
            months = (currentMonth +(12- previousMonth));
        }
        else if ((currentMonth < previousMonth) && (currentDay < previousDays))
        {
            months = (currentMonth-1)+(12-previousMonth);
        }


        //Count Number of Years
        if ((currentYear > previousYear) && (currentMonth >= previousMonth) && (currentDay >= previousDays))
        {
            countYears = (currentYear - previousYear);

        }
        else if ((currentYear > previousYear) && (currentMonth >= previousMonth) && (currentDay < previousDays))
        {
            countYears = (currentYear - previousYear)-1;

        }
        else if (currentYear == previousYear)
        {
            countYears = (currentYear - previousYear);
        }
        else if ((currentYear > previousYear) && (currentMonth < previousMonth))
        {
            countYears = (currentYear - previousYear)-1;
        }


        tvResultDays.setText(String.valueOf(days));
        tvResultMonths.setText(String.valueOf(months));
        tvResultYears.setText(String.valueOf(countYears));


        //Interest
        double oneMonthInterest,oneYearInterest,oneDayInterest,totalDaysOfInterest,totalIntrest,totalMoney,totalMonthOfInterest,totalYearOfinterest;

        oneMonthInterest = principal * rate *0.01;

        totalMonthOfInterest = oneMonthInterest *  months;

        tvMonthInterest.setText(String.valueOf(Math.round(oneMonthInterest)));

        oneYearInterest= principal * rate * 0.01 * 12;

        totalYearOfinterest = oneYearInterest * countYears;

        tvYearInterest.setText(String.valueOf(Math.round(oneYearInterest)));

        //calculating month interest day
        oneDayInterest = oneMonthInterest/30;

        totalDaysOfInterest = days*oneDayInterest;



        tvDayInterest.setText(new DecimalFormat("##.##").format(oneDayInterest));


        //adding total  interest
        totalIntrest = totalMonthOfInterest + totalYearOfinterest + totalDaysOfInterest;
        tvResult.setText(String.valueOf(Math.round(totalIntrest)));

        //adding total intrest plus principal
        totalMoney = totalIntrest+principal;


        tvTotal.setText(String.valueOf(Math.round(totalMoney)));



        tvResultName.setText(String.valueOf(name));
    }
    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }


    private void initView() {
        tvResult = findViewById(R.id.tv_result);
        tvTotal=findViewById(R.id.tv_resultTotal);
        tvResultName =findViewById(R.id.tv_resultname);
        tvResultDays =findViewById(R.id.tv_resultdays);
        tvResultMonths =findViewById(R.id.tv_resultmonths);
        tvDayInterest =findViewById(R.id.tv_dayintrest);
        tvMonthInterest =findViewById(R.id.tv_monthintrest);
        tvYearInterest =findViewById(R.id.tv_yearintrest);
        tvResultYears =findViewById(R.id.tv_resultyears);
    }
}
