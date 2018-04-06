package com.pachacama.examen.labcalificado_pachacama.adaptador;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.pachacama.examen.labcalificado_pachacama.DetailActivity;
import com.pachacama.examen.labcalificado_pachacama.R;
import com.pachacama.examen.labcalificado_pachacama.activities.ResultActivity;
import com.pachacama.examen.labcalificado_pachacama.modelo.Buscador;

import static android.content.ContentValues.TAG;

public class BuscadorAdapter extends RecyclerView.Adapter<BuscadorAdapter.ViewHolder> {


    private List<Buscador> buscadores;

    public void setBuscadores(List<Buscador> buscadores) {
        this.buscadores = buscadores;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView category;
        TextView name;
        TextView address;
        TextView phone;
        TextView email;
        TextView url;
        ImageView logo;
        TextView info;



        public ViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.categoria);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            url = itemView.findViewById(R.id.url);
            logo = itemView.findViewById(R.id.logo);
            info = itemView.findViewById(R.id.info);

        }
    }

    @Override
    public BuscadorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_busqueda, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Buscador buscador = buscadores.get(position);

        int resId = holder.itemView.getContext().getResources().getIdentifier(buscador.getLogo(), "drawable", holder.itemView.getContext().getPackageName());
        holder.logo.setImageResource(resId);

        //holder.id.setText(buscador.getId());
        holder.category.setText(buscador.getCategory());
        holder.name.setText(buscador.getName());
        holder.address.setText(buscador.getAddress());
        holder.phone.setText(buscador.getPhone());
        holder.email.setText(buscador.getEmail());
        holder.url.setText(buscador.getUrl());
        holder.info.setText(buscador.getInfo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                   holder.itemView.getContext().startActivity(intent);


            }


        });


    }

    @Override
    public int getItemCount() {
        return buscadores.size();
    }


}

