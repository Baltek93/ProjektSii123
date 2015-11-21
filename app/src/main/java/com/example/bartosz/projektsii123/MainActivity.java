package com.example.bartosz.projektsii123;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Muzyka.play(this, R.raw.intro);
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

    public void GraWybieranie(View v)
    {
        Intent intent = new Intent(this, WybieranieActivity.class);
        startActivity(intent);


    }

    }




