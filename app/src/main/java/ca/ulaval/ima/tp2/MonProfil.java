package ca.ulaval.ima.tp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MonProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Profil profil = getIntent().getExtras().getParcelable("myProfil");
    TextView displayProfile = (TextView) findViewById(R.id.profilTextView);
        displayProfile.setText(" Prénom : " + profil.prenom +
            "\n" + " Nom : " + profil.nom +
            "\n" + " Date de naissance : " + profil.dateNaissance +
            "\n" + " Sexe : " + profil.sexe +
            "\n" + " Departement : " + profil.departement);
}
}