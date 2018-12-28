package com.example.caudeber.newyearapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caudeber.newyearapp.modules.Joueur;
import com.example.caudeber.newyearapp.modules.Roue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RouletteActivity extends AppCompatActivity {


    public static  Intent getStartIntent(final Context ctx){
        return new Intent(ctx,RouletteActivity.class);
    }

    private Button btn;
    private boolean isStarted;
    private Roue wheel1, wheel2, wheel3;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roulette);
        btn = (Button) findViewById(R.id.button);
        TextView listePrenom = findViewById(R.id.listePrenom);
        TextView nbrgorgee = findViewById(R.id.gorgee);
        TextView param = findViewById(R.id.param);
        ArrayList<Joueur> joueurs = MainActivity.listeJoueur;
        ArrayList<Integer> nombresgorgees = new ArrayList<Integer>();
        for (int nbr = 0; nbr<6; nbr++)
        {
            nombresgorgees.add(nbr);
        }
        ArrayList<String> Listparam = new ArrayList<String>();
        Listparam.add("Tu donnes une gorgée !");
        Listparam.add("tu bois !");
        Listparam.add("tu choisis un partenaire pour t'accompagner !");
        Collections.shuffle(Listparam);
        Collections.shuffle(nombresgorgees);
        Collections.shuffle(joueurs);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (isStarted) {
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();
                    isStarted = false;
                    btn.setText("Start");
                } else {

                    wheel1 = new Roue(new Roue.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    listePrenom.setText(joueurs.get(img).prenom);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200), joueurs.size());

                    wheel1.start();

                    wheel2 = new Roue(new Roue.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    nbrgorgee.setText(nombresgorgees.get(img).toString());
                                }
                            });
                        }
                    }, 200, randomLong(150, 400), nombresgorgees.size());

                    wheel2.start();

                    wheel3 = new Roue(new Roue.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    param.setText(Listparam.get(img).toString());
                                }
                            });
                        }
                    }, 200, randomLong(150, 400), 3);

                    wheel3.start();
                    btn.setText("Stop");
                    isStarted = true;
                }
            }
        });
    }
}

