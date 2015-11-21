package com.example.bartosz.projektsii123;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     Muzyka.play(this, R.raw.super_dzwonek_intro);



        }


    @Override
    public  void onPause()
    {
   super.onPause();
        Muzyka.stop(this);
    }


    public void GraGarnki(View v)
    {
        Intent intent = new Intent(this, ZupaActivity.class);
        startActivity(intent);


    }

    public void GraZegar(View v)
    {
        Intent intent = new Intent(this, ZegarActivity.class);
        startActivity(intent);


    }

    }
//Krystian commit



