package com.workshop.sucre;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

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
    private Integer[] mThumbIds;

    public ImageAdapter(Context c, ProduitDAO produitDAO, int categorie) {
        mContext = c;

        for(int i = 1; i<=produitDAO.getSize(); i++) {
            Produit tmp = produitDAO.selectionnerCategorie(i,categorie);
            if (tmp != null) {
                listProd.add(tmp);
            }
        }

        mThumbIds = new Integer[listProd.size()];
        for(int j = 0; j<listProd.size(); j++) {
            mThumbIds[j] = mContext.getResources().getIdentifier(listProd.get(j).getImg(),  "drawable", mContext.getPackageName());
        }
    }

    public Produit getProduct(int id) {
        return listProd.get(id);
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
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams((int)(140*metrics.density),(int)(110*metrics.density)));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,45);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
