package fr.be2.monapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class fraisexceptionnels extends menuprincipal {
    SQLHelper bdd;
    EditText libelle;
    EditText montant;
    Button btnAjouter  ;
    EditText MaDate;
    EditText Description;
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aaaa = calendrier.get(Calendar.YEAR);
    int mm = calendrier.get(Calendar.MONTH);
    int jj = calendrier.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraisexceptionnels);
        init();
        bdd = new SQLHelper (this);
    }

    private void init() {
        libelle= findViewById(R.id.libelle);
        montant= findViewById(R.id.montant);
        btnAjouter= findViewById(R.id.btnAjouter);
        MaDate= findViewById(R.id.Date);
        Description= findViewById(R.id.descriptionSaisie);
    }
    public void ShowCal(View v)
    {
        picker = new DatePickerDialog (fraisexceptionnels.this ,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        MaDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },aaaa, mm, jj );
        picker.show(); }

    public void clique_btn6 (View view){
        finish();

    }
    public void afficherMessage(String titre,String message){
        AlertDialog.Builder Builder=new AlertDialog.Builder(this ) ;
        Builder.setCancelable(true);
        Builder.setTitle(titre);
        Builder.setMessage(message);
        Builder.show();

    }

    public void clique_retour(View view) {
        finish();
    }

    public void MonClick(View v ) {
        switch (v.getId()) {
            case R.id.btnAjouter:

                if (montant.getText().toString().length() < 5000) {
                    afficherMessage("Erreur !", "Votre frais n'est pas un frais exceptionnel ");
                    return;


                }
        }
    }
}
