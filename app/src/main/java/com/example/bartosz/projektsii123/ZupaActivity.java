package com.example.bartosz.projektsii123;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ZupaActivity extends Activity implements View.OnTouchListener {
    ArrayList<Warzywa> warzywa;
    Random random;
    ImageView garnek;
    int tura;
    float garnekx,garneky;
    float x, y ;
    boolean moving;
    int warzywo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zupa);
        moving = false;
        x=y=0.0f;
        warzywa = new ArrayList<Warzywa>();
        warzywa.add( new Groszek());
        warzywa.add( new Cebula());
        warzywa.add( new Marchewka());
        warzywa.add( new Pomidor());
        random = new Random();
        warzywo= random.nextInt(warzywa.size());
garnek= (ImageView)findViewById(R.id.imageView_zupa_garnek);
        warzywa.get(0).setObrazek((ImageView) findViewById(R.id.imageViewGroszek));
        warzywa.get(1).setObrazek((ImageView) findViewById(R.id.imageView_zupa_cebula));
        warzywa.get(2).setObrazek((ImageView) findViewById(R.id.imageViewMarchewka));
        warzywa.get(3).setObrazek((ImageView) findViewById(R.id.imageViewPomidor));
        for (int i=0;i<4;i++)
        {
            warzywa.get(i).getObrazek().setX(i*200+100);
            warzywa.get(i).getObrazek().setY(300);


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
if(warzywa.size()==0)

{
    if(tura==1)
    {
        Log.d("Wygrales", "hehe");
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
        warzywa.get(1).setObrazek((ImageView) findViewById(R.id.pietruszka_zupa));
        warzywa.get(2).setObrazek((ImageView)findViewById(R.id.ziemniaki_zupa));

for (Warzywa x:warzywa)
    x.getObrazek().setVisibility(View.VISIBLE);

        for (int i=0;i<3;i++) {


            warzywa.get(i).getObrazek().setX(i * 300 + 100);
            warzywa.get(i).getObrazek().setY(200);
            warzywa.get(i).getObrazek().setMaxHeight(150);
            warzywa.get(i).getObrazek().setMaxWidth(150);
            Log.d("Dgddfg", "Cracovia");
            warzywo= random.nextInt(warzywa.size());
            Log.d("FDSSg", String.valueOf(warzywo));

            warzywa.get(warzywo).getObrazek().setOnTouchListener(this);

        }
    }

}
    else
{
    warzywo= random.nextInt(warzywa.size());
    Log.d("FDSSg", String.valueOf(warzywo));

    warzywa.get(warzywo).getObrazek().setOnTouchListener(this);
    moving=false;
}




    }
}

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
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

