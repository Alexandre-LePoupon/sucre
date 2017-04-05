package com.workshop.sucre;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 05/04/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Produit> listProd = new ArrayList<Produit>();
    private int id = 0;
    private Integer[] mThumbIds;

    public ImageAdapter(Context c, ProduitDAO produitDAO) {
        mContext = c;
        //TODO : Ajouter filtre categorie, fastfood
        for(int i = 1; i<=produitDAO.getSize(); i++) {
            listProd.add(produitDAO.selectionner(i));
        }
        //TODO : Recuperation id
        id = mContext.getResources().getIdentifier(listProd.get(0).getImg(),  "drawable", mContext.getPackageName());
        mThumbIds = new Integer[1];
        mThumbIds[0]=id;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
