package com.brihaspathi.org.interestcalculator;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etStartDate;
    EditText etEndDate;

    TextInputLayout startDateSetListener;
    TextInputLayout endDateSetListener;
    private int mYear, mMonth, mDay, mHour, mMinute;

    EditText etName;
    EditText etPrinciple;
    EditText etrate;

    Button btnSubmit;

    private int previousYear, previousMonth, previousDays;
    private int currentYear, currentMonth, currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowCustomEnabled(true);
        }

        etName = findViewById(R.id.et_name);
        etPrinciple = findViewById(R.id.et_principal);
        etrate = findViewById(R.id.et_rate);
        startDateSetListener =findViewById(R.id.startdatelayout);
        endDateSetListener=findViewById(R.id.enddatelayout);
        // ettime = findViewById(R.id.et_time);
        btnSubmit = findViewById(R.id.btn_submit);

        etStartDate =findViewById(R.id.et_Date);
        etEndDate =findViewById(R.id.et_Date2);

        etStartDate.setOnClickListener(this);
        etEndDate.setOnClickListener(this);
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                previousYear = cal.get(Calendar.YEAR);
//                previousMonth = cal.get(Calendar.MONTH);
//                previousDays = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dailog = new DatePickerDialog(
//                        MainActivity.this,
//                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
//                        startDateSetListener,
//                        previousYear,
//                        previousMonth,
//                        previousDays);
//                dailog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dailog.show();
//            }






   //     });


//        startDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                currentMonth = month+1;
//                String date = currentMonth + "/" + dayOfMonth + "/"+year;
//                AppDate appDate = new AppDate(AppDate.MY_DATE, date);
//                etStartDate.setText(appDate.getCalenderDate());
//            }
//        };
//
//        etEndDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal1 = Calendar.getInstance();
//                currentYear = cal1.get(Calendar.YEAR);
//
//                currentMonth = cal1.get(Calendar.MONTH);
//                currentDay = cal1.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog dailog = new DatePickerDialog(
//                        MainActivity.this,
//                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
//                        endDateSetListener,
//                        currentYear,
//                        currentMonth,
//                        currentDay);
//                dailog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dailog.show();
//            }
//        });
//
//
//        endDateSetListener =new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth1) {
//                previousMonth =month1+1;
//                String date12 = previousMonth + "/" + dayOfMonth1 +"/" + year1;
//                AppDate appDate = new AppDate(AppDate.MY_DATE, date12);
//                etEndDate.setText(appDate.getCalenderDate());
//            }
//        };








        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(etPrinciple.getText().toString());
                double rate = Double.parseDouble(etrate.getText().toString());

                String startDate = etStartDate.getText().toString();
                String endDate = etEndDate.getText().toString();
                String name = etName.getText().toString();

                Intent intent = new Intent(MainActivity.this, ResultActitvity.class);
                intent.putExtra("name", name);
                intent.putExtra("principal", principal);
                intent.putExtra("rate", rate);
                intent.putExtra("startDate", startDate);
                intent.putExtra("endDate", endDate);

                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {

        if (view == etStartDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            currentMonth = monthOfYear+1;
                            String date = currentMonth + "/" + dayOfMonth + "/"+year;
                            AppDate appDate = new AppDate(AppDate.MY_DATE, date);
                            etStartDate.setText(appDate.getCalenderDate());

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == etEndDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            currentMonth = monthOfYear+1;
                            String date = currentMonth + "/" + dayOfMonth + "/"+year;
                            AppDate appDate = new AppDate(AppDate.MY_DATE, date);
                            etEndDate.setText(appDate.getCalenderDate());

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }


    }
}
