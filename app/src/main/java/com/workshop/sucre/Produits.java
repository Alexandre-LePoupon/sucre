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

            Categorie mcdo_sandwichs = new Categorie(1, "Sandwichs", 1, "mcdo_nos_sandwichs");
            Categorie mcdo_frites = new Categorie(2, "Frites", 1, "mcdo_frites_sauces");
            Categorie mcdo_boissons = new Categorie(3, "Boissons", 1, "mcdo_nos_boissons");
            Categorie mcdo_desserts = new Categorie(4, "Desserts", 1, "mcdo_nos_desserts");

            categorieDAO.ajouter(mcdo_sandwichs);
            categorieDAO.ajouter(mcdo_frites);
            categorieDAO.ajouter(mcdo_boissons);
            categorieDAO.ajouter(mcdo_desserts);


            Categorie kfc_sandwichs = new Categorie(5, "Sandwichs", 2, "kfc_nos_sandwichs");
            Categorie kfc_menu_enfant = new Categorie(6, "Enfant", 2, "kfc_menu_enfant");
            Categorie kfc_boissons = new Categorie(7, "Boissons", 2, "kfc_nos_boissons");
            Categorie kfc_desserts = new Categorie(8, "Desserts", 2, "kfc_nos_desserts");

            categorieDAO.ajouter(kfc_sandwichs);
            categorieDAO.ajouter(kfc_menu_enfant);
            categorieDAO.ajouter(kfc_boissons);
            categorieDAO.ajouter(kfc_desserts);
        }

        if (produitDAO.selectionner(1) == null) {

            /*-------------------------------- McDo --------------------------------------------------------------------------------*/

            /*--------------------------- mcdo_Sandwichs ---------------------------------------------------------------------------*/

            Produit bigMac = new Produit(1, "BigMac", 1, 42, (float) 8.5, "mcdo_big_mac", 0, 1);
            Produit royalBacon = new Produit(2, "RoyalBacon", 1, 34, 8, "mcdo_royal_bacon", 0, 1);
            Produit royalCheese = new Produit(3, "RoyalCheese", 1, 37, (float) 9.5, "mcdo_royal_cheese", 0, 1);
            Produit royalDeluxe = new Produit(4, "RoyalDeluxe", 1, 33, 7, "mcdo_royal_deluxe", 0, 1);
            Produit tripleCheese = new Produit(5, "TripleCheese", 1, 32, 8, "mcdo_triple_cheese", 0, 1);
            Produit premium = new Produit(6, "Premium", 1, 56, 13, "mcdo_premiumpoulet", 0, 1);
            Produit mcwrapPoulet = new Produit(8, "McwrapPoulet", 1, 53, 4, "mcdo_mcwrap_poulet_bacon", 0, 1);
            Produit mcFirstb = new Produit(9, "McFirstBoeuf", 1, 32, (float) 6.2, "mcdo_mcfirstboeuf", 0, 1);
            Produit mcFirstp = new Produit(10, "McFirstPoisson", 1, 43, 7, "mcdo_mcfirstpoisson", 0, 1);
            Produit mcwrapChevre = new Produit(11, "McwrapChevre", 1, 58, 4, "mcdo_mcwrap_chevre", 0, 1);


            /*--------------------------- mcdo_frites ------------------------------------------------------------------------------*/
            Produit barbecue = new Produit(12, "barbecue", 2, 27, 27, "barbecue", 0, 1);
            Produit grande_deluxe = new Produit(13, "GrandeDeluxePotatoes", 2, 27, 27, "grande_deluxe", 0, 1);
            Produit grande_frite = new Produit(14, "GrandeFrite", 2, 27, 27, "grande_frite", 0, 1);
            Produit ketchup = new Produit(15, "Ketchup", 2, 27, 27, "ketchup", 0, 1);
            Produit moutarde = new Produit(16, "Moutarde", 2, 27, 27, "moutarde", 0, 1);
            Produit moy_deluxe = new Produit(17, "MoyennePotatoes", 2, 27, 27, "moy_deluxe", 0, 1);
            Produit moy_frite = new Produit(18, "MoyenneFrite", 2, 27, 27, "moy_frite", 0, 1);
            Produit sauce_chinoise = new Produit(19, "SauceChinoise", 2, 27, 27, "sauce_chinoise", 0, 1);
            Produit sauce_curry = new Produit(20, "SauceCurry", 2, 27, 27, "sauce_curry", 0, 1);
            Produit sauce_deluxe = new Produit(21, "SauceDeluxe", 2, 27, 27, "sauce_deluxe", 0, 1);


            /*--------------------------- mcdo_boissons ----------------------------------------------------------------------------*/

            Produit mcdo_coca = new Produit(22, "CocaCola", 3, 27, 27, "mcdo_coca", 0, 1);
            Produit mcdo_cocalight = new Produit(23, "CocaColaLight", 3, 27, 27, "mcdo_cocalight", 0, 1);
            Produit mcdo_cocazero = new Produit(24, "CocaColaZero", 3, 27, 27, "mcdo_cocazero", 0, 1);
            Produit mcdo_evian = new Produit(25, "Evian", 3, 27, 27, "mcdo_evian", 0, 1);
            Produit mcdo_fanta = new Produit(26, "Fanta", 3, 27, 27, "mcdo_fanta", 0, 1);
            Produit mcdo_icetea = new Produit(27, "IceTea", 3, 27, 27, "mcdo_icetea", 0, 1);
            Produit mcdo_sprite = new Produit(28, "Sprite", 3, 27, 27, "mcdo_sprite", 0, 1);
            Produit mcdo_spritezero = new Produit(29, "SpriteZero", 3, 27, 27, "mcdo_spritezero", 0, 1);


            /*--------------------------- mcdo_desserts ----------------------------------------------------------------------------*/

            Produit ananas = new Produit(30, "Ananas", 4, 27, 27, "ananas", 0, 1);
            Produit frappe = new Produit(31, "Frappe", 4, 27, 27, "frappe", 0, 1);
            Produit mc_fleury = new Produit(32, "McFlurry", 4, 27, 27, "mc_fleurry", 0, 1);
            Produit patisseries = new Produit(33, "Patisseries", 4, 27, 27, "patisseries", 0, 1);
            Produit very_parfait = new Produit(34, "VeryParfait", 4, 27, 27, "very_parfait", 0, 1);




            /*--------------------------------- KFC --------------------------------------------------------------------------------*/


            /*--------------------------- kfc_sandwichs ----------------------------------------------------------------------------*/

            Produit boxMaster = new Produit(35, "BoxMaster", 5, 59, 1, "kfc_boxmaster", 0, 2);
            Produit brazer = new Produit(36, "Brazer", 5, 37, 7, "kfc_brazer", 0, 2);
            Produit doubleSweatFire = new Produit(37, "DoubleSweatFire", 5, (float) 51.6, 0, "kfc_double_sweatandfire", 0, 2);
            Produit mixBucket = new Produit(38, "MixBucket", 5, (float) 22.5, 0, "kfc_mixbucket", 0, 2);
            Produit saladeBrazer = new Produit(39, "SaladeBrazer", 5, (float) 5.5, 0, "kfc_salde_brazer", 0, 2);
            Produit saladeCrispy = new Produit(40, "SaladeCrispy", 5, (float) 8.9, 0, "kfc_salade_crispy", 0, 2);
            Produit tenders = new Produit(41, "Tenders", 5, 26, (float) 0.1, "kfc_tenders", 0, 2);
            Produit theBoss = new Produit(42, "TheBoss", 5, (float) 41.7, 0, "kfc_theboss", 0, 2);

            /*--------------------------- kfc_frites -------------------------------------------------------------------------------*/

            Produit kfcFrite = new Produit(43, "Frite", 6, 35, 1, "kfc_frites", 0, 2);

            /*--------------------------- kfc_boissons -----------------------------------------------------------------------------*/

            Produit kfc_coca = new Produit(44, "CocaCola", 7, 27, 27, "mcdo_coca", 0, 2);
            Produit kfc_cocalight = new Produit(45, "CocaColaLight", 7, 27, 27, "mcdo_cocalight", 0, 2);
            Produit kfc_cocazero = new Produit(46, "CocaColaZero", 7, 27, 27, "mcdo_cocazero", 0, 2);
            Produit kfc_evian = new Produit(47, "Evian", 7, 27, 27, "mcdo_evian", 0, 2);
            Produit kfc_fanta = new Produit(48, "Fanta", 7, 27, 27, "mcdo_fanta", 0, 2);
            Produit kfc_icetea = new Produit(49, "IceTea", 7, 27, 27, "mcdo_icetea", 0, 2);
            Produit kfc_sprite = new Produit(50, "Sprite", 7, 27, 27, "mcdo_sprite", 0, 2);
            Produit kfc_spritezero = new Produit(60, "SpriteZero", 7, 27, 27, "mcdo_spritezero", 0, 2);

            /*--------------------------- kfc_desserts -----------------------------------------------------------------------------*/

            Produit kreamBall = new Produit(61, "KreamBall", 8, 50, 50, "kfc_ kreamball", 0, 2);


            /*-----------------------------DAO McDo --------------------------------------------------------------------------------*/
            produitDAO.ajouter(bigMac);
            produitDAO.ajouter(royalBacon);
            produitDAO.ajouter(royalCheese);
            produitDAO.ajouter(royalDeluxe);
            produitDAO.ajouter(tripleCheese);
            produitDAO.ajouter(premium);
            produitDAO.ajouter(mcwrapPoulet);
            produitDAO.ajouter(mcFirstb);
            produitDAO.ajouter(mcFirstp);
            produitDAO.ajouter(mcwrapChevre);
            produitDAO.ajouter(barbecue);
            produitDAO.ajouter(grande_deluxe);
            produitDAO.ajouter(grande_frite);
            produitDAO.ajouter(ketchup);
            produitDAO.ajouter(moutarde);
            produitDAO.ajouter(moy_deluxe);
            produitDAO.ajouter(moy_frite);
            produitDAO.ajouter(sauce_chinoise);
            produitDAO.ajouter(sauce_curry);
            produitDAO.ajouter(sauce_deluxe);
            produitDAO.ajouter(mcdo_coca);
            produitDAO.ajouter(mcdo_cocalight);
            produitDAO.ajouter(mcdo_cocazero);
            produitDAO.ajouter(mcdo_evian);
            produitDAO.ajouter(mcdo_fanta);
            produitDAO.ajouter(mcdo_icetea);
            produitDAO.ajouter(mcdo_sprite);
            produitDAO.ajouter(mcdo_spritezero);
            produitDAO.ajouter(ananas);
            produitDAO.ajouter(frappe);
            produitDAO.ajouter(mc_fleury);
            produitDAO.ajouter(patisseries);
            produitDAO.ajouter(very_parfait);

            /*------------------------------DAO KFC --------------------------------------------------------------------------------*/
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
            produitDAO.ajouter(kfc_coca);
            produitDAO.ajouter(kfc_cocalight);
            produitDAO.ajouter(kfc_cocazero);
            produitDAO.ajouter(kfc_evian);
            produitDAO.ajouter(kfc_fanta);
            produitDAO.ajouter(kfc_icetea);
            produitDAO.ajouter(kfc_sprite);
            produitDAO.ajouter(kfc_spritezero);



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