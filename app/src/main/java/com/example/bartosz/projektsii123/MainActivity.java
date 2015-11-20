package com.example.bartosz.projektsii123;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
/*
LKJALKSJDLKJASlkdjalskjdlkajsdlkajsdklasjldkjaslkdjlkadsjlkjdalksjdlkajWISLA PANY

 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        }
    public void GraGarnki(View v)
    {
        Intent intent = new Intent(this, ZupaActivity.class);
        startActivity(intent);


    }
    }
//Krystian commit



