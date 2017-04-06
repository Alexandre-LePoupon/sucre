package com.workshop.sucre;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;
import com.workshop.sucre.BDD.Protocole;
import com.workshop.sucre.BDD.ProtocoleDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ProtocoleDAO protocoleDAO = new ProtocoleDAO(this);
    private EditText lentText;
    private EditText rapideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        WindowManager manager = (WindowManager) this.getSystemService(Activity.WINDOW_SERVICE);
        int screenWidth = manager.getDefaultDisplay().getWidth();

        findViewById(R.id.inputSucresLents).getLayoutParams().width = (int) (screenWidth * 0.20);
        findViewById(R.id.inputSucresLents).getLayoutParams().height = (int) (screenWidth * 0.06);

        findViewById(R.id.inputSucresRapides).getLayoutParams().width = (int) (screenWidth * 0.20);
        findViewById(R.id.inputSucresRapides).getLayoutParams().height = (int) (screenWidth * 0.06);

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
        if(lentText.getText().toString()!=null&&rapideText.getText().toString()!=null)
        {
            if(lentText.getText().toString().compareTo("")!=0&&rapideText.getText().toString().compareTo("")!=0)
            {
                float lent = lent = Float.parseFloat(lentText.getText().toString());
                float rapide = rapide = Float.parseFloat(rapideText.getText().toString());
                Protocole protocole = new Protocole(1,lent,rapide);
                this.modifProtocole(protocole);
                startActivity(new Intent(this, FastFood.class));
            }
        }
    }

    private void modifProtocole(Protocole p) {
        if(protocoleDAO.selectionner(1)==null) {
            protocoleDAO.ajouter(p);
        } else {
            protocoleDAO.modifier(p);
        }
    }

}
