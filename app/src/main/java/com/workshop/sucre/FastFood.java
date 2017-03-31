package com.workshop.sucre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FastFood extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_fastfood);
    }

    public void produits (View view) {
        startActivity(new Intent(this, Produits.class));
    }
}
