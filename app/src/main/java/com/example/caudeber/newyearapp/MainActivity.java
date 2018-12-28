package com.example.caudeber.newyearapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.caudeber.newyearapp.modules.Joueur;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Joueur> listeJoueur = new ArrayList<>();
    public ImageButton btAdd;
    public EditText ajoutJoueur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView btStart = findViewById(R.id.btStart);
        btAdd = findViewById(R.id.add);

        ajoutJoueur = findViewById(R.id.textJoueurs);

        btStart.setOnClickListener(this::onClick);

        btAdd.setOnClickListener(this::onClickAdd);
    }



    private void onClick(View v){
        startActivity(RouletteActivity.getStartIntent(this));



    }

    private void onClickAdd(View v){

        listeJoueur.add(new Joueur(ajoutJoueur.getText().toString()));
        ajoutJoueur.setText("");

    }

}
