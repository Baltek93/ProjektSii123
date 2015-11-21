package com.example.bartosz.projektsii123;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Anula on 2015-11-21.
 */
public class Muzyka {
    private static MediaPlayer mp = null;

    public static void play(Context context, int zasob)
    {
        stop(context);
        mp = MediaPlayer.create(context, zasob);
        mp.setLooping(false);
        mp.start();

    }

    public static void stop(Context context){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}
