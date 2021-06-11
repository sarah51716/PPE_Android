
package fr.be2.monapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class menuprincipal extends AppCompatActivity {

    private int titre;
    private int message;
    private Object String;

    //constructeur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
    }

    /**
     * fonction permettant d'acceder a la page souhaitee en fonction du bouton
     */

    public void unclique(View view) {

        if (view.getId() == R.id.btnfraisforfait) {
            Intent intent = new Intent(getApplicationContext(), fraisauforfait.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnfraishorsforfait) {
            Intent intent = new Intent(getApplicationContext(), fraishorsforfait.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnsynthese) {
            Intent intent = new Intent(getApplicationContext(), synthesedumois.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnenvoi) {
            Intent intent = new Intent(getApplicationContext(), envoidesdonneesvers.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnfraisexc) {
            Intent intent = new Intent(getApplicationContext(), fraisexceptionnels.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnparametres) {
            Intent intent = new Intent(getApplicationContext(), parametre.class);
            startActivity(intent);
        }

    }
}