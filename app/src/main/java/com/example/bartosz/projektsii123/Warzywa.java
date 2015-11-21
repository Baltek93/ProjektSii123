package com.example.bartosz.projektsii123;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Bartosz on 20.11.2015.
 */
public abstract class Warzywa {

private ImageView obrazek;
private int index;
    int muzyka;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ImageView getObrazek() {
        return obrazek;
    }

    public void setObrazek(ImageView obrazek) {
        this.obrazek = obrazek;
    }
}
