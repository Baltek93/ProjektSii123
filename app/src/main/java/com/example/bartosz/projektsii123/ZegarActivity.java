package com.example.bartosz.projektsii123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class ZegarActivity extends AppCompatActivity {
    CZegar cZegar = new CZegar();
    TimePicker tp;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zegar);

            setTimeAsHeSays();

            imageButton = (ImageButton) findViewById(R.id.ibPomocnikZegar);

    imageButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
        int firstTime = 0;
            if (firstTime == 0){

                    getTimeFromPickers();
                    checkTimeFromPickers();
                    firstTime = 1 ;




            }
            if (firstTime == 1)
            {
                if (cZegar.getChecker() == 1) {
                    cZegar.setIloscPrzejsc(cZegar.getIloscPrzejsc()+1);
                    setTimeAsHeSays();

                }


                if (cZegar.getChecker() == 0) {
                    getTimeFromPickers();
                    checkTimeFromPickers();

                }


            }






            if (cZegar.getIloscPrzejsc() == 4)
            {
                cZegar.setIloscPrzejsc(0);
                closeMe();
            }
        }
            });



    }
    private void getTimeFromPickers(  ) {

         tp = (TimePicker) findViewById(R.id.tpZegar);
        int hour = 0;
        int minutes = 0;

        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
            hour = tp.getHour();
            minutes = tp.getMinute();
        } else {
            hour = tp.getCurrentHour();
            minutes = tp.getCurrentMinute();
        }
        cZegar.setGodzina(hour);
        cZegar.setMinuta(minutes);


    }

    private void setTimeAsHeSays(){
        int[] hour  = {4 , 5  , 8 , 9 , 10 ,  16   ,  24 };
        int [] minutes = { 15 , 20 , 30 ,  45 , 55 } ;
        int a = 0 ;
        int b = 0 ;
        //

            Random los = new Random();
            a = los.nextInt(7);
            b = los.nextInt(5);
            cZegar.setGodzinaZapytana(hour[a]);
            cZegar.setMinutaZapytana(minutes[b]);

        Toast.makeText(ZegarActivity.this,
                "Ustaw godzinę: "+cZegar.getGodzinaZapytana()+" i minutę: "+cZegar.getMinutaZapytana() +" ", Toast.LENGTH_LONG).show();  ////ADD SOUND HOOORAY, NOW SET...
    }

    private void checkTimeFromPickers () {
        int hour = cZegar.getGodzina();
        int minutes = cZegar.getMinuta();
        int hourAsked = cZegar.getGodzinaZapytana();
        int minutesAsked = cZegar.getMinutaZapytana();
        if ( hour == hourAsked && minutes == minutesAsked)
        {
            Toast.makeText(ZegarActivity.this,"YAAAAY", Toast.LENGTH_LONG).show();
            cZegar.setChecker(1);
        } ////ADD SOUND HOOORAY, NOW SET...
        else {
            Toast.makeText(ZegarActivity.this,"BOOOO", Toast.LENGTH_LONG).show();
            cZegar.setChecker(0);
        }
    }
    private void checkMePlox(){
        cZegar.getChecker();

    }
    private void closeMe(){
        Intent intent = new Intent(ZegarActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
