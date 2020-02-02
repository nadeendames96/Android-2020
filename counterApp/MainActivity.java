package com.nadeen.counterimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    TextView tView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        tView = findViewById(R.id.counter);
        tView.setText(String.valueOf(count));

              for (int i=0;i<=10;i++){
                  if(i%2==0&&i==2){
                      count+=2;
                      tView.setText(String.valueOf(count));
                      img.setImageResource(android.R.color.white);
                  }
                  if(i%2==0&&i==4){
                      count+=2;
                      tView.setText(String.valueOf(count));
                      img.setImageResource(android.R.color.holo_red_dark);
                  }
                  if(i%2==0&&i==6){
                      count+=2;
                      tView.setText(String.valueOf(count));
                      img.setImageResource(android.R.color.holo_green_dark);
                  }
                  if(i%2==0&&i==8){
                      count+=2;
                      tView.setText(String.valueOf(count));
                      img.setImageResource(android.R.color.black);
                  }
                  if(i%2==0&&i==10){
                      count+=2;
                      tView.setText(String.valueOf(count));
                      img.setImageResource(android.R.color.darker_gray);
                  }
              }


    }
}
