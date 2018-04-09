package com.pachacama.examen.labcalificado_pachacama.adaptador;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.pachacama.examen.labcalificado_pachacama.activities.DetailActivity;
import com.pachacama.examen.labcalificado_pachacama.R;
import com.pachacama.examen.labcalificado_pachacama.modelo.Buscador;

public class BuscadorAdapter extends RecyclerView.Adapter<BuscadorAdapter.ViewHolder> {


    private List<Buscador> buscadores;

    public void setBuscadores(List<Buscador> buscadores) {
        this.buscadores = buscadores;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView category;
        TextView name;
        TextView address;        TextView phone;
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


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_busqueda, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Buscador buscador = buscadores.get(position);

        int resId = holder.itemView.getContext().getResources().getIdentifier(buscador.getLogo(), "drawable", holder.itemView.getContext().getPackageName());
        holder.logo.setImageResource(resId);


        holder.category.setText(buscador.getCategory());
        holder.name.setText(buscador.getName());
        holder.address.setText(buscador.getAddress());
        holder.phone.setText(buscador.getPhone());
        holder.email.setText(buscador.getEmail());
        holder.url.setText(buscador.getUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("name", buscador.getName());
                intent.putExtra("info", buscador.getInfo());
                intent.putExtra("phone", buscador.getPhone());
                intent.putExtra("url", buscador.getUrl());
                intent.putExtra("email", buscador.getEmail());
                holder.itemView.getContext().startActivity(intent);

            }


        });


    }

    @Override
    public int getItemCount() {
        return buscadores.size();
    }

    public void filterList(ArrayList<Buscador> busca) {
        buscadores = busca;
        notifyDataSetChanged();
    }


}

