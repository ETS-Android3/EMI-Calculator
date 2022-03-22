package com.aditya.monthlyemi;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import  java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tV_amt, tV_rate,tV_time;
    private TextView display_emi,display_rate,display_time,display_amount;
    private EditText eT_amt, eT_rate, eT_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        tV_amt=findViewById(R.id.tV_amt);
        tV_rate=findViewById(R.id.tV_rate);
        tV_time=findViewById(R.id.tV_time);

        eT_amt=findViewById(R.id.eT_amt);
        eT_rate=findViewById(R.id.eT_rate);
        eT_time=findViewById(R.id.eT_time);

        display_amount=findViewById(R.id.display_amount);
        display_rate=findViewById(R.id.display_rate);
        display_emi=findViewById(R.id.display_emi);

        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                String amount= eT_amt.getText().toString();
                String rate= eT_rate.getText().toString();
                String time= eT_time.getText().toString();

                if(amount.length() == 0 || rate.length() == 0 || time.length() == 0   ){
                    Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                 else{
                     double a=Double.parseDouble(amount);
                     double r=Double.parseDouble(rate);
                     double rat= r/12/100;
                     double t=Double.parseDouble(time);
                     int n= (int) (t*12);


                    double emi=(a* rat* Math.pow((1+rat),n))/(Math.pow(1+rat,n)-1);
                    int emiR= (int) Math.round(emi);
                    int total=(int) Math.round(emi*n);
                    int interest= (int)Math.round((emi*n)-a);

                    display_emi.setText("EMI:  ₹ "+emiR);
                    display_amount.setText("Total Amount:  ₹ "+ total);
                    display_rate.setText("Interest Payable:  ₹ "+interest );

                }
            }
        });
    }
}