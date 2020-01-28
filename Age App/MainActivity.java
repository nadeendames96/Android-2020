package com.nadeen.ageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{
    EditText myYear,myMonth,myDay;
    TextView temyAge;
    //TextView date;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myYear=findViewById(R.id.yob);
        myMonth=findViewById(R.id.mob);
        myDay=findViewById(R.id.dob);
       temyAge=findViewById(R.id.textViewAge);
    /*date=findViewById(R.id.textViewTime);
        Calendar calendar=Calendar.getInstance();
        date.setText("Current Date And Time Are: "+String.valueOf(calendar.getTime()));*/
    }

    @SuppressLint("SetTextI18n")
    public void CalculateAge(View view) {
     int year_parse= Integer.parseInt(myYear.getText().toString());
     int month_parse=Integer.parseInt(myMonth.getText().toString());
     int day_parse=Integer.parseInt(myDay.getText().toString());
     int year=Calendar.getInstance().get(Calendar.YEAR);
     int month=Calendar.getInstance().get(Calendar.MONTH)+1;
    int day_od_month=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int cal_year;
    int cal_month;
     int cal_day;
     if(day_od_month<day_parse) {
         day_od_month += 10;
         month -= 1;
         if (month < month_parse) {
             month += 10;
             year -= 1;
             cal_year = year - year_parse;
             cal_month = month - month_parse;
             cal_day = day_od_month - day_parse;
             temyAge.setText(temyAge.getText() + " " + Math.abs(cal_year) + " Years ," + " " + (cal_month) +
                     " Months ," + (cal_day) + " Days");


         } else {
             cal_year = year - year_parse;
             cal_month = month - month_parse;
             cal_day = day_od_month - day_parse;
             temyAge.setText(temyAge.getText() + " " + Math.abs(cal_year) + " Years ," + " " + (cal_month) +
                     " Months ," + (cal_day) + " Days");

         }
     }
     else if(month<month_parse){
         month+=10;
         year-=1;
         cal_year=year-year_parse;
         cal_month=month-month_parse;
         cal_day=day_od_month-day_parse;
         temyAge.setText(temyAge.getText()+" "+Math.abs(cal_year)+" Years ,"+" "+cal_month+" Months ,"+cal_day+" Days");
     }
     else{
         cal_year=year-year_parse;
         cal_month=month-month_parse;
         cal_day=day_od_month-day_parse;
         temyAge.setText(temyAge.getText()+" "+Math.abs(cal_year)+" Years ,"+" "+cal_month+" Months ,"+cal_day+" Days");

     }



    }
}
