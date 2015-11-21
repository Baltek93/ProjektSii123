package com.example.bartosz.projektsii123;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Muzyka.play(getApplicationContext(), R.raw.intro);
            }
        }, 1000);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
