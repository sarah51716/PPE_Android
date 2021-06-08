package fr.be2.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }

    public void unclique(View view) {

        if (view.getId() == R.id.connect) {
            Intent intent = new Intent(getApplicationContext(), menuprincipal.class);
            startActivity(intent);
        }
    }
}
