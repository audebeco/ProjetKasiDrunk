package com.example.caudeber.newyearapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btStart = findViewById(R.id.btStart);
        btStart.setOnClickListener(this::onClick);
    }



    private void onClick(View v){
        startActivity(RouletteActivity.getStartIntent(this));
    }
}
