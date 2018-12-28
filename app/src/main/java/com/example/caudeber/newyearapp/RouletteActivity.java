package com.example.caudeber.newyearapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RouletteActivity extends AppCompatActivity {


    public static  Intent getStartIntent(final Context ctx){
        return new Intent(ctx,RouletteActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roulette);
    }

}
