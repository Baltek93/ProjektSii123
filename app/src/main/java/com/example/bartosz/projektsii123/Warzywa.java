package com.example.bartosz.projektsii123;

import android.widget.ImageView;

/**
 * Created by Bartosz on 20.11.2015.
 */
public abstract class Warzywa {
    public abstract  void rusz();
    private ImageView obraz;

    public ImageView getObraz() {
        return obraz;
    }

    public void setObraz(ImageView obraz) {
        this.obraz = obraz;
    }
}
