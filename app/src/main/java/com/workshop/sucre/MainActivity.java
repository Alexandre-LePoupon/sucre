package com.workshop.sucre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.workshop.sucre.BDD.Protocole;
import com.workshop.sucre.BDD.ProtocoleDAO;

public class MainActivity extends AppCompatActivity {

    public ProtocoleDAO protocoleDAO = new ProtocoleDAO(this);
    private EditText lentText;
    private EditText rapideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        protocoleDAO.open();

        //protocoleDAO.supprimer(1);
        //Recupere les champs de selection
        lentText = (EditText) findViewById(R.id.inputSucresLents);
        rapideText = (EditText) findViewById(R.id.inputSucresRapides);

        //Si un protocole a déjà été rentré complete les champs
        Protocole protocole = protocoleDAO.selectionner(1);
        if(protocole != null){
            lentText.setText(String.valueOf(protocole.getLent()));
            rapideText.setText(String.valueOf(protocole.getRapide()));
        }
    }
    public void accueil (View view){

        //Mofifie ou ajoute un protocole lors du clic sur valider
        float lent = lent = Float.parseFloat(lentText.getText().toString());
        float rapide = rapide = Float.parseFloat(rapideText.getText().toString());
        Protocole protocole = new Protocole(1,lent,rapide);
        this.modifProtocole(protocole);

        startActivity(new Intent(this, FastFood.class));
    }

    private void modifProtocole(Protocole p) {
        if(protocoleDAO.selectionner(1)==null) {
            protocoleDAO.ajouter(p);
        } else {
            protocoleDAO.modifier(p);
        }
    }

}
