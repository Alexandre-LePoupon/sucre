package com.workshop.sucre;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.workshop.sucre.BDD.Categorie;
import com.workshop.sucre.BDD.CategorieDAO;
import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;
import com.workshop.sucre.BDD.ProtocoleDAO;

import java.util.ArrayList;
import java.util.List;

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

    private  RecyclerView  horizontal_recycler_view;
    private List<Categorie> horizontalList;
    private CustomAdapter horizontalAdapter;

    /*****************************************************************
     * 7
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! id a incrément pour les catégories
     *******************************************************************/
    int fastfood;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);

        Bundle b = getIntent().getExtras();
        fastfood = b.getInt("fastfood");

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

            Categorie mcdo_sandwichs = new Categorie(0, "Sandwichs", 1, "mcdo_nos_sandwichs");
            Categorie mcdo_frites = new Categorie(1, "Frites", 1, "mcdo_frites_sauces");
            Categorie mcdo_boissons = new Categorie(2, "Boissons", 1, "mcdo_nos_boissons");
            Categorie mcdo_desserts = new Categorie(3, "Desserts", 1, "mcdo_nos_desserts");

            categorieDAO.ajouter(mcdo_sandwichs);
            categorieDAO.ajouter(mcdo_frites);
            categorieDAO.ajouter(mcdo_boissons);
            categorieDAO.ajouter(mcdo_desserts);


            Categorie kfc_sandwichs = new Categorie(4, "Sandwichs", 2, "kfc_nos_sandwichs");
            Categorie kfc_menu_enfant = new Categorie(5, "Enfant", 2, "kfc_menu_enfant");
            Categorie kfc_boissons = new Categorie(6, "Boissons", 2, "kfc_nos_boissons");
            Categorie kfc_desserts = new Categorie(7, "Desserts", 2, "kfc_nos_desserts");

            categorieDAO.ajouter(kfc_sandwichs);
            categorieDAO.ajouter(kfc_menu_enfant);
            categorieDAO.ajouter(kfc_boissons);
            categorieDAO.ajouter(kfc_desserts);
        }

        if (produitDAO.selectionner(1) == null) {

            /*-------------------------------- McDo --------------------------------------------------------------------------------*/

            /*--------------------------- mcdo_Sandwichs ---------------------------------------------------------------------------*/

            Produit bigMac = new Produit(1, "BigMac", 0, 42, (float) 8.5, "mcdo_big_mac", 0, 1);
            Produit royalBacon = new Produit(2, "RoyalBacon", 0, 34, 8, "mcdo_royal_bacon", 0, 1);
            Produit royalCheese = new Produit(3, "RoyalCheese", 0, 37, (float) 9.5, "mcdo_royal_cheese", 0, 1);
            Produit royalDeluxe = new Produit(4, "RoyalDeluxe", 0, 33, 7, "mcdo_royal_deluxe", 0, 1);
            Produit tripleCheese = new Produit(5, "TripleCheese", 0, 32, 8, "mcdo_triple_cheese", 0, 1);
            Produit premium = new Produit(6, "Premium", 0, 56, 13, "mcdo_premiumpoulet", 0, 1);
            Produit mcwrapPoulet = new Produit(8, "McwrapPoulet", 0, 53, 4, "mcdo_mcwrap_poulet_bacon", 0, 1);
            Produit mcFirstb = new Produit(9, "McFirstBoeuf", 0, 32, (float) 6.2, "mcdo_mcfirstboeuf", 0, 1);
            Produit mcFirstp = new Produit(10, "McFirstPoisson", 0, 43, 7, "mcdo_mcfirstpoisson", 0, 1);
            Produit mcwrapChevre = new Produit(11, "McwrapChevre", 0, 58, 4, "mcdo_mcwrap_chevre", 0, 1);


            /*--------------------------- mcdo_frites ------------------------------------------------------------------------------*/
            Produit barbecue = new Produit(12, "barbecue", 1, 27, 27, "barbecue", 0, 1);
            Produit grande_deluxe = new Produit(13, "GrandeDeluxePotatoes", 1, 27, 27, "grande_deluxe", 0, 1);
            Produit grande_frite = new Produit(14, "GrandeFrite", 1, 27, 27, "grande_frite", 0, 1);
            Produit ketchup = new Produit(15, "Ketchup", 1, 27, 27, "ketchup", 0, 1);
            Produit moutarde = new Produit(16, "Moutarde", 1, 27, 27, "moutarde", 0, 1);
            Produit moy_deluxe = new Produit(17, "MoyennePotatoes", 1, 27, 27, "moy_deluxe", 0, 1);
            Produit moy_frite = new Produit(18, "MoyenneFrite", 1, 27, 27, "moy_frite", 0, 1);
            Produit sauce_chinoise = new Produit(19, "SauceChinoise", 1, 27, 27, "sauce_chinoise", 0, 1);
            Produit sauce_curry = new Produit(20, "SauceCurry", 1, 27, 27, "sauce_curry", 0, 1);
            Produit sauce_deluxe = new Produit(21, "SauceDeluxe", 1, 27, 27, "sauce_deluxe", 0, 1);


            /*--------------------------- mcdo_boissons ----------------------------------------------------------------------------*/

            Produit mcdo_coca = new Produit(22, "CocaCola", 2, 27, 27, "mcdo_coca", 0, 1);
            Produit mcdo_cocalight = new Produit(23, "CocaColaLight", 2, 27, 27, "mcdo_cocalight", 0, 1);
            Produit mcdo_cocazero = new Produit(24, "CocaColaZero", 2, 27, 27, "mcdo_cocazero", 0, 1);
            Produit mcdo_evian = new Produit(25, "Evian", 2, 27, 27, "mcdo_evian", 0, 1);
            Produit mcdo_fanta = new Produit(26, "Fanta", 2, 17, 17, "mcdo_fanta", 0, 1);
            Produit mcdo_icetea = new Produit(27, "IceTea", 2, 17, 17, "mcdo_icetea", 0, 1);
            Produit mcdo_sprite = new Produit(28, "Sprite", 2, 17, 17, "mcdo_sprite", 0, 1);
            Produit mcdo_spritezero = new Produit(29, "SpriteZero", 2, 27, 27, "mcdo_spritezero", 0, 1);


            /*--------------------------- mcdo_desserts ----------------------------------------------------------------------------*/

            Produit ananas = new Produit(30, "Ananas", 3,(float) 8.8,(float) 7.7, "ananas", 0, 1);
            Produit frappe = new Produit(31, "Frappe", 3, 33, 27, "frappe", 0, 1);
            Produit mc_fleury = new Produit(32, "McFlurry", 3, 41, 35, "mc_fleurry", 0, 1);
            Produit patisseries = new Produit(33, "Patisseries", 3, 45, 27, "patisseries", 0, 1);
            Produit very_parfait = new Produit(34, "VeryParfait", 3, 71, 65, "very_parfait", 0, 1);




            /*--------------------------------- KFC --------------------------------------------------------------------------------*/


            /*--------------------------- kfc_sandwichs ----------------------------------------------------------------------------*/

            Produit boxMaster = new Produit(35, "BoxMaster", 4, 59, 1, "kfc_boxmaster", 0, 2);
            Produit brazer = new Produit(36, "Brazer", 4, 37, 7, "kfc_brazer", 0, 2);
            Produit doubleSweatFire = new Produit(37, "DoubleSweatFire", 4, (float) 51.6, 0, "kfc_double_sweatandfire", 0, 2);
            Produit mixBucket = new Produit(38, "MixBucket", 4, (float) 22.5, 0, "kfc_mixbucket", 0, 2);
            Produit saladeBrazer = new Produit(39, "SaladeBrazer", 4, (float) 5.5, 0, "kfc_salade_brazer", 0, 2);
            Produit saladeCrispy = new Produit(40, "SaladeCrispy", 4, (float) 8.9, 0, "kfc_salade_crispy", 0, 2);
            Produit tenders = new Produit(41, "Tenders", 4, 26, (float) 0.1, "kfc_tenders", 0, 2);
            Produit theBoss = new Produit(42, "TheBoss", 4, (float) 41.7, 0, "kfc_theboss", 0, 2);

            /*--------------------------- kfc_frites -------------------------------------------------------------------------------*/

            Produit kfcFrite = new Produit(43, "Frite", 5, 35, 1, "kfc_frites", 0, 2);

            /*--------------------------- kfc_boissons -----------------------------------------------------------------------------*/

            Produit kfc_coca = new Produit(44, "CocaCola", 6, 27, 27, "mcdo_coca", 0, 2);
            Produit kfc_cocalight = new Produit(45, "CocaColaLight", 6, 27, 27, "mcdo_cocalight", 0, 2);
            Produit kfc_cocazero = new Produit(46, "CocaColaZero", 6, 27, 27, "mcdo_cocazero", 0, 2);
            Produit kfc_evian = new Produit(47, "Evian", 6, 27, 27, "mcdo_evian", 0, 2);
            Produit kfc_fanta = new Produit(48, "Fanta", 6, 17, 17, "mcdo_fanta", 0, 2);
            Produit kfc_icetea = new Produit(49, "IceTea", 6, 17, 17, "mcdo_icetea", 0, 2);
            Produit kfc_sprite = new Produit(50, "Sprite", 6, 17, 17, "mcdo_sprite", 0, 2);
            Produit kfc_spritezero = new Produit(60, "SpriteZero", 6, 27, 27, "mcdo_spritezero", 0, 2);

            /*--------------------------- kfc_desserts -----------------------------------------------------------------------------*/

            Produit kreamBall = new Produit(61, "KreamBall", 7, 50, 50, "kfc_kreamball", 0, 2);


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

        //View categorie
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.listcategorie);
        horizontalList = new ArrayList<Categorie>();

        if(fastfood==1) {
            for (int i = 1; i < 5; i++) {
                horizontalList.add(categorieDAO.selectionner(i));
            }
        } else {
            for (int i = 5; i < 9; i++) {
                horizontalList.add(categorieDAO.selectionner(i));
            }
        }

        horizontalAdapter=new CustomAdapter(horizontalList,Produits.this, gridview, produitDAO, fastfood);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(Produits.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        if(fastfood == 1) {
            gridview.setAdapter(new ImageAdapter(this, produitDAO, 0));
        } else {
            gridview.setAdapter(new ImageAdapter(this, produitDAO, 4));
        }



        /**
         * initialisation de la grid view + ajout de l'adaptateur +++ list view
         */

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
                Produit temp1 = ((ImageAdapter) gridview.getAdapter()).getProduct(position);


                for (int j = 0; j < produitDAO.getSize(); j++) {
                    if (produitDAO.selectionner(j + 1).getNom().compareTo(temp1.getNom()) == 0) {
                        Produit temp = produitDAO.selectionner(j + 1);
                        if (temp.getQuantite() == 0 && temp.getFastfood()==fastfood) {
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
                if (itemValue.compareTo("Remise à zéro") == 0 && position != 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Supprimer la liste ?");
                    builder.setTitle("Réinitialisation de la liste");
                    builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            for (int j = 0; j < produitDAO.getSize(); j++)
                            {
                                if(fastfood==produitDAO.selectionner(j+1).getFastfood())
                                {
                                    Produit temp = produitDAO.selectionner(j + 1);
                                    temp.setQuantite(0);
                                    produitDAO.modifier(temp);
                                }
                            }
                            actualiseProduitToList();
                        }
                    });
                    builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    for (j = 0; j < produitDAO.getSize(); j++) {
                        Produit temp = produitDAO.selectionner(j + 1);
                        if (itemValue.compareTo(temp.getNom()) == 0 && temp.getFastfood()==fastfood) {
                            final Dialog dialog = new Dialog(getActivity());
                            dialog.setContentView(R.layout.dialog_quantite);
                            dialog.setTitle("Modifier les quantitées");

                            // set the custom dialog components - text, image and button
                            Button banul = (Button) dialog.findViewById(R.id.dialog_annuler);
                            Button bmodif = (Button) dialog.findViewById(R.id.dialog_modifier);
                            SeekBar sb = (SeekBar) dialog.findViewById(R.id.seekBar);
                            ((TextView) dialog.findViewById(R.id.textChangeQuantite)).setText(" X "+temp.getQuantite());

                            banul.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            bmodif.setOnClickListener(new SelecteurQuantiteValideClicListener(temp,produitDAO,dialog,getThis(),sb));


                            sb.setProgress((int)(temp.getQuantite()*4));

                            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    TextView tv= (TextView) dialog.findViewById(R.id.textChangeQuantite);
                                    tv.setText("X "+((float)progress)/4);
                                }
                                public void onStartTrackingTouch(SeekBar seekBar) {
                                }
                                public void onStopTrackingTouch(SeekBar seekBar) {
                                }
                            });
                            dialog.show();


                        }
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

            findViewById(R.id.listViewData).getLayoutParams().height =(int) (300.0*((ListView)findViewById(R.id.listViewData)).getResources().getDisplayMetrics().density);

           
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

        if (valueActuelL >= protocolDAO.selectionner(1).getLent()) {
            ImageView img1 = (ImageView) findViewById(R.id.img1);

            img1.setVisibility(View.VISIBLE);
        } else {
            ImageView img1 = (ImageView) findViewById(R.id.img1);

            img1.setVisibility(View.INVISIBLE);
        }

        if (valueActuelR >= protocolDAO.selectionner(1).getRapide()) {
            ImageView img2 = (ImageView) findViewById(R.id.img2);

            img2.setVisibility(View.VISIBLE);
        } else {
            ImageView img2 = (ImageView) findViewById(R.id.img2);

            img2.setVisibility(View.INVISIBLE);
        }
    }

    public Activity getActivity() {
        return this;
    }
    public Produits getThis()
    {
        return  this;
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
            if (temp.getQuantite() > 0&& temp.getFastfood()==fastfood) {
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