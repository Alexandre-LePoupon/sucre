package com.workshop.sucre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.workshop.sucre.BDD.Categorie;
import com.workshop.sucre.BDD.CategorieDAO;
import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;
import com.workshop.sucre.BDD.ProtocoleDAO;

import java.util.ArrayList;

import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_down_black_24dp;
import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_up_black_24dp;

public class Produits extends AppCompatActivity {


    TextView txt_help_gest;
    ScrollView scrool_view1;
    ImageButton button_view_data;
    GridLayout extendMenu1;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> al = new ArrayList<>();
    GridView gridview;

    TextView sucresLents, sucresRapides;
    float valueActuelR = 0, valueActuelL = 0;

    CategorieDAO categorieDAO = new CategorieDAO(this);
    ProduitDAO produitDAO = new ProduitDAO(this);
    ProtocoleDAO protocolDAO = new ProtocoleDAO(this);

    /*****************************************************************
     * 7
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! id a incrément pour les catégories
     *******************************************************************/
    int categorieId = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);

        /**
         * ouverture des tables
         */
        categorieDAO.open();
        produitDAO.open();
        protocolDAO.open();


        /**
         * ajout des catégories dans la base de données
         */
        if (categorieDAO.selectionner(1) == null) {

            Categorie sandwichs = new Categorie(1, "Sandwichs", 1, "mcdo_nos_sandwichs");
            Categorie boissons = new Categorie(2, "Boissons", 1, "mcdo_nos_boissons");
            Categorie frites = new Categorie(3, "Frites", 1, "mcdo_frites");
            Categorie desserts = new Categorie(4, "Desserts", 1, "mcdo_nos_desserts");

            categorieDAO.ajouter(sandwichs);
            categorieDAO.ajouter(boissons);
            categorieDAO.ajouter(frites);
            categorieDAO.ajouter(desserts);
        }

        if (produitDAO.selectionner(1) == null) {
            Produit bigMac = new Produit(1, "BigMac", 1, 42, (float) 8.5, "mcdo_big_mac", 0, 1);
            Produit royalBacon = new Produit(2, "RoyalBacon", 1, 34, 8, "mcdo_royal_bacon", 0, 1);
            Produit royalCheese = new Produit(3, "RoyalCheese", 1, 37, (float) 9.5, "mcdo_royal_cheese", 0, 1);
            Produit royalDeluxe = new Produit(4, "RoyalDeluxe", 1, 33, 7, "mcdo_royal_deluxe", 0, 1);
            Produit tripleCheese = new Produit(5, "TripleCheese", 1, 32, 8, "mcdo_triple_cheese", 0, 1);
            Produit premium = new Produit(6, "Premium", 1, 56, 13, "mcdo_premiumpoulet", 0, 1);
            Produit mcwrapPoulet = new Produit(7, "McwrapPoulet", 1, 53, 4, "mcdo_mcwrap_poulet_bacon", 0, 1);
            Produit mcCoca = new Produit(8, "Coca", 2, 27, 27, "mcdo_coca", 0, 1);
            Produit mcFrite = new Produit(9, "Frite", 3, 29, (float) 0.2, "mcdo_frites", 0, 1);
            Produit mcFirstb = new Produit(10, "McFirstBoeuf", 1, 32, (float) 6.2, "mcdo_mcfirstboeuf", 0, 1);
            Produit mcFirstp = new Produit(11, "McFirstPoisson", 1, 43, 7, "mcdo_mcfirstpoisson", 0, 1);
            Produit mcFlurry = new Produit(12, "McFlurry", 4, 50, 50, "mcdo_mcflurry", 0, 1);
            Produit mcwrapChevre = new Produit(13, "McwrapChevre", 1, 58, 4, "mcdo_mcwrap_chevre", 0, 1);

            //passage à kfc

            Produit boxMaster = new Produit(14, "BoxMaster", 5, 59, 1, "kfc_boxmaster", 0, 2);
            Produit brazer = new Produit(15, "Brazer", 5, 37, 7, "kfc_brazer", 0, 2);
            Produit doubleSweatFire = new Produit(16, "DoubleSweatFire", 5, (float) 51.6, 0, "kfc_double_sweatandfire", 0, 2);
            Produit kfcFrite = new Produit(17, "Frite", 6, 35, 1, "kfc_frites", 0, 2);
            Produit kreamBall = new Produit(18, "KreamBall", 7, 50, 50, "kfc_ kreamball", 0, 2);
            Produit mixBucket = new Produit(19, "MixBucket", 5, (float) 22.5, 0, "kfc_mixbucket", 0, 2);
            Produit saladeBrazer = new Produit(20, "SaladeBrazer", 8, (float) 5.5, 0, "kfc_salde_brazer", 0, 2);
            Produit saladeCrispy = new Produit(21, "SaladeCrispy", 8, (float) 8.9, 0, "kfc_salade_crispy", 0, 2);
            Produit tenders = new Produit(22, "Tenders", 5, 26, (float) 0.1, "kfc_tenders", 0, 2);
            Produit theBoss = new Produit(23, "TheBoss", 5, (float) 41.7, 0, "kfc_theboss", 0, 2);

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

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 1));

        /**
         * initialisation de la grid view + ajout de l'adaptateur +++ list view
         */
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 1));

        listView = (ListView) findViewById(R.id.listViewData);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, al);
        listView.setAdapter(adapter);


        /**
         * Ajout du listener
         */
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                /**
                 * ajout du produit a la list. Si il y est déja -> + 1
                 *
                 */
                Produit temp1 = ((ImageAdapter) gridview.getAdapter()).getProduct((int) position);


                for (int j = 0; j < produitDAO.getSize(); j++) {
                    if (produitDAO.selectionner(j + 1).getNom().compareTo(temp1.getNom()) == 0) {
                        Produit temp =produitDAO.selectionner(j+1);
                        if (temp.getQuantite() == 0) {
                            Toast.makeText(Produits.this, temp.getNom() + " ajouté.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Produits.this, temp.getNom() + ": X " + (temp.getQuantite() + 1),
                                    Toast.LENGTH_SHORT).show();
                        }

                        temp.setQuantite(temp.getQuantite() + 1);
                        produitDAO.modifier(temp);
                        actualiseProduitToList();
                    }
                }


            }
        });


        /**
         *  Add item dataList one clic
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                itemValue = itemValue.split(" ")[0];  // récupération de nom uniquement
                int j;
                if(itemValue.compareTo("Reset")==0)
                {
                    for(j=0;j<produitDAO.getSize();j++)
                    {
                        Produit temp = produitDAO.selectionner(j + 1);
                        temp.setQuantite(0);
                        produitDAO.modifier(temp);
                    }
                    actualiseProduitToList();
                }
                else
                    for (j = 0; j < produitDAO.getSize(); j++) {
                        Produit temp = produitDAO.selectionner(j + 1);
                        if (itemValue.compareTo(temp.getNom()) == 0) {
                            temp.setQuantite(temp.getQuantite() + 1);
                            produitDAO.modifier(temp);
                            actualiseProduitToList();
                        }
                    }
            }
        });

        /**
         * récupération des variables xml
         */


        button_view_data = (ImageButton) findViewById(R.id.button_view_data);
        //extendMenu1 = (GridLayout) findViewById(R.id.extendMenu);
        // hide until its title is clicked
        findViewById(R.id.layoutViewUpDown).setVisibility(View.GONE);

        sucresLents = (TextView) findViewById(R.id.sucresLentsData);
        sucresRapides = (TextView) findViewById(R.id.sucresRapidesData);


        // actualise des valeurs affiché
        changeSucres(0, 0);
        actualiseProduitToList();
    }



    /**
     * permet le changement de vue
     *
     * @param v
     */
    public void changeViewData(View v) {
        ScrollView ly = (ScrollView) findViewById(R.id.layoutViewUpDown);
        if (ly.getVisibility() == View.GONE) {
            button_view_data.setImageResource(ic_keyboard_arrow_up_black_24dp);
            ly.setVisibility(View.VISIBLE);
            findViewById(R.id.listViewData).getLayoutParams().height = 300;
        } else {
            button_view_data.setImageResource(ic_keyboard_arrow_down_black_24dp);
            ly.setVisibility(View.GONE);
            findViewById(R.id.listViewData).getLayoutParams().height = 0;
        }
    }

    /**
     * fonctions d'ajout de sucres
     */
    public void setSucresValues() {
        sucresLents.setText(valueActuelL + " / " + protocolDAO.selectionner(1).getLent() + "g");
        sucresRapides.setText(valueActuelR + " / " + protocolDAO.selectionner(1).getRapide() + "g");

        if (valueActuelL >= protocolDAO.selectionner(1).getLent()){
            ImageView img1 = (ImageView)findViewById(R.id.img1);

            img1.setVisibility(View.VISIBLE);
        }
        else {
            ImageView img1 = (ImageView)findViewById(R.id.img1);

            img1.setVisibility(View.INVISIBLE);
        }

        if (valueActuelR >= protocolDAO.selectionner(1).getRapide()){
            ImageView img2 = (ImageView)findViewById(R.id.img2);

            img2.setVisibility(View.VISIBLE);
        }
        else {
            ImageView img2 = (ImageView)findViewById(R.id.img2);

            img2.setVisibility(View.INVISIBLE);
        }
    }

    private void addSucresRapides(float value) {
        valueActuelR += value;
    }

    private void addSucresLents(float value) {
        valueActuelL += value;
    }

    public void changeSucres(float rapide, float lent) {
        addSucresLents(lent);
        addSucresRapides(rapide);
        setSucresValues();
    }

    public void actualiseProduitToList() {
        int j;
        adapter.clear();
        valueActuelR = 0;
        valueActuelL = 0;

        for (j = 1; j <= produitDAO.getSize(); j++) {
            Produit temp = produitDAO.selectionner(j);
            if (temp.getQuantite() > 0) {
                adapter.add(temp.getNom() + " X" + temp.getQuantite());
                valueActuelR += (temp.getSucre() * temp.getQuantite());
                valueActuelL += ((temp.getGlucide() - temp.getSucre()) * temp.getQuantite());
            }
        }
        setSucresValues();
        adapter.add("Reset");
    }


    public void onClicBoutonCategorie1 (View view){
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 1));
    }

    public void onClicBoutonCategorie2(View view) {
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 2));
    }

    public void onClicBoutonCategorie3(View view) {
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 3));
    }

    public void onClicBoutonCategorie4(View view) {
        gridview.setAdapter(new ImageAdapter(this, produitDAO, 4));
    }
}