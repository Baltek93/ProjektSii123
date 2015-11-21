package com.example.bartosz.projektsii123;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class WybieranieActivity extends AppCompatActivity {
    private int currNum, currLosNum, wybImg, wynik;

    //tablica poprawnych odpowiedzi dla poszczególnych plansz
    private int[] ktoryWlasciwy = {
            R.mipmap.z1_trojkat,
            R.mipmap.z2_czerwony,
            R.mipmap.z3_truskawki,
            R.mipmap.z4_wisnie,
            R.mipmap.z5_1,
            R.mipmap.z6_a,
            R.mipmap.z7_kot
    };

    //tablica wszystkich zestawów obrazków
    private int[][] obrazki = {
            {R.mipmap.z1_kwadrat, R.mipmap.z1_romb, R.mipmap.z1_trojkat},
            {R.mipmap.z2_czerwony, R.mipmap.z2_zielony1, R.mipmap.z2_zielony2},
            {R.mipmap.z3_banan, R.mipmap.z3_cytryna, R.mipmap.z3_truskawki},
            {R.mipmap.z4_ogorek, R.mipmap.z4_wisnie, R.mipmap.z4_ziemniak},
            {R.mipmap.z5_1, R.mipmap.z5_a, R.mipmap.z5_b},
            {R.mipmap.z6_1, R.mipmap.z6_2, R.mipmap.z6_a},
            {R.mipmap.z7_kot, R.mipmap.z7_pies1, R.mipmap.z7_pies2}
    };

    ImageView img1, img2, img3;
    TextView tv;

    private String successMessage = "Brawo! Znajdowanie niepasujących elementów nie stanowi dla Ciebie żadnego problemu!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybieranie);
        Muzyka.play(this, R.raw.wybieranie_intro);
        //zmienne typu ImageView
        img1 = (ImageView)findViewById(R.id.wybImg1);
        img2 = (ImageView)findViewById(R.id.wybImg2);
        img3 = (ImageView)findViewById(R.id.wybImg3);

        //zmienna typu TextView
        //tv = (TextView)findViewById(R.id.textView);

        wynik = 0;

        losujKat();
       // ustawWynik();
    }

    //losowanie zestawu obrazków
    private void losujKat() {
        Random rand = new Random();
        currNum = rand.nextInt(ktoryWlasciwy.length); //los 0 do liczba_plansz-1 , liczba różnych "plansz"
        currLosNum = rand.nextInt(3); //los 0-2, przesunięcie obrazka na planszy

        przypiszObrazek();
    }

    /*//ustawianie wyniku od wyświetlenia w TextView
    private void ustawWynik() {
        tv.setText("Brakuje Ci jeszcze " + (10-wynik) + " punktów do zaliczenia poziomu.");
    }*/

    //sprawdzanie, czy wybrany obrazek jest dobry
    public void czyDobraOdp(View v) {
        switch (v.getId())
        {
            case R.id.wybImg1:
                wybImg = obrazki[currNum][(0+currLosNum)%3];
                break;
            case R.id.wybImg2:
                wybImg = obrazki[currNum][(1+currLosNum)%3];
                break;
            case R.id.wybImg3:
                wybImg = obrazki[currNum][(2+currLosNum)%3];
                break;
            default:
                break;
        }

        //zliczanie punktów
        if(ktoryWlasciwy[currNum] == wybImg){
            losujKat();
            wynik++;
           // ustawWynik();
        }

        //koniec gry, sukces
        if (wynik == 10) {

            //kod powrotu do głównej aktywności
            //jest opóźnienie 2s
            //why?!
            Intent intent = new Intent(WybieranieActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    //przypisywanie obrazków do poszczególnych ImageView
    private void przypiszObrazek () {
        img1.setImageResource(obrazki[currNum][(0+currLosNum)%3]);
        img2.setImageResource(obrazki[currNum][(1+currLosNum)%3]);
        img3.setImageResource(obrazki[currNum][(2+currLosNum)%3]);
    }

    public  void onPause()
    {
        super.onPause();
        Muzyka.stop(this);
    }

}
