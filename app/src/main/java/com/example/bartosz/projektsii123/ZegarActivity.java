package com.example.bartosz.projektsii123;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class ZegarActivity extends Activity {
    CZegar cZegar = new CZegar();

    TimePicker tp;

    ImageButton smok;
    Animation animation;

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_zegar);

        smok=(ImageButton)findViewById(R.id.ibPomocnikZegar);
        animation= AnimationUtils.loadAnimation(this, R.anim.animate);
        smok.startAnimation(animation);

        TimePicker tpHourMin = (TimePicker) findViewById(R.id.tpZegar);
        tpHourMin.setIs24HourView(true);
            setTimeAsHeSays();
        cZegar.setPierwszyRaz(1);
            imageButton = (ImageButton) findViewById(R.id.ibPomocnikZegar);

    imageButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            int firstTime = 0;
            if (firstTime == 0) {

                getTimeFromPickers();
                checkTimeFromPickers();
                firstTime = 1;


            }
            if (firstTime == 1) {
                if (cZegar.getChecker() == 1) {
                    cZegar.setIloscPrzejsc(cZegar.getIloscPrzejsc() + 1);
                    setTimeAsHeSays();

                }


                if (cZegar.getChecker() == 0) {
                    getTimeFromPickers();
                    checkTimeFromPickers();

                }


            }


            if (cZegar.getIloscPrzejsc() == 4) {
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
        int a = 0;
        int b = 0 ;
        //

            Random los = new Random();
            a = los.nextInt(7);
            b = los.nextInt(5);
            cZegar.setGodzinaZapytana(hour[a]);
            cZegar.setMinutaZapytana(minutes[b]);

        /////////////////////////////////// DZWIEKI ODWTARZANIE
        if ((a == 0) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_czwarta_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_czwarta_dwadziescia);}
        if ((a == 0) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_czwarta_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_czwarta_trzydziesci);}
        if ((a == 0) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_czwarta_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_czwarta_pietnascie);}
        if ((a == 0) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_czwarta_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_czwarta_czterdziesci_piec);}
        if ((a == 0) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_czwarta_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_czwarta_piecdziesiat_piec);}
        if ((a == 1) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_piata_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_piata_pietnascie);}
        if ((a == 1) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_piata_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_piata_dwadziescia);}
        if ((a == 1) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_piata_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_piata_trzydziesci);}
        if ((a == 1) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_piata_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_piata_czterdziesci_piec);}
        if ((a == 1) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_piata_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_piata_piecdziesiat_piec);}
        if ((a == 2) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_osma_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_osma_pietnascie);}
        if ((a == 2) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_osma_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_osma_dwadziescia);}
        if ((a == 2) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_osma_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_osma_trzydziesci);}
        if ((a == 2) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_osma_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_osma_czterdziesci_piec);}
        if ((a == 2) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_osma_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_osma_piecdziesiat_piec);}
        if ((a == 3) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_dziewiata_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_dziewiata_pietnascie);}
        if ((a == 3) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_dziewiata_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_dziewiata_dwadziescia);}
        if ((a == 3) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_dziewiata_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_dziewiata_trzydziesci);}
        if ((a == 3) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_dziewiata_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_dziewiata_czterdziesci_piec);}
        if ((a == 3) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_dziewiata_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_dziewiata_piecdziesiat_piec);}
        if ((a == 4) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_dziesiata_piatnascie); cZegar.setDzwiekZegar(R.raw.godzina_dziesiata_piatnascie);}
        if ((a == 4) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_dziesiata_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_dziesiata_dwadziescia);}
        if ((a == 4) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_dziesiata_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_dziesiata_trzydziesci);}
        if ((a == 4) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_dziesiata_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_dziesiata_czterdziesci_piec);}
        if ((a == 4) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_dziesiata_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_dziesiata_piecdziesiat_piec);}
        if ((a == 5) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_szesnasta_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_szesnasta_pietnascie);}
        if ((a == 5) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_szesnasta_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_szesnasta_dwadziescia);}
        if ((a == 5) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_szesnasta_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_szesnasta_trzydziesci);}
        if ((a == 5) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_szesnasta_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_szesnasta_czterdziesci_piec);}
        if ((a == 5) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_szesnasta_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_szesnasta_piecdziesiat_piec);}
        if ((a == 6) && (b == 0) ) {Muzyka.play(this, R.raw.godzina_dwudziesta_czwarta_pietnascie); cZegar.setDzwiekZegar(R.raw.godzina_dwudziesta_czwarta_pietnascie);}
        if ((a == 6) && (b == 1) ) {Muzyka.play(this, R.raw.godzina_dwudziesta_czwarta_dwadziescia); cZegar.setDzwiekZegar(R.raw.godzina_dwudziesta_czwarta_dwadziescia);}
        if ((a == 6) && (b == 2) ) {Muzyka.play(this, R.raw.godzina_dwudziesta_czwarta_trzydziesci); cZegar.setDzwiekZegar(R.raw.godzina_dwudziesta_czwarta_trzydziesci);}
        if ((a == 6) && (b == 3) ) {Muzyka.play(this, R.raw.godzina_dwudziesta_czwarta_czterdziesci_piec); cZegar.setDzwiekZegar(R.raw.godzina_dwudziesta_czwarta_czterdziesci_piec);}
        if ((a == 6) && (b == 4) ) {Muzyka.play(this, R.raw.godzina_dwudziesta_czwarta_piecdziesiat_piec); cZegar.setDzwiekZegar(R.raw.godzina_dwudziesta_czwarta_piecdziesiat_piec);}






        ////////////////////////   KONIEC DZWIEKI ODWTARZANIE
       /* Toast.makeText(ZegarActivity.this,
                "Ustaw godzinę: "+cZegar.getGodzinaZapytana()+" i minutę: "+cZegar.getMinutaZapytana() +" ", Toast.LENGTH_LONG).show();*/  ////ADD SOUND HOOORAY, NOW SET...
    }

    private void checkTimeFromPickers () {
        int hour = cZegar.getGodzina();
        int minutes = cZegar.getMinuta();
        int hourAsked = cZegar.getGodzinaZapytana();
        int minutesAsked = cZegar.getMinutaZapytana();
        if ( hour == hourAsked && minutes == minutesAsked)
        {

            cZegar.setChecker(1);
        } ////ADD SOUND HOOORAY, NOW SET...
        else {
            Muzyka.play(this, R.raw.blad);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Muzyka.play(getApplicationContext(), cZegar.getDzwiekZegar());
                }
            }, 2000);




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
