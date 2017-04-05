package com.workshop.sucre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.workshop.sucre.BDD.FastFoodBDD;
import com.workshop.sucre.BDD.FastFoodDAO;

public class FastFood extends AppCompatActivity {

    public FastFoodDAO fastFoodDAO = new FastFoodDAO(this);

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_fastfood);
        fastFoodDAO.open();

        if(fastFoodDAO.selectionner(1) == null) {
            FastFoodBDD mcdo = new FastFoodBDD(1,"Macdo","fast_food_mcdo");
            FastFoodBDD kfc = new FastFoodBDD(2,"KFC","fast_food_kfc");
            FastFoodBDD quick = new FastFoodBDD(3,"Macdo","fast_food_quick");
            FastFoodBDD burgerKing = new FastFoodBDD(4,"Macdo","fast_food_burger_king");
            FastFoodBDD speedBurger = new FastFoodBDD(5,"Macdo","fast_food_speed_burger");
            FastFoodBDD vf = new FastFoodBDD(6,"Macdo","fast_food_vf");

            fastFoodDAO.ajouter(mcdo);
            fastFoodDAO.ajouter(kfc);
            fastFoodDAO.ajouter(quick);
            fastFoodDAO.ajouter(burgerKing);
            fastFoodDAO.ajouter(speedBurger);
            fastFoodDAO.ajouter(vf);
        }
    }

    public void produits (View view) {
        startActivity(new Intent(this, Produits.class));
    }
}
