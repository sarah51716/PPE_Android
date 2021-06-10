package fr.be2.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class parametre extends AppCompatActivity {

    //constructeur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
    }
    public void clique_retour (View view){
        finish();
    }
}
