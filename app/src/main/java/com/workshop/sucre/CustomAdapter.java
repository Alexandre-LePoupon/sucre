package com.workshop.sucre;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.workshop.sucre.BDD.Categorie;
import com.workshop.sucre.BDD.Produit;
import com.workshop.sucre.BDD.ProduitDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 06/04/2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Categorie> dataSet;

    private Context mContext;
    private GridView gridview;
    private ProduitDAO pDao;
    private int fastfood;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;

        public MyViewHolder(View itemView, final GridView grid, final ProduitDAO pDao, final Context context, final int fastfood) {
            super(itemView);

            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(fastfood==1) {
                        grid.setAdapter(new ImageAdapter(context, pDao, getPosition()));
                    } else {
                        grid.setAdapter(new ImageAdapter(context, pDao, getPosition()+4));
                    }

                }
            });
        }
    }

    public CustomAdapter(List<Categorie> data, Context context, GridView gridView, ProduitDAO pDao, int fastfood) {
        this.dataSet = data;
        this.mContext = context;
        this.gridview = gridView;
        this.pDao = pDao;
        this.fastfood = fastfood;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categorie, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view, gridview, pDao, mContext, fastfood);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        try {
            imageView.setImageResource(mContext.getResources().getIdentifier(dataSet.get(listPosition).getImg(),  "drawable", mContext.getPackageName()));
        } catch (NullPointerException e) {
            //balek
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}
