package com.workshop.sucre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.workshop.sucre.BDD.Categorie;
import com.workshop.sucre.BDD.CategorieDAO;
import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;

import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_down_black_24dp;
import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_up_black_24dp;

public class Produits extends AppCompatActivity{


    TextView txt_help_gest;
    ScrollView scrool_view1;
    ImageButton imgbutton1;
    GridLayout extendMenu1;

    CategorieDAO categorieDAO  = new CategorieDAO(this);
    ProduitDAO produitDAO = new ProduitDAO(this);


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_produits);

        categorieDAO.open();
        produitDAO.open();

        if(categorieDAO.selectionner(1) == null) {
            Categorie burger = new Categorie(1, "Burger", 1, "mcdo_nos_sandwichs");

            categorieDAO.ajouter(burger);
        }

        if(produitDAO.selectionner(1) == null) {
            Produit bigMac = new Produit(1, "BigMac", 1, 42, (float) 8.5, "mcdo_big_mac");
            Produit royalBacon = new Produit(2, "RoyalBacon", 1, 34, 8, "mcdo_royal_bacon");
            Produit royalCheese = new Produit(3, "RoyalCheese", 1, 37, (float) 9.5, "mcdo_royal_cheese");

            produitDAO.ajouter(bigMac);
            produitDAO.ajouter(royalBacon);
            produitDAO.ajouter(royalCheese);
        }

        txt_help_gest = (TextView) findViewById(R.id.txt_help_gest);
        imgbutton1 = (ImageButton) findViewById(R.id.imageButton17);
        //extendMenu1 = (GridLayout) findViewById(R.id.extendMenu);
        scrool_view1 = (ScrollView) findViewById(R.id.scrollView1);
        // hide until its title is clicked
        txt_help_gest.setVisibility(View.GONE);
    }

    /**
     * onClick handler
     */
    public void toggle_contents(View v){
        //int startHeight = 0;
        //if(startHeight == 0) {
        //  startHeight = scrool_view1.getHeight();
        //}

        //txt_help_gest.setVisibility( txt_help_gest.isShown()
        //        ? View.GONE
        //        : View.VISIBLE );

        if(txt_help_gest.isShown()){
            scrool_view1.getLayoutParams().height = 1000;
            imgbutton1.setImageResource(ic_keyboard_arrow_up_black_24dp);
            //Fx.slide_up(this, extendMenu1);
            txt_help_gest.setVisibility(View.GONE);
        }
        else{
            scrool_view1.getLayoutParams().height = 120;
            imgbutton1.setImageResource(ic_keyboard_arrow_down_black_24dp);
            txt_help_gest.setVisibility(View.VISIBLE);
            //Fx.slide_down(this, extendMenu1);
        }
    }

    public void changeViewData(View v)
    {
        ScrollView ly=(ScrollView)findViewById(R.id.layoutViewUpDown);
        if(ly.getVisibility()==View.GONE){
            imgbutton1.setImageResource(ic_keyboard_arrow_up_black_24dp);
            ly.setVisibility(View.VISIBLE);
        }
        else
        {
            imgbutton1.setImageResource(ic_keyboard_arrow_down_black_24dp);
            ly.setVisibility(View.GONE);
        }
    }

}
