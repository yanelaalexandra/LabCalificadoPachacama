package com.pachacama.examen.labcalificado_pachacama.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pachacama.examen.labcalificado_pachacama.R;
import com.pachacama.examen.labcalificado_pachacama.adaptador.BuscadorAdapter;
import com.pachacama.examen.labcalificado_pachacama.repositorio.BuscadorRepository;


public class ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BuscadorAdapter buscadorAdapter = new BuscadorAdapter();
        buscadorAdapter.setBuscadores(BuscadorRepository.getList());

        recyclerView.setAdapter(buscadorAdapter);
    }
}
