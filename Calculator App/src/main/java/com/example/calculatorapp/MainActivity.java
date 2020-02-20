package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 EditText number1,number2;
   TextView equlas;
   Button sum,sub,multi,div,mode;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      number1=findViewById(R.id.number1);
      number2=findViewById(R.id.number2);
      equlas=findViewById(R.id.equlas);
      sum=findViewById(R.id.sum);
       sub=findViewById(R.id.sub);
       multi=findViewById(R.id.multi);
       div=findViewById(R.id.div);
       mode=findViewById(R.id.mode);

       sum.setOnClickListener(this);
       sub.setOnClickListener(this);
       multi.setOnClickListener(this);
       div.setOnClickListener(this);
       mode.setOnClickListener(this);

   }

    @Override
    public void onClick(View v) {
        int numberone=Integer.parseInt(number1.getText().toString());
        int numbertwo=Integer.parseInt(number2.getText().toString());
        int res;
        switch (v.getId()){
           case R.id.sum:
           {
               res=numberone+numbertwo;
               equlas.setText(equlas.getText()+"\n"+"Sum Is :"+res);
           }
           break;
            case R.id.sub:
            {
                res=numberone-numbertwo;
                equlas.setText(equlas.getText()+"\n"+"Sub Is :"+res);
            }
            break;
            case R.id.multi:
            {
                res=numberone*numbertwo;
                equlas.setText(equlas.getText()+"\n"+"Multi Is :"+res);
            }
            break;
            case R.id.div:
            {
                res=numberone/numbertwo;
                equlas.setText(equlas.getText()+"\n"+"Div Is :"+res);
            }
            break;
            case R.id.mode:
            {
                res=numberone%numbertwo;
                equlas.setText(equlas.getText()+"\n"+"Mode Is :"+res);
            }
            break;
            default:
            {
                equlas.setText("0");
            }
        }
    }
}
