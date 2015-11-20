package com.example.bartosz.projektsii123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class ZegarActivity extends AppCompatActivity {
    CZegar cZegar;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zegar);



        imageButton = (ImageButton) findViewById(R.id.ibPomocnikZegar);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                checkTimeFromPickers();

            }
        });
    }
    private void getTimeFromPickers( int TimePickerId ) {

        TimePicker tp = (TimePicker) findViewById(TimePickerId);


        int hour    = tp.getHour();
        int minutes = tp.getMinute();
        cZegar.setGodzina(hour);
        cZegar.setMinuta(minutes);


    }
    private void checkTimeFromPickers () {
        int hour = cZegar.getGodzina();
        int minutes = cZegar.getMinuta();
        int hourAsked = cZegar.getGodzinaZapytana();
        int minutesAsked = cZegar.getMinutaZapytana();
        if ( hour == hourAsked && minutes == minutesAsked)
            Toast.makeText(ZegarActivity.this,
                    "Jest godzina: "+hour+"minuta: "+minutes, Toast.LENGTH_LONG).show();
    }

}
