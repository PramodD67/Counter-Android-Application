package com.pramod.counterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public int i= 0;
    public  Timer timer = new Timer();
    public TimerTask tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbtn = (Button) findViewById(R.id.start_btn);
        Button stopbtn = (Button) findViewById(R.id.stop_btn);
        TextView countertext = (TextView) findViewById(R.id.counter_txt);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             tt = new TimerTask() {
                 @Override
                 public void run() {
                     i++;
                     countertext.setText(String.valueOf(i));

                 }
             }; timer.scheduleAtFixedRate(tt,0,1000);


             startbtn.setEnabled(false);
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tt.cancel();
                startbtn.setEnabled(true);
                i=0;

            }
        });


    }


}