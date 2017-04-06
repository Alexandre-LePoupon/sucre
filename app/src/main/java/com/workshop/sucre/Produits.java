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
            Produit bigMac = new Produit(1, "BigMac", 1, 42, (float) 8.5, "mcdo_big_mac",0);
            Produit royalBacon = new Produit(2, "RoyalBacon", 1, 34, 8, "mcdo_royal_bacon",0);
            Produit royalCheese = new Produit(3, "RoyalCheese", 1, 37, (float) 9.5, "mcdo_royal_cheese",0);
            Produit royalDeluxe = new Produit(4, "RoyalDeluxe", 1, 33, 7, "mcdo_royal_deluxe",0);
            Produit tripleCheese = new Produit(5, "TripleCheese", 1, 32, 8, "mcdo_triple_cheese",0);
            Produit premium = new Produit(6, "Premium", 1, 56, 13, "mcdo_premiumpoulet",0);
            Produit mcwrapPoulet = new Produit(7, "McwrapPoulet", 1, 53, 4, "mcdo_mcwrap_poulet_bacon",0);
            Produit mcCoca = new Produit(8, "McCoca", 2, 27, 27, "mcdo_coca",0);
            Produit mcFrite = new Produit(9, "McFrite", 3, 29, (float) 0.2, "mcdo_frites",0);
            Produit mcFirstb = new Produit(10, "McFirstb", 1, 32, (float) 6.2, "mcdo_mcfirstboeuf",0);
            Produit mcFirstp = new Produit(11, "Mcfirstp", 1, 43, 7, "mcdo_mcfirstpoisson",0);
            Produit mcFlurry = new Produit(12, "McFlurry", 4, 50, 50, "mcdo_mcflurry",0);
            Produit mcwrapChevre = new Produit(13, "McwrapChevre", 1, 58, 4, "mcdo_mcwrap_chevre",0);

            //passage à kfc

            Produit boxMaster = new Produit(14, "BoxMaster", 5, 59, 1, "kfc_boxmaster",0);
            Produit brazer = new Produit(15, "Brazer", 5, 37, 7, "kfc_brazer",0);
            Produit doubleSweatFire = new Produit(16, "DoubleSweatFire", 5, (float) 51.6, 0, "kfc_double_sweatandfire",0);
            Produit kfcFrite = new Produit(17, "KfcFrite", 6, 35, 1, "kfc_frites",0);
            Produit kreamBall = new Produit(18, "KreamBall", 7, 50, 50, "kfc_ kreamball",0);
            Produit mixBucket = new Produit(19, "MixBucket", 5, (float) 22.5, 0, "kfc_mixbucket",0);
            Produit saladeBrazer = new Produit(20, "SaladeBrazer", 8, (float) 5.5, 0, "kfc_salde_brazer",0);
            Produit saladeCrispy = new Produit(21, "SaladeCrispy", 8, (float) 8.9, 0, "kfc_salade_crispy",0);
            Produit tenders = new Produit(22, "Tenders", 5, 26, (float) 0.1, "kfc_tenders",0);
            Produit theBoss = new Produit(23, "TheBoss", 5, (float) 41.7, 0, "kfc_theboss",0);

            //DAO mcdo
            produitDAO.ajouter(bigMac);
            produitDAO.ajouter(royalBacon);
            produitDAO.ajouter(royalCheese);
            produitDAO.ajouter(royalDeluxe);
            produitDAO.ajouter(tripleCheese);
            produitDAO.ajouter(premium);
            produitDAO.ajouter(mcwrapPoulet);
            produitDAO.ajouter(mcCoca);
            produitDAO.ajouter(mcFrite);
            produitDAO.ajouter(mcFirstb);
            produitDAO.ajouter(mcFirstp);
            produitDAO.ajouter(mcFlurry);
            produitDAO.ajouter(mcwrapChevre);

            // DAO kfc
            produitDAO.ajouter(boxMaster);
            produitDAO.ajouter(brazer);
            produitDAO.ajouter(doubleSweatFire);
            produitDAO.ajouter(kfcFrite);
            produitDAO.ajouter(kreamBall);
            produitDAO.ajouter(mixBucket);
            produitDAO.ajouter(saladeBrazer);
            produitDAO.ajouter(saladeCrispy);
            produitDAO.ajouter(tenders);
            produitDAO.ajouter(theBoss);

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


        button_view_data = (ImageButton) findViewById(R.id.button_view_data);
        //extendMenu1 = (GridLayout) findViewById(R.id.extendMenu);
        // hide until its title is clicked
        findViewById(R.id.layoutViewUpDown).setVisibility(View.GONE);

        sucresLents=(TextView) findViewById(R.id.sucresLentsData);
        sucresRapides=(TextView) findViewById(R.id.sucresRapidesData);


        // actualise des valeurs affiché
        setSucresValues();
    }



    /**
     * permet le changement de vue
     * @param v
     */
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

    /**
     * fonctions d'ajout de sucres
     */
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
