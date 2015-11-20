package com.example.bartosz.projektsii123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ruszaniebuttonem extends AppCompatActivity implements View.OnTouchListener {
    Button marchewka,koszyk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruszaniebuttonem);
        marchewka= (Button) findViewById(R.id.Marchewka);
        koszyk= (Button) findViewById(R.id.Koszyk);
        marchewka.setOnTouchListener(this);

    }
    float x,y=0.0f;
    boolean moving=false;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if(moving){
                    x=motionEvent.getRawX()-marchewka.getWidth()/2;
                    y=motionEvent.getRawY()-marchewka.getHeight()*2;
                    marchewka.setX(x);
                    marchewka.setY(y);
                    Log.d("blasd", String.valueOf(y));
                    Log.d("blassadfdsd",String.valueOf(marchewka.getY()));

                }
                break;
            case MotionEvent.ACTION_UP:
                moving=false;
                break;
        }
        return true;
    }
}
