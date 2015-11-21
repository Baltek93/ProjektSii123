package com.example.bartosz.projektsii123;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



import java.util.ArrayList;
import java.util.Random;

public class ZupaActivity extends Activity implements View.OnTouchListener {
    ArrayList<Warzywa> warzywa;
    Random random;
    ImageView garnek,smok;
    int tura;
    float garnekx,garneky;
    float x, y ;
    boolean moving;
    int warzywo;
    DisplayMetrics displaymetrics ;
    Animation anim;
    int height ;
    int width ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_zupa);
        Muzyka.play(this, R.raw.zupa_intro);
        smok=(ImageView)findViewById(R.id.Pomocnik123);
        anim= AnimationUtils.loadAnimation(this, R.anim.animate);
        smok.startAnimation(anim);
        displaymetrics= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width= displaymetrics.widthPixels;
        height= displaymetrics.heightPixels;
        moving = false;
        x=y=0.0f;
        warzywa = new ArrayList<Warzywa>();
        warzywa.add( new Groszek());
        warzywa.add( new Cebula());
        warzywa.add( new Marchewka());
        warzywa.add( new Pomidor());
        random = new Random();
        warzywo= 3;
garnek= (ImageView)findViewById(R.id.imageView_zupa_garnek);
        warzywa.get(0).setObrazek((ImageView) findViewById(R.id.imageViewGroszek));
        warzywa.get(0).muzyka=R.raw.zupa_groszek;
        warzywa.get(1).setObrazek((ImageView) findViewById(R.id.imageView_zupa_cebula));
        warzywa.get(1).muzyka=R.raw.zupa_cebula;
        warzywa.get(2).setObrazek((ImageView) findViewById(R.id.imageViewMarchewka));
        warzywa.get(2).muzyka=R.raw.zupa_marchewka;
        warzywa.get(3).setObrazek((ImageView) findViewById(R.id.imageViewPomidor));
        warzywa.get(3).muzyka=R.raw.zupa_pomidor;
        for (int i=0;i<4;i++)
        {
            warzywa.get(i).getObrazek().setX(i*height/4+100);
            warzywa.get(i).getObrazek().setY(width/4);


        }
        warzywa.get(warzywo).getObrazek().setOnTouchListener(this);
        garnekx=garnek.getX();
        garneky=garnek.getY();
         tura=0;



    }
private void Zderzenie(int wa)
{
    if(garnekx > warzywa.get(wa).getObrazek().getX()-50 && garnekx< warzywa.get(wa).getObrazek().getX()+50)
    {
    }

 if(garneky > warzywa.get(wa).getObrazek().getY()-50 && garneky< warzywa.get(wa).getObrazek().getY()+50)
    {

        warzywa.get(wa).getObrazek().setVisibility(View.GONE);
warzywa.remove(wa);
        moving=false;
if(warzywa.size()==0)

{
    if(tura==1)
    {
        startActivity(new Intent(this,MainActivity.class));
        moving=false;
    }

    if(tura==0)
    {
        tura++;
        for (int i=0;i<3;i++)
        {
            warzywa.add(new Pomidor());

        }
        warzywa.get(0).setObrazek((ImageView)findViewById(R.id.papryka_zupa));
        warzywa.get(0).muzyka=R.raw.zupa_papryka;
        warzywa.get(1).setObrazek((ImageView) findViewById(R.id.pietruszka_zupa));
        warzywa.get(1).muzyka=R.raw.zupa_pietruszka;
        warzywa.get(2).setObrazek((ImageView) findViewById(R.id.ziemniaki_zupa));
        warzywa.get(2).muzyka=R.raw.zupa_ziemniak;

for (Warzywa x:warzywa)
    x.getObrazek().setVisibility(View.VISIBLE);

        for (int i=0;i<3;i++) {


            warzywa.get(i).getObrazek().setX(i * height/4 + 100);
            warzywa.get(i).getObrazek().setY(width / 4);
            warzywa.get(i).getObrazek().setMaxHeight(150);
            warzywa.get(i).getObrazek().setMaxWidth(150);
            warzywo= random.nextInt(warzywa.size());

            Muzyka.play(this, warzywa.get(warzywo).muzyka);

            warzywa.get(warzywo).getObrazek().setOnTouchListener(this);

        }
    }

}
    else
{
    warzywo= random.nextInt(warzywa.size());
    Log.d("FDSSg", String.valueOf(warzywo));

    warzywa.get(warzywo).getObrazek().setOnTouchListener(this);
    Muzyka.play(this, warzywa.get(warzywo).muzyka);
    moving=false;
}




    }
}
    @Override
    public  void onPause()
    {
        super.onPause();
        Muzyka.stop(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
//        if(warunek){
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Muzyka.play(this, warzywa.get(warzywo).muzyka);
//        warunek = false;
//        }
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if(moving){
                    x=motionEvent.getRawX()-warzywa.get(warzywo).getObrazek().getWidth()/2;
                    y=motionEvent.getRawY()-warzywa.get(warzywo).getObrazek().getHeight();
                    warzywa.get(warzywo).getObrazek().setX(x);
                    warzywa.get(warzywo).getObrazek().setY(y);
                    Zderzenie(warzywo);

                }
                break;
            case MotionEvent.ACTION_UP:
                moving=false;
                break;
        }
        return true;
    }
}

