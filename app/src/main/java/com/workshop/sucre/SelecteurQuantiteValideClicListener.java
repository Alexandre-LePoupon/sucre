package com.workshop.sucre;

import android.app.Dialog;
import android.view.View;
import android.widget.SeekBar;

import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;

/**
 * Created by Dany CORBINEAU on 06/04/2017.
 */

public class SelecteurQuantiteValideClicListener implements View.OnClickListener {
    Produit temp;
    ProduitDAO pdao;
    Dialog dialog;
    Produits pr;
    SeekBar sb;
    public SelecteurQuantiteValideClicListener(Produit p,ProduitDAO pdao,Dialog dialog,Produits pr, SeekBar sb)
    {
        temp=p;
        this.pdao=pdao;
        this.dialog=dialog;
        this.pr=pr;
        this.sb=sb;
    }

    public void onClick(View v) {
        temp.setQuantite(((float)sb.getProgress())/4);
        pdao.modifier(temp);
        pr.actualiseProduitToList();
        dialog.dismiss();
    }
}
