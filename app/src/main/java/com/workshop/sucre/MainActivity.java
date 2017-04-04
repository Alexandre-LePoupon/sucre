package com.workshop.sucre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public ProtocoleDAO protocoleDAO = new ProtocoleDAO(this);
    private EditText lentText;
    private EditText rapideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        //lentText = (EditText) findViewById(R.id.editText);
        //rapideText = (EditText) findViewById(R.id.editText2);
        //Protocole protocole = protocoleDAO.selectionner(1);
        //lentText.setText((int) protocole.getLent());
        //rapideText.setText((int) protocole.getRapide());
    }
    public void accueil (View view){

        //float lent = lent = Float.parseFloat(lentText.getText().toString());
        //float rapide = rapide = Float.parseFloat(rapideText.getText().toString());
        //Protocole protocole = new Protocole(1,lent,rapide);
        //this.modifProtocole(protocole);

        // input names inputSucresLents / inputSucresRapides
        startActivity(new Intent(this, FastFood.class));
    }

    private void modifProtocole(Protocole p) {
        if(protocoleDAO.selectionner(1)!=null) {
            protocoleDAO.ajouter(p);
        } else {
            protocoleDAO.modifier(p);
        }
    }

}
