package com.workshop.sucre;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_down_black_24dp;
import static com.workshop.sucre.R.drawable.ic_keyboard_arrow_up_black_24dp;

public class Produits extends AppCompatActivity{


    TextView txt_help_gest;
    ScrollView scrool_view1;
    ImageButton imgbutton1;
    GridLayout extendMenu1;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_help_gest = (TextView) findViewById(R.id.txt_help_gest);
        imgbutton1 = (ImageButton) findViewById(R.id.imageButton17);
        extendMenu1 = (GridLayout) findViewById(R.id.extendMenu);
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
}
