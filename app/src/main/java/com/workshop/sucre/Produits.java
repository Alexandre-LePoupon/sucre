package com.workshop.sucre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.workshop.sucre.BDD.Categorie;
import com.workshop.sucre.BDD.CategorieDAO;
import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;
import com.workshop.sucre.BDD.ProtocoleDAO;

import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_down_black_24dp;
import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_up_black_24dp;

public class Produits extends AppCompatActivity{


    TextView txt_help_gest;
    ScrollView scrool_view1;
    ImageButton button_view_data;
    GridLayout extendMenu1;

    TextView sucresLents,sucresRapides;
    float valueActuelR=0,valueActuelL=0;

    CategorieDAO categorieDAO  = new CategorieDAO(this);
    ProduitDAO produitDAO = new ProduitDAO(this);
    ProtocoleDAO protocolDAO = new ProtocoleDAO(this);


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_produits);

        categorieDAO.open();
        produitDAO.open();
        protocolDAO.open();

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

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, produitDAO));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Produits.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


        txt_help_gest = (TextView) findViewById(R.id.txt_help_gest);
        button_view_data = (ImageButton) findViewById(R.id.button_view_data);
        //extendMenu1 = (GridLayout) findViewById(R.id.extendMenu);
        scrool_view1 = (ScrollView) findViewById(R.id.scrollView1);
        // hide until its title is clicked
        findViewById(R.id.layoutViewUpDown).setVisibility(View.GONE);

        sucresLents=(TextView) findViewById(R.id.sucresLentsData);
        sucresRapides=(TextView) findViewById(R.id.sucresRapidesData);


        // actualise des valeurs affiché
        setSucresValues();
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
            button_view_data.setImageResource(ic_keyboard_arrow_up_black_24dp);
            //Fx.slide_up(this, extendMenu1);
            txt_help_gest.setVisibility(View.GONE);
        }
        else{
            scrool_view1.getLayoutParams().height = 120;
            button_view_data.setImageResource(ic_keyboard_arrow_down_black_24dp);
            txt_help_gest.setVisibility(View.VISIBLE);
            //Fx.slide_down(this, extendMenu1);
        }
    }

    public void changeViewData(View v)
    {
        ScrollView ly=(ScrollView)findViewById(R.id.layoutViewUpDown);
        if(ly.getVisibility()==View.GONE){
            button_view_data.setImageResource(ic_keyboard_arrow_up_black_24dp);
            ly.setVisibility(View.VISIBLE);
        }
        else
        {
            button_view_data.setImageResource(ic_keyboard_arrow_down_black_24dp);
            ly.setVisibility(View.GONE);
        }
    }

    public void setSucresValues()
    {
        sucresLents.setText(valueActuelL+" / "+protocolDAO.selectionner(1).getLent()+"g");
        sucresRapides.setText(valueActuelR+" / "+protocolDAO.selectionner(1).getRapide()+"g");
    }
    private void addSucresRapides(float value)
    {
        valueActuelR+=value;
    }
    private void addSucresLents(float value)
    {
        valueActuelL+=value;
    }
    public void changeSucres(float rapide,float lent)
    {
        addSucresLents(lent);
        addSucresRapides(rapide);
        setSucresValues();
    }
}
